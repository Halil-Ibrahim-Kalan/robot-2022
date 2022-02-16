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
  AddressableLED m_led;
  AddressableLEDBuffer m_ledBuffer;
  int m_rainbowFirstPixelHue;
  public LEDSubsystem() {
    m_led = new AddressableLED(LEDConstants.PWMPort);
    m_ledBuffer = new AddressableLEDBuffer(LEDConstants.LEDBuffer);
    m_led.setLength(m_ledBuffer.getLength());
  }

  public static void wait(int ms)
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
  private void rainbow() {
    for (var i = 0; i < 12; i++) {
      final var hue = (m_rainbowFirstPixelHue + (i * 180 / 12)) % 180;
      m_ledBuffer.setHSV(i, hue, 255, 255);
    }
    m_rainbowFirstPixelHue += 5;
    m_rainbowFirstPixelHue %= 180;
    wait(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
        m_ledBuffer.setRGB(i, LEDConstants.Red, LEDConstants.Green, LEDConstants.Blue);
    }
    // rainbow();

    m_led.setData(m_ledBuffer);
    m_led.start();
  }
}
