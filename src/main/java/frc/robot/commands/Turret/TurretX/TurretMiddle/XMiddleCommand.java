// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Turret.TurretX.TurretMiddle;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class XMiddleCommand extends CommandBase {
  /** Creates a new TurretMiddleCommand. */
  private final TurretSubsystem turret;
  private final VisionSubsystem vision;

  public XMiddleCommand(TurretSubsystem turret, VisionSubsystem vision) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.turret = turret; 
    this.vision = vision;
    addRequirements(this.turret,this.vision);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    turret.runTurretX(-vision.getX() / 16);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    turret.runTurretX(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return vision.getX() == 0 || !vision.hasTarget();
  }
}
