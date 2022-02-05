// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADIS16448_IMU;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GyroImuSubsystem extends SubsystemBase {
  /** Creates a new GyroImuSubsystem. */
  private final ADIS16448_IMU gyro;
  
  public GyroImuSubsystem() {
    gyro = new ADIS16448_IMU();
  }

  public void calibrate(){
    gyro.calibrate();
  }

  public void reset(){
    gyro.reset();
  }

  public double getAngle(){
    return  gyro.getAngle();
  }

  public double getRate() {
  
    return gyro.getRate();
  }
  
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
