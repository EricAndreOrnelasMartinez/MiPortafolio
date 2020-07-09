

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;



public class Auto extends Subsystem {
  public static boolean flag = false; 
  public static boolean flag2 = false; 
  private boolean flagFinish = false; 

  @Override
  protected void initDefaultCommand() {
  }
  public void start(){
    Robot.m_Chassis.forward(40, 0.2);
    if(flag == true){
      Robot.m_Chassis.turnLeft(40, 0.2);
    }
    if(flag2 == true){
      Robot.m_Shooter.shoot();
      Robot.m_Intake.take(0, 1, Value.kReverse);
      flagFinish = true; 
    }
  }
  public boolean isFinished(){
    return flagFinish; 
  }
  public void end(){
    flag = true; 
    flag2 = true; 
    flagFinish = true;
    Robot.m_Chassis.stop();
    Robot.m_Shooter.stop();
    Robot.m_Intake.stop();
  }
}
