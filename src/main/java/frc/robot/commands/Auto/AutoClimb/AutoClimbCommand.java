// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auto.AutoClimb;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.ClimbSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoClimbCommand extends ParallelCommandGroup {
  /** Creates a new AutoClimbCommand. */
  private final ClimbSubsystem climb;
  public AutoClimbCommand(ClimbSubsystem climb, double speed) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    this.climb = climb;
    addCommands(
      new RunCommand(() -> climb.runAutoClimb(speed), climb)
    );
  }

  @Override
  public void end(boolean interrupted){
    climb.runAutoClimb(0);
  }
}
