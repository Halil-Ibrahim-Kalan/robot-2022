// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroImuSubsystem;

public class AngleTurnCommand extends CommandBase {
  /** Creates a new TurnCommand. */
  private final DriveSubsystem m_drive;
  private final GyroImuSubsystem m_gyro;
  private final double m_angle;
  private double head;
  private boolean IsFinished = false;
  public AngleTurnCommand(DriveSubsystem drive, GyroImuSubsystem  gyro, double angle) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drive = drive;
    m_gyro = gyro;
    m_angle = angle;
    addRequirements(m_drive,m_gyro);
  }

  public void RightTurn(){
    while (m_gyro.getAngle() >= head-m_angle){
      m_drive.tankDrive(-0.4, -0.4);
    }
  }

  public void LeftTurn(){
    while (m_gyro.getAngle() <= head+m_angle){
      m_drive.tankDrive(0.4, 0.4);
    }
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_gyro.calibrate();
    head = m_gyro.getAngle();
    
    if (m_angle<0) LeftTurn();
    else if (m_angle>0) RightTurn();
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
