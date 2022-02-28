// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PDPSubsystem extends SubsystemBase {
  /** Creates a new PDPSubsystem. */
  private PowerDistribution PDP;

  public PDPSubsystem() {
    PDP = new PowerDistribution(0, ModuleType.kCTRE);

  }

  public double getVoltage(){
    return PDP.getVoltage();
  }

  public double getTotalCurrent(){
    return PDP.getTotalCurrent();
  }

  public double getTotalPower(){
    return PDP.getTotalPower();
  }

  public double getTotalEnergy(){
    return PDP.getTotalEnergy();
  }

  public double getTemperature(){
    return PDP.getTemperature();
  }

  public double getVictorShooter(){
    return PDP.getCurrent(0);
  }

  public double getVictorTurret(){
    return PDP.getCurrent(1);
  }

  public double getVictorTunnel(){
    return PDP.getCurrent(2);
  }

  public double getVictorIntake(){
    return PDP.getCurrent(3);
  }

  public double getVictorClimb2(){
    return PDP.getCurrent(4);
  }

  public double getVictorClimb(){
    return PDP.getCurrent(5);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("voltage", getVoltage());
    SmartDashboard.putNumber("total current", getTotalCurrent());
    SmartDashboard.putNumber("total power", getTotalPower());
    SmartDashboard.putNumber("total energy", getTotalEnergy());
    SmartDashboard.putNumber("temperature", getTemperature());
    SmartDashboard.putNumber("shooter current", getVictorShooter());
    SmartDashboard.putNumber("turret current", getVictorTurret());
    SmartDashboard.putNumber("tunnel current", getVictorTunnel());
    SmartDashboard.putNumber("intake current", getVictorIntake());
    SmartDashboard.putNumber("climb2 current", getVictorClimb2());
    SmartDashboard.putNumber("climb1 current", getVictorClimb());
    
  }
}
