// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.ShooterConstants.*;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.configs.TalonFXConfiguration;


public class ShooterSubsystem extends SubsystemBase {
  private TalonFX shooterMotor;
  private TalonFXConfiguration shooterConfig = new TalonFXConfiguration();
  public final VelocityVoltage shooterVV = new VelocityVoltage(0);
  
  public ShooterSubsystem() {
    shooterMotor = new TalonFX(kShooterMotorID);
    configureHardware();
  }

  @Override
  public void periodic() {
  }

  private void configureHardware() {
    shooterConfig.Slot0.kP = kShooterP;
    shooterConfig.Slot0.kI = kShooterI;
    shooterConfig.Slot0.kD = kShooterD;
    shooterConfig.Slot0.kS = kShooterS;
    shooterConfig.Slot0.kV = kShooterV;

    shooterConfig.CurrentLimits.SupplyCurrentLimit = kShooterSupplyCurrentLimit;
    shooterConfig.CurrentLimits.SupplyCurrentLimitEnable = true;

    shooterConfig.CurrentLimits.StatorCurrentLimit = kShooterStatorCurrentLimit;
    shooterConfig.CurrentLimits.StatorCurrentLimitEnable = true;

    shooterMotor.getConfigurator().apply(shooterConfig);
  }

  public void shoot() {
    shooterMotor.setControl(shooterVV.withVelocity(50)); // as rps
  }

  public void stopShooter() {
    shooterMotor.stopMotor();
  }
}