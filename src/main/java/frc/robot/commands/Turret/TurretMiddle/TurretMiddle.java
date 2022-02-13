// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Turret.TurretMiddle;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class TurretMiddle extends CommandBase {
  /** Creates a new TurretMiddleCommand. */
  private final TurretSubsystem m_turret;
  private final VisionSubsystem m_vision;

  public TurretMiddle(TurretSubsystem turret, VisionSubsystem vision) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_turret = turret; 
    m_vision = vision;
    addRequirements(m_turret,m_vision);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_turret.runTurret(-m_vision.getX() / 16);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_vision.getX() == 0 || !m_vision.hasTarget();
  }
}
