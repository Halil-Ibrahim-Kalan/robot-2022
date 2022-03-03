// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Trigger.TriggerCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.TriggerSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class IntakeTriggerCommandGroup extends SequentialCommandGroup {
  /** Creates a new IntakeTriggerCommandGroup. */
  public IntakeTriggerCommandGroup(IntakeSubsystem intake, TriggerSubsystem trigger, double speed) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new IntakeCommand(intake, speed).alongWith(new TriggerCommand(trigger, speed))

    );
  }
}
