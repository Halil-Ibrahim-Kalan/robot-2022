// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroImuSubsystem;

public class ForwardCommand extends CommandBase {
  /** Creates a new ForwardCommand. */
  DriveSubsystem m_drive;
  GyroImuSubsystem m_gyro;
  double error;
  double m_right;
  double m_left;
  public ForwardCommand(DriveSubsystem drive, GyroImuSubsystem gyro, double left, double right ) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drive = drive;
    m_gyro = gyro;
    m_right = right;
    m_left = left;
    addRequirements(drive,gyro);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    error = 90 - m_gyro.getAngle();
    m_drive.tankDrive(m_left * error, m_right * error);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
