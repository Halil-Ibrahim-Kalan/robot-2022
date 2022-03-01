// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Climb;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbSubsystem;

public class RightClimbCommand extends CommandBase {
  /** Creates a new RightClimb. */
  private final ClimbSubsystem climb;
  private final double speed;
  
  public RightClimbCommand(ClimbSubsystem climb,double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.climb=climb;
    this.speed=speed;
    addRequirements(this.climb);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    climb.runRightClimb(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climb.runRightClimb(0);
  }
  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
