// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretSubsystem;

public class TurretCommand extends CommandBase {
  /** Creates a new TurretCommand. */
  private final TurretSubsystem m_turret;
  private final double m_speed;
  private boolean IsFinished = false;

  public TurretCommand(TurretSubsystem turret, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_turret = turret;
    m_speed = speed;
    addRequirements(m_turret);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_speed!=0 && m_turret.getDistanceTraveled() > -4.1 && m_turret.getDistanceTraveled() < 4.1) {
      m_turret.runTurret(m_speed);
    }
    else {
      IsFinished = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_turret.runTurret(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return IsFinished;
  }
}
