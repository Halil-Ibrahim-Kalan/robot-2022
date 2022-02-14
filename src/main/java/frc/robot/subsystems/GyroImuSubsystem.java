// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADIS16448_IMU;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GyroImuSubsystem extends SubsystemBase {
  /** Creates a new imuImuSubsystem. */
  private final ADIS16448_IMU  imu;

  public GyroImuSubsystem() {
    imu = new ADIS16448_IMU();
  }

  public void calibrate(){
    imu.calibrate();
  }

  public void zeroHeading(){
    imu.reset();
  }

  public double getAngle(){
    return  imu.getAngle();
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
    SmartDashboard.putNumber("imu Rate", getRate());
    SmartDashboard.putNumber("imu Angle", getAngle());
    SmartDashboard.putNumber("imu Rate X", getAngle());
  }
}
