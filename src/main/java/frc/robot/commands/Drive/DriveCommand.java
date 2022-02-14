// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {
  /** Creates a new JoystickDriveCommand. */
  private final DriveSubsystem m_drive;
  private final DoubleSupplier m_left;
  private final DoubleSupplier m_right;
  private final boolean m_tankDrive;
  public DriveCommand(DriveSubsystem drive, DoubleSupplier left, DoubleSupplier right, boolean tankDrive) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drive = drive;
    m_left = left;
    m_right = right;
    m_tankDrive = tankDrive;
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_tankDrive) {
      m_drive.tankDrive(m_left.getAsDouble(), m_right.getAsDouble());
    }
    else {
      m_drive.arcadeDrive(m_left.getAsDouble(), m_right.getAsDouble());
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
