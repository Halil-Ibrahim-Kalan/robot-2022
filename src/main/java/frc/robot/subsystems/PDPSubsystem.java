// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PDPSubsystem extends SubsystemBase {
  /** Creates a new PDPSubsystem. */
  private PowerDistribution PDP;
  private double voltage;
  private double current;
  private double power;
  private double energy;
  private double temp;
  private double shooter;
  private double turret;
  private double funnel;
  private double intake;
  private double climb1;
  private double climb2;

  public PDPSubsystem() {
    PDP = new PowerDistribution();
  }
  //voltaj
  public double getVoltage(){
    voltage = PDP.getVoltage();
    return voltage;
  }
  //toplam akım
  public double getTotalCurrent(){
    current = PDP.getTotalCurrent();
    return current;
  }
  //toplam güç
  public double getTotalPower(){
    power = PDP.getTotalPower();
    return power;
  }
  //toplam enerji
  public double getTotalEnergy(){
    energy = PDP.getTotalEnergy();
    return energy;
  }
  //sıcaklık
  public double getTemperature(){
    temp = PDP.getTemperature();
    return temp;
  }
  //shooter akım
  public double getVictorShooter(){
    shooter = PDP.getCurrent(0);
    return shooter;
  }
  //turret akım
  public double getVictorTurret(){
    turret = PDP.getCurrent(1);
    return turret;
  }
  //funnel akım
  public double getVictorFunnel(){
    funnel = PDP.getCurrent(2);
    return funnel;
  }
  //intake akım
  public double getVictorIntake(){
    intake = PDP.getCurrent(3);
    return intake;
  }
  //climb2 akım
  public double getVictorClimb2(){
    climb2 = PDP.getCurrent(4);
    return climb2;
  }
  //climb1 akım
  public double getVictorClimb(){
    climb1 = PDP.getCurrent(5);
    return climb1;
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
    SmartDashboard.putNumber("funnel current", getVictorFunnel());
    SmartDashboard.putNumber("intake current", getVictorIntake());
    SmartDashboard.putNumber("climb2 current", getVictorClimb2());
    SmartDashboard.putNumber("climb1 current", getVictorClimb());
  }
}
