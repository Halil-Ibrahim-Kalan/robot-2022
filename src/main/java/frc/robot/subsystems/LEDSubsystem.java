// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LEDConstants;

public class LEDSubsystem extends SubsystemBase {
  /** Creates a new LEDSubsystem. */
  private final AddressableLED led;
  private final AddressableLEDBuffer ledBuffer;
  private int rainbowFirstPixelHue;

  public LEDSubsystem() {
    led = new AddressableLED(LEDConstants.PWMPort);
    ledBuffer = new AddressableLEDBuffer(60);
    led.setLength(ledBuffer.getLength());
  }
  
  private static void wait(int ms)
  {
      try
      {
          Thread.sleep(ms);
      }
      catch(InterruptedException ex)
      {
          Thread.currentThread().interrupt();
      }
  }
  
  public void rainbow() {
    for (var i = 0; i < 12; i++) {
      final var hue = (rainbowFirstPixelHue + (i * 180 / 12)) % 180;
      ledBuffer.setHSV(i, hue, 255, 255);
    }
    rainbowFirstPixelHue += 5;
    rainbowFirstPixelHue %= 180;
    wait(0);
  }

  public void lightTheLED(int red, int green, int blue) {
    for (var i = 0; i < ledBuffer.getLength(); i++) {
      ledBuffer.setRGB(i, red, green, blue);
    }
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
       lightTheLED(0, 255, 0);       
    led.setData(ledBuffer);
    led.start();
  }
}
