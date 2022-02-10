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
  public LEDSubsystem() {
    m_led = new AddressableLED(LEDConstants.PWMPort);
    m_ledBuffer = new AddressableLEDBuffer(LEDConstants.LEDBuffer);
    m_led.setLength(m_ledBuffer.getLength());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
        m_ledBuffer.setRGB(i, LEDConstants.Red, LEDConstants.Green, LEDConstants.Blue);
    }
    m_led.setData(m_ledBuffer);
    m_led.start();
  }
}