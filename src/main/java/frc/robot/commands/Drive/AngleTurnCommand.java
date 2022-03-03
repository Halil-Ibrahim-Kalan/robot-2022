// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IMUSubsystem;

public class AngleTurnCommand extends CommandBase {
  /** Creates a new TurnCommand. */
  private final DriveSubsystem drive;
  private final IMUSubsystem gyro;
  private final double angle;
  private double head;
  private boolean IsFinished = false;
  public AngleTurnCommand(DriveSubsystem drive, IMUSubsystem  gyro, double angle) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drive = drive;
    this.gyro = gyro;
    this.angle = angle;
    addRequirements(this.drive,this.gyro);
  }

  public void RightTurn(){
    while (gyro.getAngle() >= head-angle){
      drive.tankDrive(-0.4, -0.4);
    }
  }

  public void LeftTurn(){
    while (gyro.getAngle() <= head+angle){
      drive.tankDrive(0.4, 0.4);
    }
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    gyro.calibrate();
    head = gyro.getAngle();
    
    if (angle<0) LeftTurn();
    else if (angle>0) RightTurn();
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
