// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auto.AutoTurret;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Turret.TurretMiddle.MiddleCommand;
import frc.robot.commands.Turret.TurretScan.LeftScanCommand;
import frc.robot.subsystems.LEDSubsystem;
import frc.robot.subsystems.TurretSubsystem;
import frc.robot.subsystems.VisionSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class LeftScanTurret extends SequentialCommandGroup {
  /** Creates a new ScanMiddleTurret. */
  public LeftScanTurret(TurretSubsystem turret, VisionSubsystem vision, LEDSubsystem led) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new LeftScanCommand(turret, vision, led),
      new MiddleCommand(turret, vision)
    );
  }
}
