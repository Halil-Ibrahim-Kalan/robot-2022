// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
  public boolean isAtSetpoint;
  private final PWMVictorSPX shooter;
  private double speed;
  private double voltage;

  public ShooterSubsystem() {
    shooter = new PWMVictorSPX(ShooterConstants.PWMPort);
    isAtSetpoint = false;
    speed = 0;
    voltage = 0;
  }

  public void runShooter(double speed){
    this.speed = speed; 
    shooter.set(speed);
  }

  public void runShooterVoltage(double voltage) {
    this.voltage = voltage;
    shooter.setVoltage(voltage);
  }

  public double getSpeed() {
    return speed;
  }

  public double getVoltage() {
    return voltage;
  }

  public boolean hasRunning() {
    return getSpeed() != 0 || getVoltage() != 0;
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("shooter/running", hasRunning());
    SmartDashboard.putNumber("shooter/Speed", getSpeed());
    SmartDashboard.putBoolean("shooter/Setpoint", isAtSetpoint);

  }
}
