package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class EndGame extends Subsystem {
  private CANSparkMax endGame; 
  private CANEncoder encoder;
  private CANPIDController controller; 
  public DigitalInput limitTop; 
  public DigitalInput limitBottom;  
  private double kP = 1, kI = 0, kD = 0.15, kIz = 0, kFF = 0.000015, kMaxOutput = -0.6, kMinOutput = -0.6,/* kMaxOutput1 =  0.6, kMinOutput1 = 0.6,*/ maxRPM = 10000;
  private boolean flag; 
  @Override
  protected void initDefaultCommand() {
  }
  public EndGame(){
    limitBottom = RobotMap.limit_BottomDigitalInput; 
    limitTop = RobotMap.limit_topDigitalInput; 
    endGame = RobotMap.endGame_MotorsCanSparkMax; 
    endGame.setIdleMode(IdleMode.kBrake); 
    encoder = new CANEncoder(RobotMap.endGame_MotorsCanSparkMax); 
    controller = endGame.getPIDController(); 
    controller.setP(kP); 
    controller.setI(kI); 
    controller.setD(kD); 
    controller.setIZone(kIz); 
    controller.setFF(kFF); 
    controller.setOutputRange(kMinOutput, kMaxOutput); 
    SmartDashboard.putNumber("P Gain", kP);
    SmartDashboard.putNumber("I Gain", kI);
    SmartDashboard.putNumber("D Gain", kD);
    SmartDashboard.putNumber("I Zone", kIz);
    SmartDashboard.putNumber("Feed Forward", kFF);
    SmartDashboard.putNumber("Max Output", kMaxOutput);
    SmartDashboard.putNumber("Min Output", kMinOutput);
  }
  public void moveDown(double rotation){
    if(encoder.getPosition() > rotation){
      double p = SmartDashboard.getNumber("P Gain", 0);
      double i = SmartDashboard.getNumber("I Gain", 0);
      double d = SmartDashboard.getNumber("D Gain", 0);
      double iz = SmartDashboard.getNumber("I Zone", 0);
      double ff = SmartDashboard.getNumber("Feed Forward", 0);
      double max = SmartDashboard.getNumber("Max Output", 0);
      double min = SmartDashboard.getNumber("Min Output", 0);
      if((p != kP)) {controller.setP(p);kP = p;}
      if((i != kI)) {controller.setI(i);kI = i;}
      if((d != kD)) {controller.setD(d);kD = d;}
      if((iz != kIz)) {controller.setIZone(iz);kIz = iz;}
      if((ff != kFF)) {controller.setFF(ff);kFF = ff;}
      if((max != kMaxOutput) || (min != kMinOutput)) {
        controller.setOutputRange(min, max);
        kMinOutput = min;
        kMaxOutput = max;
      }
  
      double setPoint = maxRPM;
      controller.setReference(setPoint, ControlType.kVelocity);
      
  
      SmartDashboard.putNumber("SetPoint", setPoint);
      SmartDashboard.putNumber("ProcessVariable", encoder.getVelocity());
    }else{
      endGame.set(0);
    }
  }
  public void moveUp(double rotation){
    //controller.setOutputRange(kMaxOutput1, kMinOutput1); 
    //SmartDashboard.putNumber("Second Output", kMaxOutput1); 
    //SmartDashboard.putNumber("seminOutputcond", kMinOutput1);
    if(encoder.getPosition() < rotation){
      double p = SmartDashboard.getNumber("P Gain", 0);
      double i = SmartDashboard.getNumber("I Gain", 0);
      double d = SmartDashboard.getNumber("D Gain", 0);
      double iz = SmartDashboard.getNumber("I Zone", 0);
      double ff = SmartDashboard.getNumber("Feed Forward", 0);
      double max = SmartDashboard.getNumber("Max Output", 0);
      double min = SmartDashboard.getNumber("Min Output", 0);
      if((p != kP)) {controller.setP(p);kP = p;}
      if((i != kI)) {controller.setI(i);kI = i;}
      if((d != kD)) {controller.setD(d);kD = d;}
      if((iz != kIz)) {controller.setIZone(iz);kIz = iz;}
      if((ff != kFF)) {controller.setFF(ff);kFF = ff;}
      if((max != kMaxOutput) || (min != kMinOutput)) {
        controller.setOutputRange(min, max);
        kMinOutput = min;
        kMaxOutput = max;
      }
  
      double setPoint = maxRPM * -1;
      controller.setReference(setPoint, ControlType.kVelocity);
      
  
      SmartDashboard.putNumber("SetPoint", setPoint);
      SmartDashboard.putNumber("ProcessVariable", encoder.getVelocity());
    }else{
      endGame.set(0);
    }
  }
  public void stop(){
    endGame.set(0);
  }
  public boolean isFinished(){
    flag = Robot.m_oi.controller2_Joystick.getRawButton(1);  
    return (flag == false); 
  }
  public boolean isFinishedD(){ 
    flag = Robot.m_oi.controller2_Joystick.getRawButton(3);   
    return (flag == false); 
  }
}
