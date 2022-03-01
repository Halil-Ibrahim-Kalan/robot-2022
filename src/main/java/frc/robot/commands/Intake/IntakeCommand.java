// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase {
  /** Creates a new IntakeCommand. */
  private final IntakeSubsystem intake;
  private final double speed;
  public IntakeCommand(IntakeSubsystem intake, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.intake = intake;
    this.speed = speed;
    addRequirements(this.intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.runIntake(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.runIntake(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
