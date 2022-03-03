// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADIS16448_IMU;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IMUSubsystem extends SubsystemBase {
  /** Creates a new IMUSubsystem. */
  private final ADIS16448_IMU  imu;

  public IMUSubsystem() {
    imu = new ADIS16448_IMU();
  }

  public void calibrate(){
    imu.calibrate();
  }

  public void zeroHeading(){
    imu.reset();
  }

  public double getAngle(){
    return imu.getAngle();
  }

  public double getRate() {
    return imu.getRate();
  }
  
  public double getRateX(){
    return imu.getGyroRateX();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("IMU Rate", getRate());
    SmartDashboard.putNumber("IMU Angle", getAngle());
    SmartDashboard.putNumber("IMU Rate X Axes", getAngle());
  }
}
