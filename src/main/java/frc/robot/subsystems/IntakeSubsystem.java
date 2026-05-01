// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.IntakeConstants.*;

public class IntakeSubsystem extends SubsystemBase {
  private TalonFX intakeMotor;
  private TalonFXConfiguration intakeConfig = new TalonFXConfiguration();
  private VelocityVoltage intakeVV = new VelocityVoltage(0);

  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    intakeMotor = new TalonFX(kIntakeMotorID);
    configureHardware();
    intakeMotor.getConfigurator().apply(intakeConfig);
  }

  @Override
  public void periodic() {
  }

  private void configureHardware() {
    intakeConfig.Slot0.kP = kIntakeP;
    intakeConfig.Slot0.kI = kIntakeI;
    intakeConfig.Slot0.kD = kIntakeD;
    intakeConfig.Slot0.kS = kIntakeS;
    intakeConfig.Slot0.kV = kIntakeV;

    intakeConfig.CurrentLimits.SupplyCurrentLimit = kIntakeSupplyCurrentLimit;
    intakeConfig.CurrentLimits.SupplyCurrentLimitEnable = true;

    intakeConfig.CurrentLimits.StatorCurrentLimit = kIntakeStatorCurrentLimit;
    intakeConfig.CurrentLimits.StatorCurrentLimitEnable = true;
  }

  public void intake() {
    intakeMotor.setControl(intakeVV.withVelocity(35));
  }

  public void stopIntake() {
    intakeMotor.stopMotor();
  }
}
