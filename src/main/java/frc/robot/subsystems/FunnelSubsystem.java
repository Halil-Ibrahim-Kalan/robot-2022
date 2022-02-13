// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.Constants.FunnelConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FunnelSubsystem extends SubsystemBase {
  /** Creates a new FunnelSubsystem. */
  VictorSPX motor;
  public FunnelSubsystem() {
    motor = new VictorSPX(FunnelConstants.deviceID);
    motor.setInverted(FunnelConstants.InvertedMode);
  }

  public void runFunnel(double speed){
    motor.set(VictorSPXControlMode.PercentOutput, speed);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
