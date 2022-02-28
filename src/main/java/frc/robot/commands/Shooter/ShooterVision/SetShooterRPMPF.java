// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Shooter.ShooterVision;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Robot;
import frc.robot.RobotState;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.ShooterSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class SetShooterRPMPF extends PIDCommand {
  /** Creates a new SetShooterRPMPF. */
  private ShooterSubsystem m_shooter;
  private static final SimpleMotorFeedforward m_shooterFeedForward = new SimpleMotorFeedforward(ShooterConstants.kS,
      ShooterConstants.kV, ShooterConstants.kA);
  private static double m_motorOutput;
  private boolean isInterruptable;

  public SetShooterRPMPF(double targetRPM, ShooterSubsystem shooter, boolean _isInterruptable) {
    super(
        // The controller that the command will use
        new PIDController(ShooterConstants.kShootP, ShooterConstants.kShootI, ShooterConstants.kShootD),
        // This should return the measurement
        shooter::getSpeed,
        // This should return the setpoint (can also be a constant)
        targetRPM,
        // This uses the output
        output -> {
          // Use the output here
          m_motorOutput = output + m_shooterFeedForward.calculate(targetRPM);
          shooter.runShooterVoltage(-m_motorOutput);
        });
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
    getController().setTolerance(50);
    m_shooter = shooter;
    this.isInterruptable = _isInterruptable;
    addRequirements(m_shooter);
  }

  @Override
  public void initialize() {
    super.initialize();
    Robot.state.update(RobotState.State.VISION);
    m_motorOutput = 0;
  }

  @Override
  public void execute() {
    super.execute();
    m_shooter.isAtSetpoint = getController().atSetpoint();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (isInterruptable && getController().atSetpoint()) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void end(boolean interrupted) {
    super.end(interrupted);
    if (!isInterruptable) {
      m_shooter.runShooterVoltage(0);
      m_shooter.isAtSetpoint = false;
    }
  }
}
