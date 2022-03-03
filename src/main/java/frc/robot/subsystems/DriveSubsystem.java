// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  private final ADXRS450_Gyro gyro;
  private final PWMTalonSRX left, right;
  private final DifferentialDrive drive;

  public DriveSubsystem() {
    // Use addRequirements() here to declare subsystem dependencies.
    gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS2);
    left = new PWMTalonSRX(DriveConstants.LeftMotor);
    right = new PWMTalonSRX(DriveConstants.RightMotor);
    left.setInverted(true);
    drive = new DifferentialDrive(left, right);
  }
  public void arcadeDrive(double fwd, double rot){
    drive.arcadeDrive(fwd, rot,true);
  }

  public void tankDrive(double l, double r){
    drive.tankDrive(l, r);
  }

  public void GyroCalibrate(){
    gyro.calibrate();
  }

  public double GyroGetRate(){
    return gyro.getRate();
  }

  public double GyroGetAngle(){
    return gyro.getAngle();
  }

  public void zeroHeading() {
    gyro.reset();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Gyro Rate", GyroGetRate());
    SmartDashboard.putNumber("Gyro Angle", GyroGetAngle());
  }
}
