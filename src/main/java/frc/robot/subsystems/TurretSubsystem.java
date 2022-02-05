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
  // PPR: Devir başına gerekli darbe sayısı (pulses per revolution )
  // CPR: Devir başına üretilen ölçüm sayısı (Counts per Revolution) | SF * PRR
  // SF: Ölçek faktörü (ScaleFactor)
  // DPP: Darbe başına alınan mesafe (Distance Per Pulse) (cm) | πR / PRR
  // C: Üretilen darbe sayısı (Count) |  L * SF / DPP
  // L: Motor şaftının aldığı yol (cm) | C * DPP / SF
  // Motor milinin çevresi (cm) | πR
  // Motor milinin tur sayısı | C / CPR

  private final VictorSPX motor;
  private final Encoder encoder;
  private final double DPP = Math.PI * TurretConstants.Encoder.kMotorShaft / TurretConstants.Encoder.kPPR;
  public TurretSubsystem() {
    motor = new VictorSPX(TurretConstants.deviceID);
    motor.setInverted(TurretConstants.InvertedMode);
    encoder = new Encoder(
      TurretConstants.Encoder.channelA,
      TurretConstants.Encoder.channelB,
      TurretConstants.Encoder.reverseDirection,
      Encoder.EncodingType.k4X
    );
  }

  public void runTurret(double speed) {
    motor.set(VictorSPXControlMode.PercentOutput, speed);
  }

  public void resetEncoder() {
    encoder.reset();
  }

  public double getDistanceTraveled() {
    encoder.setDistancePerPulse(DPP);
    return encoder.getDistance();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Turret Encoder", getDistanceTraveled());
    SmartDashboard.putNumber("TurretValue", motor.getMotorOutputPercent());
  }
}
