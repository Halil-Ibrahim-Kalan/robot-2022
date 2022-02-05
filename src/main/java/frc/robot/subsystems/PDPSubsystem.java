// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PDPSubsystem extends SubsystemBase {
  /** Creates a new PDPSubsystem. */
  PowerDistribution examplePD;
  double voltage;
  double current;
  double power;
  double energy;
  double temp;
  double shooter;
  double turret;
  double funnel;
  double intake;
  double climb1;
  double climb2;

  public PDPSubsystem() {
    examplePD = new PowerDistribution();
  }
  //voltaj
  public double getVoltage(){
    voltage = examplePD.getVoltage();
    return voltage;
  }
  //toplam akım
  public double getTotalCurrent(){
    current = examplePD.getTotalCurrent();
    return current;
  }
  //toplam güç
  public double getTotalPower(){
    power = examplePD.getTotalPower();
    return power;
  }
  //toplam enerji
  public double getTotalEnergy(){
    energy = examplePD.getTotalEnergy();
    return energy;
  }
  //sıcaklık
  public double getTemperature(){
    temp = examplePD.getTemperature();
    return temp;
  }
  //shooter akım
  public double getVictorShooter(){
    shooter = examplePD.getCurrent(0);
    return shooter;
  }
  //turret akım
  public double getVictorTurret(){
    turret = examplePD.getCurrent(1);
    return turret;
  }
  //funnel akım
  public double getVictorFunnel(){
    funnel = examplePD.getCurrent(2);
    return funnel;
  }
  //intake akım
  public double getVictorIntake(){
    intake = examplePD.getCurrent(3);
    return intake;
  }
  //climb2 akım
  public double getVictorClimb2(){
    climb2 = examplePD.getCurrent(4);
    return climb2;
  }
  //climb1 akım
  public double getVictorClimb(){
    climb1 = examplePD.getCurrent(5);
    return climb1;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("voltaj", getVoltage());
    SmartDashboard.putNumber("toplam akim", getTotalCurrent());
    SmartDashboard.putNumber("toplam güç", getTotalPower());
    SmartDashboard.putNumber("toplam enerji", getTotalEnergy());
    SmartDashboard.putNumber("sicaklik", getTemperature());
    SmartDashboard.putNumber("shooter akim", getVictorShooter());
    SmartDashboard.putNumber("turret akim", getVictorTurret());
    SmartDashboard.putNumber("funnel akim", getVictorFunnel());
    SmartDashboard.putNumber("intake akim", getVictorIntake());
    SmartDashboard.putNumber("climb2 akim", getVictorClimb2());
    SmartDashboard.putNumber("climb1 akim", getVictorClimb());
  }
}
