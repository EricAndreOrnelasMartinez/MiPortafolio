
package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Shooter extends Subsystem {
  private CANSparkMax shooter_Motor; 
  private CANEncoder encoder; 
  private CANPIDController controller; 
  public double kP = 1, kI = 0, kD = 0.15, kIz = 0, kFF = 0.000015, kMaxOutput = -0.6, kMinOutput = -0.6, maxRPM = 10000;
  private boolean flag;

  @Override
  protected void initDefaultCommand() {
  }
  public Shooter(){
    shooter_Motor = RobotMap.shooter_MotorcCanSparkMax; 
    encoder = new CANEncoder(RobotMap.shooter_MotorcCanSparkMax); 
    controller = shooter_Motor.getPIDController();   
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
  public void shoot(){
    //Robot.m_Intake.take(0, 0.6, Value.kReverse);
    double p = SmartDashboard.getNumber("P Gain", 0);
    double i = SmartDashboard.getNumber("I Gain", 0);
    double d = SmartDashboard.getNumber("D Gain", 0);
    double iz = SmartDashboard.getNumber("I Zone", 0);
    double ff = SmartDashboard.getNumber("Feed Forward", 0);
    double max = SmartDashboard.getNumber("Max Output", 0);
    double min = SmartDashboard.getNumber("Min Output", 0);
    if((p != kP)) {
      controller.setP(p);kP = p;
    }
    if((i != kI)) {
      controller.setI(i);kI = i;
    }
    if((d != kD)) {
      controller.setD(d);kD = d;
    }
    if((iz != kIz)) {
      controller.setIZone(iz);kIz = iz;
    }
    if((ff != kFF)) {
      controller.setFF(ff);kFF = ff;
    }
    if((max != kMaxOutput) || (min != kMinOutput)) {
      controller.setOutputRange(min, max);
      kMinOutput = min;
      kMaxOutput = max;
    }

    double setPoint = maxRPM;
    controller.setReference(setPoint, ControlType.kVelocity);
    SmartDashboard.putNumber("SetPoint", setPoint);
    SmartDashboard.putNumber("ProcessVariable", encoder.getVelocity());
  }
  public void stop(){
    shooter_Motor.set(0);
  }
  public boolean isFinished(){
    Joystick control = Robot.m_oi.controller2_Joystick; 
    flag = control.getRawButton(5);  
    return  (flag == false); 
  }
}
