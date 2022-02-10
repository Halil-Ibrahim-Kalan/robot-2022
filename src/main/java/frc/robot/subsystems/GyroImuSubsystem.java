// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GyroImuSubsystem extends SubsystemBase {
  /** Creates a new GyroImuSubsystem. */
  private final ADXRS450_Gyro gyro;

  public GyroImuSubsystem() {
    gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS2);
  }

  public void calibrate(){
    gyro.calibrate();
  }

  public void zeroHeading(){
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
    SmartDashboard.putNumber("Gyro Rate", getRate());
    SmartDashboard.putNumber("Gyro Angle", getAngle());
  }
}
