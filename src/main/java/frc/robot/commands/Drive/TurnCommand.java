// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroImuSubsystem;

public class TurnCommand extends CommandBase {
  /** Creates a new TurnCommand. */
  private final DriveSubsystem m_drive;
  private final GyroImuSubsystem m_gyro;
  private double head;
  private boolean IsFinished = false;
  public TurnCommand(DriveSubsystem drive, GyroImuSubsystem  gyro) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drive = drive;
    m_gyro = gyro;
    addRequirements(m_drive,m_gyro);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_gyro.calibrate();
    head = m_gyro.getAngle();
    while (m_gyro.getAngle() <= head+90){
      m_drive.tankDrive(0.4, 0.4);
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
