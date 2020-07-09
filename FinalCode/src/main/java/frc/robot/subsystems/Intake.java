package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Intake extends Subsystem {
  private DoubleSolenoid solenoid;
  private VictorSPX intake_Motor;
  private VictorSPX hopper_Motor1;
  private VictorSPX hopper_Motor2;
  private double kP = 0.25, kI = 0.00025, kD = 250, kFF = 0.000015, kMaxOutput = 1, kMinOutput = 1;
  int kIz = 0, kPIDloopIdx = 0, kTimeout = 30; 
  private double m_velocity2; 
  private double m_velocity; 
  private boolean flag; 

  @Override
  protected void initDefaultCommand() {
  }
  public Intake(){
    solenoid = RobotMap.doubleSolenoid; 
    intake_Motor = RobotMap.intake_MotorVictorSPX; 
    hopper_Motor1 = RobotMap.hopper_Motor1Spx; 
    hopper_Motor2 = RobotMap.hopper_Motor2Spx; 
    intake_Motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, kPIDloopIdx, 30); 
    intake_Motor.setSensorPhase(true);
    intake_Motor.configNominalOutputForward(0, kTimeout);
    intake_Motor.configNominalOutputReverse(0, kTimeout); 
    intake_Motor.configPeakOutputForward(kMaxOutput, kTimeout);
    intake_Motor.configPeakOutputReverse(kMinOutput, kTimeout); 
    intake_Motor.config_kP(kPIDloopIdx, kP, kTimeout); 
    intake_Motor.config_kI(kPIDloopIdx, kI, kTimeout);
    intake_Motor.config_kD(kPIDloopIdx, kD, kTimeout);
    intake_Motor.config_IntegralZone(kPIDloopIdx, kIz);
    intake_Motor.config_kF(kPIDloopIdx, kFF, kTimeout); 
    hopper_Motor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, kPIDloopIdx, 30); 
    hopper_Motor1.setSensorPhase(true);
    hopper_Motor1.configNominalOutputForward(0, kTimeout);
    hopper_Motor1.configNominalOutputReverse(0, kTimeout); 
    hopper_Motor1.configPeakOutputForward(kMaxOutput, kTimeout);
    hopper_Motor1.configPeakOutputReverse(kMinOutput, kTimeout); 
    hopper_Motor1.config_kP(kPIDloopIdx, kP, kTimeout); 
    hopper_Motor1.config_kI(kPIDloopIdx, kI, kTimeout);
    hopper_Motor1.config_kD(kPIDloopIdx, kD, kTimeout);
    hopper_Motor1.config_IntegralZone(kPIDloopIdx, kIz);
    hopper_Motor1.config_kF(kPIDloopIdx, kFF, kTimeout);
    hopper_Motor2.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, kPIDloopIdx, 30); 
    hopper_Motor2.setSensorPhase(true);
    hopper_Motor2.configNominalOutputForward(0, kTimeout);
    hopper_Motor2.configNominalOutputReverse(0, kTimeout); 
    hopper_Motor2.configPeakOutputForward(kMaxOutput, kTimeout);
    hopper_Motor2.configPeakOutputReverse(kMinOutput, kTimeout); 
    hopper_Motor2.config_kP(kPIDloopIdx, kP, kTimeout); 
    hopper_Motor2.config_kI(kPIDloopIdx, kI, kTimeout);
    hopper_Motor2.config_kD(kPIDloopIdx, kD, kTimeout);
    hopper_Motor2.config_IntegralZone(kPIDloopIdx, kIz);
    hopper_Motor2.config_kF(kPIDloopIdx, kFF, kTimeout);   
  }
  public void initialize(){
    intake_Motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, kPIDloopIdx, 30); 
    intake_Motor.setSensorPhase(true);
    intake_Motor.configNominalOutputForward(0, kTimeout);
    intake_Motor.configNominalOutputReverse(0, kTimeout); 
    intake_Motor.configPeakOutputForward(kMaxOutput, kTimeout);
    intake_Motor.configPeakOutputReverse(kMinOutput, kTimeout); 
    intake_Motor.config_kP(kPIDloopIdx, kP, kTimeout); 
    intake_Motor.config_kI(kPIDloopIdx, kI, kTimeout);
    intake_Motor.config_kD(kPIDloopIdx, kD, kTimeout);
    intake_Motor.config_IntegralZone(kPIDloopIdx, kIz);
    intake_Motor.config_kF(kPIDloopIdx, kFF, kTimeout); 
    hopper_Motor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, kPIDloopIdx, 30); 
    hopper_Motor1.setSensorPhase(true);
    hopper_Motor1.configNominalOutputForward(0, kTimeout);
    hopper_Motor1.configNominalOutputReverse(0, kTimeout); 
    hopper_Motor1.configPeakOutputForward(kMaxOutput, kTimeout);
    hopper_Motor1.configPeakOutputReverse(kMinOutput, kTimeout); 
    hopper_Motor1.config_kP(kPIDloopIdx, kP, kTimeout); 
    hopper_Motor1.config_kI(kPIDloopIdx, kI, kTimeout);
    hopper_Motor1.config_kD(kPIDloopIdx, kD, kTimeout);
    hopper_Motor1.config_IntegralZone(kPIDloopIdx, kIz);
    hopper_Motor1.config_kF(kPIDloopIdx, kFF, kTimeout);
    hopper_Motor2.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, kPIDloopIdx, 30); 
    hopper_Motor2.setSensorPhase(true);
    hopper_Motor2.configNominalOutputForward(0, kTimeout);
    hopper_Motor2.configNominalOutputReverse(0, kTimeout); 
    hopper_Motor2.configPeakOutputForward(kMaxOutput, kTimeout);
    hopper_Motor2.configPeakOutputReverse(kMinOutput, kTimeout); 
    hopper_Motor2.config_kP(kPIDloopIdx, kP, kTimeout); 
    hopper_Motor2.config_kI(kPIDloopIdx, kI, kTimeout);
    hopper_Motor2.config_kD(kPIDloopIdx, kD, kTimeout);
    hopper_Motor2.config_IntegralZone(kPIDloopIdx, kIz);
    hopper_Motor2.config_kF(kPIDloopIdx, kFF, kTimeout); 
  }
  public void take(double speedI, double speedH, Value value){
    m_velocity = speedI * 500.0 * 4096 / 600;
    m_velocity2 = speedH * 500.0 * 4096 / 600;
    intake_Motor.set(ControlMode.Velocity, m_velocity);
    hopper_Motor1.set(ControlMode.Velocity, m_velocity2);
    hopper_Motor2.set(ControlMode.Velocity, m_velocity2);
    solenoid.set(value);
  }
  public void stop(){
    intake_Motor.set(ControlMode.Velocity, 0);
    hopper_Motor1.set(ControlMode.Velocity, 0);
    hopper_Motor2.set(ControlMode.Velocity, 0);
    solenoid.set(Value.kReverse);
  }
  public boolean isFinished(){
    Joystick controller = Robot.m_oi.controller2_Joystick; 
    flag = controller.getRawButton(4); 
    return (flag == false); 
  }
}
