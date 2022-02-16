// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class deneme extends SubsystemBase {
  /** Creates a new deneme. */
  private final NetworkTableInstance NTmain;
  private final NetworkTable nt;
  public deneme() {    
    NTmain = NetworkTableInstance.getDefault();
    nt = NTmain.getTable("Vision");
  }

  public double getX(){
    return nt.getEntry("target_x").getDouble(Double.NaN);
  }

  public double getY(){
    return nt.getEntry("target_y").getDouble(Double.NaN);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("X deneme", getX());
    SmartDashboard.putNumber("Y deneme", getY());
  }
}
