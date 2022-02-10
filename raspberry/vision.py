from cscore import CameraServer
from networktables import NetworkTables

import cv2
import json
import numpy as np
import time

def main():
   with open('/boot/frc.json') as f:
      config = json.load(f)
   camera = config['cameras'][0]

   width = camera['width']
   height = camera['height']
   center = int(col / 2)
   rangeHSV = [[65,85],[65,255],[200,255]]
   minHSV = np.array([65, 65, 200])
   maxHSV = np.array([85,255,255])
   target_x = 0
   target_y = 0
   
   CameraServer.startAutomaticCapture()
   input_stream = CameraServer.getVideo()
   output_stream = CameraServer.putVideo('Processed', width, height)

   vision_nt = NetworkTables.getTable('Vision')

   img = np.zeros(shape=(240, 320, 3), dtype=np.uint8)

   time.sleep(0.5)

   while True:
      start_time = time.time()

      frame_time, input_img = input_stream.grabFrame(img)
      output_img = np.copy(input_img)

      if frame_time == 0:
         output_stream.notifyError(input_stream.getError())
         continue

       hsv_frame = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)
       mask = cv2.inRange(hsv_frame, minHSV, maxHSV)

       contours = cv2.findContours(mask, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)[0]
       contours = sorted(contours, key=lambda x: cv2.contourArea(x), reverse=True)

       for contour  in contours:
           if cv2.contourArea(contour) < 15:
               continue
           cv2.drawContours(frame, contour, -1, color = (255, 255, 255), thickness = -1)

           rect = cv2.minAreaRect(contour)
           center, size, angle = rect
           center = tuple([int(dim) for dim in center])
           cv2.drawContours(frame, [cv2.boxPoints(rect).astype(int)], -1, color = (0, 0, 255), thickness = 2)
           cv2.circle(frame, center = center, radius = 3, color = (0, 0, 255), thickness = -1)
           target_x = ((center[0] - width / 2) / (width / 2))
           target_y = ((center[1] - height / 2) / (height / 2))
           break

      vision_nt.putNumber('target_x', target_x)
      vision_nt.putNumber('target_y', target_y)

      processing_time = time.time() - start_time
      fps = 1 / processing_time
      cv2.putText(output_img, str(round(fps, 1)), (0, 40), cv2.FONT_HERSHEY_SIMPLEX, 1, (255, 255, 255))
      output_stream.putFrame(output_img)

main()