from networktables import NetworkTables
import time
import logging
import numpy as np

logging.basicConfig(level=logging.DEBUG)
NetworkTables.initialize(server='roborio-4972-frc.local')
vision_nt = NetworkTables.getTable('Vision')
time.sleep(0.5)

while True:
    vision_nt.putNumber('target_x', arr)
    vision_nt.putNumber('target_y', 1)