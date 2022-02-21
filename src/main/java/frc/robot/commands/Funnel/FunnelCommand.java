// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Funnel;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FunnelSubsystem;

public class FunnelCommand extends CommandBase {
  /** Creates a new FunnelCommand. */
  private final FunnelSubsystem funnel;
  private final double speed;
  
  public FunnelCommand(FunnelSubsystem funnel, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.funnel=funnel;
    this.speed=speed;
    addRequirements(this.funnel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    funnel.runFunnel(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    funnel.runFunnel(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
