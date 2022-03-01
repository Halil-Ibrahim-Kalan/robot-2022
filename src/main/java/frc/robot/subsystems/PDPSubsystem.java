// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.Map;

import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PDPSubsystem extends SubsystemBase {
  /** Creates a new PDPSubsystem. */
  private PowerDistribution PDP;
  private final ShuffleboardLayout PDPInfo;
  public PDPSubsystem() {
    PDP = new PowerDistribution(0, ModuleType.kCTRE);
    PDPInfo = Shuffleboard.getTab("Commands")
  .getLayout("Elevator", BuiltInLayouts.kList)
  .withSize(2, 2)
  .withProperties(Map.of("Label position", "HIDDEN")); // hide labels for commands
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

  public double getCurrent0(){
    return PDP.getCurrent(0);
  }

  public double getCurrent1(){
    return PDP.getCurrent(1);
  }

  public double getCurrent2(){
    return PDP.getCurrent(2);
  }

  public double getCurrent3(){
    return PDP.getCurrent(3);
  }

  public double getCurrent4(){
    return PDP.getCurrent(4);
  }

  public double getCurrent5(){
    return PDP.getCurrent(5);
  }

  public double getCurrent6(){
    return PDP.getCurrent(6);
  }

  public double getCurrent7(){
    return PDP.getCurrent(7);
  }
  public double getCurrent8(){
    return PDP.getCurrent(8);
  }

  public double getCurrent9(){
    return PDP.getCurrent(9);
  }

  public double getCurrent10(){
    return PDP.getCurrent(10);
  }

  public double getCurrent11(){
    return PDP.getCurrent(11);
  }

  public double getCurrent12(){
    return PDP.getCurrent(12);
  }

  public double getCurrent13(){
    return PDP.getCurrent(13);
  }

  public double getCurrent14(){
    return PDP.getCurrent(14);
  }

  public double getCurrent15(){
    return PDP.getCurrent(15);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    PDPInfo.add("voltage", getVoltage());
    PDPInfo.add("total current", getTotalCurrent());
    PDPInfo.add("total power", getTotalPower());
    PDPInfo.add("total energy", getTotalEnergy());
    PDPInfo.add("temperature", getTemperature());
    PDPInfo.add("PDP 0", getCurrent0());
    PDPInfo.add("PDP 1", getCurrent1());
    PDPInfo.add("PDP 2", getCurrent2());
    PDPInfo.add("PDP 3", getCurrent3());
    PDPInfo.add("PDP 4", getCurrent4());
    PDPInfo.add("PDP 5", getCurrent5());
    PDPInfo.add("PDP 6", getCurrent6()); 
    PDPInfo.add("PDP 7", getCurrent7());
    PDPInfo.add("PDP 8", getCurrent8());
    PDPInfo.add("PDP 9", getCurrent9());
    PDPInfo.add("PDP 10", getCurrent10());
    PDPInfo.add("PDP 11", getCurrent11());
    PDPInfo.add("PDP 12", getCurrent12());
    PDPInfo.add("PDP 13", getCurrent13());
    PDPInfo.add("PDP 14", getCurrent14());
    PDPInfo.add("PDP 15", getCurrent15());
  }
}
