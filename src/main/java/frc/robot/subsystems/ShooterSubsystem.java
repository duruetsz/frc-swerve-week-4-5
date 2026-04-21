// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.ShooterConstants.*;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.configs.TalonFXConfiguration;


public class ShooterSubsystem extends SubsystemBase {
  private TalonFX shooterMotor;
  private TalonFXConfiguration shooterConfig = new TalonFXConfiguration();
  var slot0 = shooterConfig.slot0;
  public final VoltageOut shooterVoltageOut = new VoltageOut(0);
  
  public ShooterSubsystem() {
    shooterMotor = new TalonFX(shooterMotorID);
    
    
  }

  @Override
  public void periodic() {
  }

  public void configureHardware() {
    shooterConfig.slot0.kP = shooterP;
    shooterConfig.slot0.kI = shooterI;
    shooterConfig.slot0.kD = shooterD;
    shooterConfig.slot0.kS = shooterS;
    shooterConfig.slot0.kV = shooterV;
    shooterMotor.getConfigurator().apply(shooterConfig);
  }

  public void setShooterVoltage(double voltage) {
    shooterMotor.setControl(shooterVoltageOut.withOutput(voltage));
  }
}