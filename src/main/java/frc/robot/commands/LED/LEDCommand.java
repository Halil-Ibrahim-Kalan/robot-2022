// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.LED;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotState;
import frc.robot.RobotState.State;
import frc.robot.subsystems.LEDSubsystem;

public class LEDCommand extends CommandBase {
  /** Creates a new LEDCommand. */
  private State lastState = RobotState.State.DISABLED;
  private final LEDSubsystem led;
  public LEDCommand(LEDSubsystem led) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.led = led;
    addRequirements(this.led);
  }
  public void update(RobotState.State state){
    switch(state){
      case DISABLED:
        led.lightTheLED(255, 0, 0);
      case ENABLED:
        led.rainbow();
      case VISION:
        led.lightTheLED(0, 255, 0);
    }
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (lastState != Robot.state.getState())
    {
      lastState = Robot.state.getState();
      update(Robot.state.getState());
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
