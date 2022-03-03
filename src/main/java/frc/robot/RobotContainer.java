// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.util.net.PortForwarder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.Auto.AutoClimb.AutoClimbCommand;
import frc.robot.commands.Auto.AutoClimb.AutoWindowCommand;
import frc.robot.commands.Climb.LeftClimbCommand;
import frc.robot.commands.Climb.LeftWindowCommand;
import frc.robot.commands.Climb.RightClimbCommand;
import frc.robot.commands.Climb.RightWindowCommand;
import frc.robot.commands.Drive.DriveCommand;
import frc.robot.commands.Intake.IntakeCommandGroup;
import frc.robot.commands.Shooter.ShooterCommand;
import frc.robot.commands.Trigger.TriggerCommand;
import frc.robot.commands.Tunnel.TunnelCommand;
import frc.robot.commands.Turret.TurretCommand;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.TunnelSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LEDSubsystem;
import frc.robot.subsystems.PDPSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TriggerSubsystem;
import frc.robot.subsystems.TurretSubsystem;
import frc.robot.subsystems.VisionSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  //Joystick
  public Joystick f310 = new Joystick(Constants.JoystickConstants.F310);
  public Joystick panel = new Joystick(Constants.JoystickConstants.Panel);
  public Joystick panel2 = new Joystick(Constants.JoystickConstants.Panel2);
  
  //Subsystem
  public final ClimbSubsystem climb = new ClimbSubsystem();
  public final TunnelSubsystem tunnel = new TunnelSubsystem();
  public final IntakeSubsystem intake = new IntakeSubsystem();
  public final PDPSubsystem pdp = new PDPSubsystem();
  public final ShooterSubsystem shooter = new ShooterSubsystem();
  public final TurretSubsystem turret = new TurretSubsystem();
  public final VisionSubsystem vision = new VisionSubsystem();
  public final DriveSubsystem drive = new DriveSubsystem();
  public final LEDSubsystem led = new LEDSubsystem();
  public final TriggerSubsystem trigger = new TriggerSubsystem();


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    PortForwarder.add(5800, "photonvision.local", 5800);
    // Configure the button bindings
    configureButtonBindings();
    
    // Drive
    drive.setDefaultCommand(new DriveCommand(drive, () -> f310.getRawAxis(1), () -> -f310.getRawAxis(4), false));
    shooter.setDefaultCommand(new ShooterCommand(shooter, () -> f310.getRawAxis(3)));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Auto Ball
    // new JoystickButton(f310, 1).whileHeld(new AutoBall(turret, shooter, trigger, tunnel, 0.38, 1));
    // new JoystickButton(panel, 6).whileHeld(new AutoVisionBall(turret, vision, shooter, trigger, tunnel, 0.5, 1));
    // new JoystickButton(panel, 1).whileHeld(new MiddleCommand(turret, vision));
   
    // Intake and Tunnel
    new JoystickButton(f310, 6).whileHeld(new IntakeCommandGroup(intake, tunnel, -1));
    new JoystickButton(f310, 5).whileHeld(new IntakeCommandGroup(intake, tunnel, 1));

    // Tunnel
    new JoystickButton(f310, 2).whileHeld(new TunnelCommand(tunnel, 1));

    // Trigger
    new JoystickButton(f310, 3).whileHeld(new TriggerCommand(trigger, 1));

    // Turret
    new POVButton(f310, 270).whileHeld(new TurretCommand(turret, 1));
    new POVButton(f310, 90).whileHeld(new TurretCommand(turret, -1));

    // Climb Left
    new JoystickButton(panel2, 9).whileHeld(new LeftClimbCommand(climb, 1));
    new JoystickButton(panel2, 4).whileHeld(new LeftClimbCommand(climb, -1));
    new JoystickButton(panel, 7).whileHeld(new LeftWindowCommand(climb, 1));
    new JoystickButton(panel, 5).whileHeld(new LeftWindowCommand(climb, -1));
    
    // Climb Right
    new JoystickButton(panel2, 7).whileHeld(new RightClimbCommand(climb, 1));
    new JoystickButton(panel2, 8).whileHeld(new RightClimbCommand(climb, -1));
    new JoystickButton(panel, 12).whileHeld(new RightWindowCommand(climb, -1));
    new JoystickButton(panel, 11).whileHeld(new RightWindowCommand(climb, 1));

    // Climb Auto
    new JoystickButton(panel, 9).whileHeld(new AutoWindowCommand(climb, 1));
    new JoystickButton(panel, 10).whileHeld(new AutoWindowCommand(climb, -1));
    new JoystickButton(panel2, 5).whileHeld(new AutoClimbCommand(climb, 1));
    new JoystickButton(panel2, 10).whileHeld(new AutoClimbCommand(climb, -1));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
