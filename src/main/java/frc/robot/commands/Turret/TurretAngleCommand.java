// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretSubsystem;

public class TurretAngleCommand extends CommandBase {
  /** Creates a new autoturret. */
  private final TurretSubsystem m_turret;
  private final double m_speed;
  private final double m_angle;
  private double head;
  private boolean IsFinished = false;

  public TurretAngleCommand(TurretSubsystem turret, double speed, double angle) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_turret = turret;
    m_speed = speed;
    m_angle = angle;
    addRequirements(m_turret);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    head=m_turret.getDistanceTraveled();
    if (m_angle>0) {
      while (m_turret.getDistanceTraveled()<head+m_angle) {
        m_turret.runTurret(-(m_speed));
      }
    }
    else if (m_angle<0) {
      while (m_turret.getDistanceTraveled()>head+m_angle) {
        m_turret.runTurret(m_speed);
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
