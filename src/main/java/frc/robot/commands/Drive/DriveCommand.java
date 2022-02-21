// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {
  /** Creates a new JoystickDriveCommand. */
  private final DriveSubsystem drive;
  private final DoubleSupplier left;
  private final DoubleSupplier right;
  private final boolean tankDrive;

  public DriveCommand(DriveSubsystem drive, DoubleSupplier left, DoubleSupplier right, boolean tankDrive) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drive = drive;
    this.left = left;
    this.right = right;
    this.tankDrive = tankDrive;
    addRequirements(this.drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (tankDrive) {
      drive.tankDrive(left.getAsDouble(), right.getAsDouble());
    }
    else {
      drive.arcadeDrive(left.getAsDouble(), right.getAsDouble());
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
