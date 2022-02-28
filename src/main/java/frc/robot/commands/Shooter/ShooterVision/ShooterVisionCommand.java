// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Shooter.ShooterVision;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class ShooterVisionCommand extends CommandBase {
  /** Creates a new ShooterVisionCommand. */
  private final ShooterSubsystem shooter;
  private final VisionSubsystem vision;
  final double speed;
  double area;

  public ShooterVisionCommand(ShooterSubsystem shooter, VisionSubsystem vision, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shooter = shooter;
    this.vision = vision;
    this.speed = speed;
    addRequirements(this.shooter, this.vision);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    area = vision.getArea();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
