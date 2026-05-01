// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.LimelightHelpers;

public class VisionSubsystem extends SubsystemBase {
  public boolean tv = LimelightHelpers.getTV("balta limelight");
  public double tx = LimelightHelpers.getTX("balta limelight");
  public double ty = LimelightHelpers.getTY("balta limelight");
  public double ta = LimelightHelpers.getTA("balta limelight");

  public VisionSubsystem() {}

  @Override
  public void periodic() {
  }

  public boolean isSeeingTagID(double TargetTagID) {
    if (LimelightHelpers.getTV("balta limelight")==true) {
      double currentID = LimelightHelpers.getFiducialID("balta limelight");
      return TargetTagID==currentID;
    }
    else {
      return false;
    }
  }
}
