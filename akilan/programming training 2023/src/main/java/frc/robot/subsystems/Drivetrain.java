// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Drivetrain extends SubsystemBase {
  private static final class Config {
    public static final int kRightPrimaryMotorID = 1;
    public static final int kLeftPrimaryMotorID = 2;
    public static final int kRightSecondaryMotorID = 3;
    public static final int kLeftSecondaryMotorID = 4;
  }
  private WPI_TalonFX m_rightPrimary = new WPI_TalonFX(Config.kRightPrimaryMotorID);
  private WPI_TalonFX m_leftPrimary = new WPI_TalonFX(Config.kLeftPrimaryMotorID);
  private WPI_TalonFX m_rightSecondary = new WPI_TalonFX(Config.kRightSecondaryMotorID);
  private WPI_TalonFX m_leftSecondary = new WPI_TalonFX(Config.kLeftSecondaryMotorID);
  /** Creates a new Drivetrain. */
  public Drivetrain() {
    m_leftSecondary.follow(m_leftPrimary);
    m_rightSecondary.follow(m_rightPrimary);

    m_rightPrimary.setInverted(true);
    m_rightSecondary.setInverted(true);
  }
  public double getLeftEncoderPosition(){
    return m_leftPrimary.getSelectedSensorPosition();
  }
  public double getRightEncoderPosition(){
    return m_rightPrimary.getSelectedSensorPosition();
  }
  public void setRightSpeed(double rightSpeed){
    m_rightPrimary.set(rightSpeed);
  }
  public void setLeftSpeed(double leftSpeed){
    m_leftPrimary.set(leftSpeed);
  }

  public void setIdleMode(NeutralMode idleMode){
    m_leftPrimary.setNeutralMode(idleMode);
    m_rightPrimary.setNeutralMode(idleMode);
    m_leftSecondary.setNeutralMode(idleMode);
    m_rightSecondary.setNeutralMode(idleMode);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
} 
