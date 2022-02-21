// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimbConstants;;

public class ClimbSubsystem extends SubsystemBase {
  /** Creates a new ClimbSubsystem. */
  private final CANSparkMax leftClimb;
  private final CANSparkMax rightClimb;

  private final Spark leftWindow;
  private final Spark rightWindow;

  public ClimbSubsystem() {
    leftClimb = new CANSparkMax(ClimbConstants.Climb.Left.deviceID, MotorType.kBrushed);
    rightClimb = new CANSparkMax(ClimbConstants.Climb.Right.deviceID, MotorType.kBrushed);

    leftWindow = new Spark(ClimbConstants.Window.PWMLeft);
    rightWindow = new Spark(ClimbConstants.Window.PWMRight);
  }

  public void runLeftClimb(double speed) {
    leftClimb.set(speed);
  }

  public void setVoltageLeftClimb(double voltage) {
    leftClimb.setVoltage(voltage);
  }

  public void runRightClimb(double speed) {
    rightClimb.set(speed);
  }

  public void setVoltageRightClimb(double voltage) {
    rightClimb.setVoltage(voltage);
  }

  public void runLeftWindow(double speed) {
    leftWindow.set(speed);
  }

  public void runRightWindow(double speed) {
    rightWindow.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
