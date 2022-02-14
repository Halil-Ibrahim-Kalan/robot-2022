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
  private final VictorSPX motor;
  private final Encoder encoder;
  
  public TurretSubsystem() {
    motor = new VictorSPX(TurretConstants.deviceID);
    motor.setInverted(TurretConstants.InvertedMode);
    encoder = new Encoder(TurretConstants.Encoder.channelA, TurretConstants.Encoder.channelB, TurretConstants.Encoder.reverseDirection);
  }

  public void runTurret(double speed) {
    // -1 saat yönünde
    // +1 saat yönünün tersinde
    motor.set(VictorSPXControlMode.PercentOutput, speed);
  }

  public void resetEncoder() {
    encoder.reset();
  }

  public double getDistanceTraveled() {
    //distance per pulse is pi* (wheel diameter / counts per revolution)
    encoder.setDistancePerPulse(Math.PI*TurretConstants.Encoder.motorWheel/TurretConstants.Encoder.cpr);
    return encoder.getDistance() * (TurretConstants.Encoder.motorWheel / TurretConstants.Encoder.turretWheel);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Turret Encoder", getDistanceTraveled());
  }
}
