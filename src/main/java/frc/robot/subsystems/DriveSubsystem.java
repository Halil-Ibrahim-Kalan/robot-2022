// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  private final PWMTalonSRX m_left;
  private final PWMTalonSRX m_right;
  private final DifferentialDrive m_drive;
  private final ADXRS450_Gyro m_gyro;

  public DriveSubsystem() {
    m_gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS2);
    m_left = new PWMTalonSRX(DriveConstants.LeftMotor);
    m_right = new PWMTalonSRX(DriveConstants.RightMotor);
    m_drive = new DifferentialDrive(m_left, m_right);
    zeroHeading();
  }

  public void arcadeDrive(double fwd, double rot){
    m_drive.arcadeDrive(fwd, rot,true);
  }

  public void tankDrive(double l, double r){
    m_drive.tankDrive(l, r);
  }

  public void GyroCalibrate(){
    m_gyro.calibrate();
  }

  public double GyroGetRate(){
    return m_gyro.getRate();
  }

  public double GyroGetAngle(){
    return m_gyro.getAngle();
  }

  public void zeroHeading() {
    m_gyro.reset();
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Gyro Rate", GyroGetRate());
    SmartDashboard.putNumber("Gyro Angle", GyroGetAngle());
  }
}
