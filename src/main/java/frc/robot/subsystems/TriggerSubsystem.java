// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.TriggerConstants;

public class TriggerSubsystem extends SubsystemBase {
  /** Creates a new TriggerSubsystem. */
  private final VictorSPX trigger; 

  public TriggerSubsystem() {
    trigger = new VictorSPX(TriggerConstants.deviceID);
  }

  public void runTrigger(double speed){
    trigger.set(VictorSPXControlMode.PercentOutput, speed);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
