// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auto.AutoShooter;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;
import frc.robot.RobotState;
import frc.robot.commands.Shooter.ShooterVision.SetShooterRPMPF;
import frc.robot.subsystems.ShooterSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoShooterCommand extends SequentialCommandGroup {
  /** Creates a new AutoShooterCommand. */
  public AutoShooterCommand(ShooterSubsystem shooter) {
    Robot.state.update(RobotState.State.VISION);
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new SetShooterRPMPF(3500, shooter, false));
  }
}
