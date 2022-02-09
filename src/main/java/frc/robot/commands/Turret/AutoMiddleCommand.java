// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class AutoMiddleCommand extends CommandBase {
  /** Creates a new AutoMiddleCommand. */
  private final TurretSubsystem m_turret;
  private final VisionSubsystem m_vision;
  private double error;
  private boolean IsFinished=false;
  private boolean m_bool;
  public AutoMiddleCommand(TurretSubsystem turret, VisionSubsystem vision, boolean bool) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_bool=bool;
    this.m_turret = turret; 
    this.m_vision = vision;
    addRequirements(m_turret,m_vision);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(!m_bool){
      error = m_vision.getX();
      if(error != 0){
        m_turret.runTurret(-(error/16));
        IsFinished = false;
      }
      else{
        m_turret.runTurret(0);
        IsFinished = true;
      }
    }
    else {
      if (m_turret.getDistanceTraveled()<0){
        while (m_turret.getDistanceTraveled()<0){
          m_turret.runTurret(-0.8);
        }
        IsFinished=true;
      }
      else if (m_turret.getDistanceTraveled()>0){
        while (m_turret.getDistanceTraveled()>0){
          m_turret.runTurret(0.8);
        }
        IsFinished=true;
      }
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
