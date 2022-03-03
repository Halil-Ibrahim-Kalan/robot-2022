// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretSubsystem;

public class TurretAngleCommand extends CommandBase {
  /** Creates a new autoturret. */
  private final TurretSubsystem turret;
  private final double speed;
  private final double angle;
  private double head;
  private boolean IsFinished = false;

  public TurretAngleCommand(TurretSubsystem turret, double speed, double angle) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.turret = turret;
    this.speed = speed;
    this.angle = angle;
    addRequirements(this.turret);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    head=turret.getDistanceTraveled();
    if (angle>0) {
      while (turret.getDistanceTraveled()<head+angle) {
        turret.runTurret(-(speed));
      }
    }
    else if (angle<0) {
      while (turret.getDistanceTraveled()>head+angle) {
        turret.runTurret(speed);
      }
    }
    IsFinished=true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return IsFinished;
  }
}
