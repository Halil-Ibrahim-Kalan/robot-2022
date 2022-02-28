// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.TurretConstants;

public class TurretSubsystem extends SubsystemBase {
  /** Creates a new TurretSubsystem. */
  private final VictorSPX turretX;
  private final VictorSPX turretY;
  private final Encoder encoder;
  private final double motorWheel = 3 / 2.54; //  (1 inch 2.54cm)
  private final double turretWheel = 35 / 2.54;
  private final double cpr = 7; // ppr 7
  
  public TurretSubsystem() {
    turretX = new VictorSPX(TurretConstants.deviceID);
    turretY = new VictorSPX(TurretConstants.deviceIDy);
    encoder = new Encoder(
      TurretConstants.Encoder.channelA, 
      TurretConstants.Encoder.channelB, 
      TurretConstants.Encoder.reverseDirection
    );
  }

  public void runTurretX(double speed) {
    turretX.set(VictorSPXControlMode.PercentOutput, speed);
  }

  public void runTurretY(double speed) {
    turretY.set(VictorSPXControlMode.PercentOutput, speed);
  }

  public void resetEncoder() {
    encoder.reset();
  }

  public double getDistanceTraveled() {
    //distance per pulse is pi* (wheel diameter / counts per revolution)
    encoder.setDistancePerPulse(Math.PI*motorWheel/cpr);
    return encoder.getDistance() * (motorWheel / turretWheel);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Turret Encoder", getDistanceTraveled());
  }
}
