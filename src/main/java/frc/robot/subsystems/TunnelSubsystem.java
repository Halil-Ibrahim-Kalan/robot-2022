// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.TunnelConstants;

public class TunnelSubsystem extends SubsystemBase {
  /** Creates a new TunnelSubsystem. */
  private final PWMVictorSPX tunnel;

  public TunnelSubsystem() {
    tunnel = new PWMVictorSPX(TunnelConstants.PWMPort);
    tunnel.setInverted(true);
  }

  public void runTunnel(double speed){
    tunnel.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
