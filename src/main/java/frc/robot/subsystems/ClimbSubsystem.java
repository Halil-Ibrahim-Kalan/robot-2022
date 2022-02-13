// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import frc.robot.Constants.ClimbConstants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbSubsystem extends SubsystemBase {
  /** Creates a new ClimbSubsystem. */
  private final CANSparkMax m_front = new CANSparkMax(ClimbConstants.Front.deviceID, ClimbConstants.Front.motorType);
  private final CANSparkMax  m_back = new CANSparkMax(ClimbConstants.Back.deviceID, ClimbConstants.Back.motorType);
  
  public ClimbSubsystem() { }
  
  public void runClimbFront(double speed) {
    m_front.set(speed);
  }

  public void runClimbBack(double m_speed) {
    m_back.set(m_speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
