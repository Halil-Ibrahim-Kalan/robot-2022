import cv2
import numpy as np
from networktables import NetworkTables
import time
import logging
import numpy as np

logging.basicConfig(level=logging.DEBUG)
NetworkTables.initialize(server='roborio-4972-frc.local')
vision_nt = NetworkTables.getTable('Vision')

cap = cv2.VideoCapture(1)
cap.set(3, 480)
cap.set(4, 320)
_, frame = cap.read()
cols = frame.shape[1]

x_medium = int(cols / 2)
center = int(cols / 2)
time.sleep(0.5)

while True:
    _, frame = cap.read()
    hsv_frame = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)

    low_red = np.array([161, 155, 84])
    high_red = np.array([179, 255, 255])
    red_mask = cv2.inRange(hsv_frame, low_red, high_red)
    contours = cv2.findContours(red_mask, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)[0]
    contours = sorted(contours, key=lambda x: cv2.contourArea(x), reverse=True)

    for cnt in contours:
        (x, y, w, h) = cv2.boundingRect(cnt)

        x_medium = int((x + x + w) / 2)
        break
 
    if x_medium < center -30:
        position += 1
    elif x_medium > center + 30:
        position -= 1

    cv2.line(frame, (x_medium, 0), (x_medium, 480), (0, 255, 0), 2)
    cv2.line(frame, (x_medium, 0), (x_medium, 480), (0, 255, 0), 2)

    cv2.imshow("Frame", frame)
    key = cv2.waitKey(1) & 0xFF

    if key == 27 or key == ord("q"):
        break

cap.release()
