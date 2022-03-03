// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auto.AutoBall;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.TriggerSubsystem;
import frc.robot.subsystems.TunnelSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoTunnelTrigger extends SequentialCommandGroup {
  /** Creates a new AutoTunnelTrigger. */
  public AutoTunnelTrigger(TunnelSubsystem tunnel, TriggerSubsystem trigger, double speed) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new ParallelCommandGroup(
        new RunCommand(() -> trigger.runTrigger(speed), trigger),
        new RunCommand(() -> tunnel.runTunnel(speed), tunnel)
      ){
        @Override
        public void end(boolean interrupted){
          trigger.runTrigger(0);
          tunnel.runTunnel(0);
        }
      }
    );
  }
}
