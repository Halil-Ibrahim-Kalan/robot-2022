// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.TurretConstants;

public class TurretSubsystem extends SubsystemBase {
  /** Creates a new TurretSubsystem. */
  private final VictorSP turret;
  private final Encoder encoder;
  private final double motorWheel = 3 / 2.54; //  (1 inch 2.54cm)
  private final double turretWheel = 35 / 2.54;
  private final double cpr = 7; // ppr 7
  
  public TurretSubsystem() {
    turret = new VictorSP(TurretConstants.PWMPort);
    turret.setInverted(true);
    encoder = new Encoder(
      TurretConstants.Encoder.channelA, 
      TurretConstants.Encoder.channelB, 
      TurretConstants.Encoder.reverseDirection
    );                                          
  }

  public void runTurret(double speed) {
    turret.set(speed);
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
