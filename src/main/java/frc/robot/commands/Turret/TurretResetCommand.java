// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretSubsystem;

public class TurretResetCommand extends CommandBase {
  /** Creates a new TurretResetCommand. */
  private final TurretSubsystem m_turret;
  private boolean IsFinished=false;
  public TurretResetCommand(TurretSubsystem turret) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_turret = turret; 
    addRequirements(m_turret);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (m_turret.getDistanceTraveled()<0){
      while (m_turret.getDistanceTraveled()<0){
        m_turret.runTurret(-0.8);
      }
    }
    else if (m_turret.getDistanceTraveled()>0){
      while (m_turret.getDistanceTraveled()>0){
        m_turret.runTurret(0.8);
      }
    }
    m_turret.resetEncoder();
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