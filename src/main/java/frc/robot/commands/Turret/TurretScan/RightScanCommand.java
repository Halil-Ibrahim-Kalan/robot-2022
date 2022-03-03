// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Turret.TurretScan;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class RightScanCommand extends CommandBase {
  /** Creates a new TurretRightScan. */
  private final TurretSubsystem turret;
  private final VisionSubsystem vision;
  private Boolean IsFinished = false;
  
  public RightScanCommand(TurretSubsystem turret, VisionSubsystem vision) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.turret = turret; 
    this.vision = vision;
    addRequirements(this.turret,this.vision);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    while (turret.getDistanceTraveled()<=90){
      if (vision.hasTarget()) IsFinished = true;
      turret.runTurret(-0.8);
    }
    while (turret.getDistanceTraveled()>=-90){
      if (vision.hasTarget()) IsFinished = true;
      turret.runTurret(0.8);
    }
    while (turret.getDistanceTraveled()<=0){
      if (vision.hasTarget()) IsFinished = true;
      turret.runTurret(-0.8);
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
    return IsFinished;
  }
}
