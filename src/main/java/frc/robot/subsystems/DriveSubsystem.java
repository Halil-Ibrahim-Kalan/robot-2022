// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  PWMTalonSRX m_left;
  PWMTalonSRX m_right;
  DifferentialDrive m_drive;
  public DriveSubsystem() {
    m_left = new PWMTalonSRX(DriveConstants.LeftMotor);
    m_right = new PWMTalonSRX(DriveConstants.RightMotor);
    m_drive = new DifferentialDrive(m_left, m_right);
    //m_left.setInverted(DriveConstants.LeftMotorInverted);
  }

  public void arcadeDrive(double fwd, double rot){
    m_drive.arcadeDrive(fwd, rot,true);
  }

  public void tankDrive(double l, double r){
    m_drive.tankDrive(l, r);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
