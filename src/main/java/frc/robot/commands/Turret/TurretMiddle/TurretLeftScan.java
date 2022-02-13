// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Turret.TurretMiddle;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class TurretLeftScan extends CommandBase {
  /** Creates a new TurretLeftScan. */
  private final TurretSubsystem m_turret;
  private final VisionSubsystem m_vision;
  
  public TurretLeftScan(TurretSubsystem turret, VisionSubsystem vision) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_turret = turret; 
    m_vision = vision;
    addRequirements(m_turret,m_vision);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    while (m_turret.getDistanceTraveled()>=-90){
      if (m_vision.hasTarget()) return;
      m_turret.runTurret(0.8);
    }
    while (m_turret.getDistanceTraveled()<=90){
      if (m_vision.hasTarget()) return;
      m_turret.runTurret(-0.8);
    }
    while (m_turret.getDistanceTraveled()>=0){
      if (m_vision.hasTarget()) return;
      m_turret.runTurret(0.8);
    }
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
    return false;
  }
}
