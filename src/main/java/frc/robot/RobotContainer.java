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
import frc.robot.commands.Auto.Autonomous;
import frc.robot.commands.Drive.DriveCommand;
import frc.robot.commands.Drive.MotorTryCommand;
import frc.robot.commands.Funnel.FunnelCommand;
import frc.robot.commands.Intake.IntakeCommand;
import frc.robot.commands.Intake.IntakeCommandGroup;
import frc.robot.commands.Shooter.ShooterCommand;
import frc.robot.commands.Trigger.TriggerCommand;
import frc.robot.commands.Turret.TurretX.TurretXCommand;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.FunnelSubsystem;
import frc.robot.subsystems.IMUSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LEDSubsystem;
import frc.robot.subsystems.MotorTrySubsystem;
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
  
  //Subsystem
  public final ClimbSubsystem climb = new ClimbSubsystem();
  public final FunnelSubsystem funnel = new FunnelSubsystem();
  public final IntakeSubsystem intake = new IntakeSubsystem();
  public final PDPSubsystem pdp = new PDPSubsystem();
  public final ShooterSubsystem shooter = new ShooterSubsystem();
  public final TurretSubsystem turret = new TurretSubsystem();
  public final VisionSubsystem vision = new VisionSubsystem();
  public final DriveSubsystem drive = new DriveSubsystem();
  public final LEDSubsystem led = new LEDSubsystem();
  public final IMUSubsystem imu = new IMUSubsystem();
  public final TriggerSubsystem trigger = new TriggerSubsystem();
  public final MotorTrySubsystem motorTry = new MotorTrySubsystem();


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    PortForwarder.add(5800, "photonvision.local", 5800);
    // Configure the button bindings
    configureButtonBindings();
    
    // Drive
    drive.setDefaultCommand(new DriveCommand(drive, () -> -f310.getRawAxis(1), () -> f310.getRawAxis(4), false));
    
    // Intake
    intake.setDefaultCommand(new IntakeCommand(intake, () -> f310.getRawAxis(3)));

    // Motor Try
    motorTry.setDefaultCommand(new MotorTryCommand(motorTry, () -> f310.getRawAxis(0)));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Intake and Funnel
    new JoystickButton(f310, 5).whileHeld(new IntakeCommandGroup(intake, funnel, 1));

    // Shooter
    new JoystickButton(panel, 12).whileHeld(new ShooterCommand(shooter, 1));

    // Funnel
    new JoystickButton(panel, 9).whileHeld(new FunnelCommand(funnel, 1));
    new JoystickButton(panel, 10).whileHeld(new FunnelCommand(funnel, -1));

    // Trigger
    new JoystickButton(panel, 7).whileHeld(new TriggerCommand(trigger, 1));
    new JoystickButton(panel, 5).whileHeld(new TriggerCommand(trigger, -1));

    // Intake Reverse
    new JoystickButton(f310, 4).whileHeld(new IntakeCommand(intake, () -> -1));

    // Turret
    new POVButton(f310, 270).whileHeld(new TurretXCommand(turret, 1));
    new POVButton(f310, 90).whileHeld(new TurretXCommand(turret, -1));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new Autonomous(drive, funnel, shooter, turret, vision, climb, imu, intake, led, trigger);
  }
}
