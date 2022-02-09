// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class TurretVisionCommand extends CommandBase {
  /** Creates a new TurretVisionCommand. */
  private final TurretSubsystem m_turret;
  private final VisionSubsystem m_vision;
  private double head;
  private double count;
  private boolean IsFinished=false;
  public TurretVisionCommand(TurretSubsystem turret, VisionSubsystem vision) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.m_turret = turret; 
    this.m_vision = vision;
    addRequirements(m_turret,m_vision);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    head=m_turret.getDistanceTraveled();
    count=1;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (!(m_vision.hasTarget()) && count==1){
      while (m_turret.getDistanceTraveled()<=head+90){
        m_turret.runTurret(-0.8);
        if (m_vision.hasTarget()){
          break;
        }
      }
      while (m_turret.getDistanceTraveled()>=head-90){
        m_turret.runTurret(0.8);
        if (m_vision.hasTarget()){
          break;
        }
      }
      while (m_turret.getDistanceTraveled()<=head){
        m_turret.runTurret(-0.8);
        if (m_vision.hasTarget()){
          break;
        }
      }
      count++;
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
    return (IsFinished);
  }
}
