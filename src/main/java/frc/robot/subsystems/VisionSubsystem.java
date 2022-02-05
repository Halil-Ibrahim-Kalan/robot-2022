// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase {
  /** Creates a new VisionSubsystem. */
  private double xEntry;
  private double yEntry;
  private final NetworkTableInstance inst;
  private final NetworkTable table;

  public VisionSubsystem() {
    inst = NetworkTableInstance.getDefault();
    table = inst.getTable("Vision");
  }

  public double getX(){
    xEntry = table.getEntry("target_x").getDouble(Double.NaN);
    return xEntry;
  }

  public double getY(){
    yEntry = table.getEntry("target_y").getDouble(Double.NaN);
    return yEntry;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Koordinat:X", getX());
    SmartDashboard.putNumber("Koordinat:Y", getY());
  }
}
