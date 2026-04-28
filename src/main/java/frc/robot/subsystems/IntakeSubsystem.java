// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.IntakeConstants.*;

public class IntakeSubsystem extends SubsystemBase {
  private TalonFX intakeMotor;
  private TalonFXConfiguration intakeConfig = new TalonFXConfiguration();

  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    intakeMotor = new TalonFX(kIntakeMotorID);
  }

  @Override
  public void periodic() {
  }

  private void configureHardware() {
    intakeConfig.Slot0.kP = kIntakeP;
  }
}
