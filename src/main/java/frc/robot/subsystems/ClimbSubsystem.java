// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import frc.robot.Constants.ClimbConstants;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbSubsystem extends SubsystemBase {
  /** Creates a new ClimbSubsystem. */
  CANSparkMax leftClimb = new CANSparkMax(ClimbConstants.Left.deviceID, ClimbConstants.Left.motorType);
  CANSparkMax rightClimb = new CANSparkMax(ClimbConstants.Right.deviceID, ClimbConstants.Right.motorType);

  // PWM Output
  PWMVictorSPX LeftWindow = new PWMVictorSPX(ClimbConstants.Left.windowPort);
  PWMVictorSPX RightWindow = new PWMVictorSPX(ClimbConstants.Right.windowPort);
  
  public ClimbSubsystem() { }
  
  public void runLeftClimb(double speed) {
    leftClimb.set(speed);
  }

  public void setVoltageLeftClimb(double voltage) {
    leftClimb.setVoltage(voltage);
  }

  public void runRightClimb(double m_speed) {
    rightClimb.set(m_speed);
  }

  public void setVoltageRightClimb(double m_voltage) {
    rightClimb.setVoltage(m_voltage);
  }

  public void runLeftWindow(double m__speed) {
    LeftWindow.set(m__speed);
  }

  public void runRightWindow(double m___speed) {
    RightWindow.set(m___speed);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
