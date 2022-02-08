// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.Auto.Autonomous;
import frc.robot.commands.Drive.JoystickDriveCommand;
import frc.robot.commands.Funnel.FunnelCommand;
import frc.robot.commands.Intake.IntakeGroupCommand;
import frc.robot.commands.Shooter.ShooterCommand;
import frc.robot.commands.Turret.TurretCommand;
import frc.robot.commands.Turret.TurretReset;
import frc.robot.commands.Turret.TurretVisionCommand;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.FunnelSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.PDPSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
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
  public Joystick m_driverController = new Joystick(Constants.JoystickConstants.F310);
  public Joystick m_operatorController = new Joystick(Constants.JoystickConstants.Panel);
  
  //Subsystem
  public final ClimbSubsystem m_climb = new ClimbSubsystem();
  public final FunnelSubsystem m_funnel = new FunnelSubsystem();
  public final IntakeSubsystem m_intake = new IntakeSubsystem();
  public final PDPSubsystem m_pdp = new PDPSubsystem();
  public final ShooterSubsystem m_shooter = new ShooterSubsystem();
  public final TurretSubsystem m_turret = new TurretSubsystem();
  public final VisionSubsystem m_vision = new VisionSubsystem();
  public final DriveSubsystem m_robotDrive = new DriveSubsystem();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_robotDrive.setDefaultCommand(new JoystickDriveCommand(m_robotDrive,() -> m_driverController.getRawAxis(1),() -> m_driverController.getRawAxis(4)));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Top Alma, Taşıma
    new JoystickButton(m_driverController, 5).whileHeld(new IntakeGroupCommand(m_intake, m_funnel));

    // Top Taşıma
    new JoystickButton(m_driverController, 4).whileHeld(new FunnelCommand(m_funnel, 1));
    
    // Top Atma
    new JoystickButton(m_driverController, 2).whileHeld(new ShooterCommand(m_shooter, 1));

    // Top Taşıma
    new JoystickButton(m_driverController, 1).whileHeld(new FunnelCommand(m_funnel, -1));

    // Turret Reset
    new JoystickButton(m_driverController, 7).whenPressed(new TurretReset(m_turret));
    
    // Turret Auto
    new JoystickButton(m_driverController, 3).whenPressed(new TurretVisionCommand(m_turret, m_vision));
    
    // Turret Kontrol
    new POVButton(m_driverController, 270).whileHeld(new TurretCommand(m_turret, 1));
    new POVButton(m_driverController, 90).whileHeld(new TurretCommand(m_turret, -1));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new Autonomous(m_robotDrive, m_funnel, m_shooter, m_turret, m_vision);
  }
}
