package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Chassis extends Subsystem {
  private CANSparkMax motor_L1; 
  private CANSparkMax motor_L2; 
  private CANSparkMax motor_R1; 
  private CANSparkMax motor_R2; 
  private CANEncoder encoderR; 
  private CANEncoder encoderL; 
  private float speed_L; 
  private float speed_R; 
  @Override
  protected void initDefaultCommand() {
  }
  public Chassis (){
    motor_L1 = RobotMap.chassis_L_Motor1; 
    motor_L2 = RobotMap.chassis_L_Motor2; 
    motor_R1 = RobotMap.chassis_R_Motor1; 
    motor_R2 = RobotMap.chassis_R_Motor2; 
    motor_L1.setOpenLoopRampRate(0.2); 
    motor_L2.setOpenLoopRampRate(0.2); 
    motor_R1.setOpenLoopRampRate(0.2); 
    motor_R2.setOpenLoopRampRate(0.2);
    motor_L1.setInverted(true);
    motor_L2.setInverted(true);
    encoderL.setPosition(0.0); 
    encoderR.setPosition(0.0);  
  }
  public void moveNormal(double x, double y){
    speed_L = (float)(y + (x * 0.5)); 
    speed_R = (float)(y + (x * 0.5)); 
    motor_L1.set(speed_L);
    motor_L2.set(speed_L);
    motor_R1.set(speed_R);
    motor_R2.set(speed_R);
  }
  public void moveInvert(double x, double y){
    speed_L = (float)((y * -1) + (x * 0.5 * -1)); 
    speed_R = (float)((y * -1) + (x * 0.5 * -1)); 
    motor_L1.set(speed_L);
    motor_L2.set(speed_L);
    motor_R1.set(speed_R);
    motor_R2.set(speed_R);
  }
  public void orientationL(double x1, double x2){
    if((x1 > 0) && (x2 == 0)){
      motor_L1.set(-1 * x1);
      motor_L2.set(-1 * x1);
      motor_R1.set(x1);
      motor_R2.set(x1);
    }
    if((x1 == 0) && (x2 > 0)){
      motor_L1.set(x2);
      motor_L2.set(x2);
      motor_R1.set(-1 * x2);
      motor_R2.set(-1 * x2);
    }
  }
  public void stop(){
    motor_L1.set(0);
    motor_L2.set(0);
    motor_R1.set(0);
    motor_R2.set(0);
  }
  public boolean forward(double rotation, double speed){
    boolean flag = false;
    if((encoderL.getPosition() < rotation) || (encoderR.getPosition() < rotation)){
      motor_L1.set(speed);
      motor_L2.set(speed);
      motor_R1.set(speed);
      motor_R2.set(speed);
    }else{
      motor_L1.set(0);
      motor_L2.set(0);
      motor_R1.set(0);
      motor_R2.set(0);
      flag = true;
    }
    return flag;
  }
  public void reverse(double rotation, double speed){
    if((encoderL.getPosition() > rotation) || (encoderR.getPosition() > rotation)){
      motor_L1.set(speed * -1);
      motor_L2.set(speed * -1);
      motor_R1.set(speed * -1);
      motor_R2.set(speed * -1);
    }else{
      motor_L1.set(0);
      motor_L2.set(0);
      motor_R1.set(0);
      motor_R2.set(0);
    }
  }
  public void turnLeft(double rotationR, double speed){
    if(encoderR.getPosition() < rotationR){
      motor_L1.set(0);
      motor_L2.set(0);
      motor_R1.set(speed);
      motor_R2.set(speed);
    }else{
      motor_L1.set(0);
      motor_L2.set(0);
      motor_R1.set(0);
      motor_R2.set(0);
    }
  }
  public void turnRight(double rotationL, double speed){
    if(encoderL.getPosition() < rotationL){
      motor_L1.set(speed);
      motor_L2.set(speed);
      motor_R1.set(0);
      motor_R2.set(0);
    }else{
      motor_L1.set(0);
      motor_L2.set(0);
      motor_R1.set(0);
      motor_R2.set(0);
    }
  }
  public void resetEl(){
    encoderL.setPosition(0.0); 
  }
  public void resetEr(){
    encoderR.setPosition(0.0); 
  }
}
