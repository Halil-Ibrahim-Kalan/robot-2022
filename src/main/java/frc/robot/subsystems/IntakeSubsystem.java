// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  private final PWMVictorSPX intake;

  public IntakeSubsystem() {
    intake = new PWMVictorSPX(IntakeConstants.PWMPort);
  }

  public void runIntake(double speed){
    intake.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
