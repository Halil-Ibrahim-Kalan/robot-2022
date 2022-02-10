// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.Constants.IntakeConstants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  VictorSPX motor;
  public IntakeSubsystem() {
    motor = new VictorSPX(IntakeConstants.deviceID);
    motor.setInverted(IntakeConstants.InvertedMode);
  }

  public void runIntake(double speed){
    motor.set(VictorSPXControlMode.PercentOutput, speed);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
