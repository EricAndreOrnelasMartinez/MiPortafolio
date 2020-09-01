

package frc.robot.subsystems;

//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;



public class Auto extends Subsystem {
  public static boolean flag = false; 
  public static boolean flag2 = false; 
  private boolean flagFinish = false; 
  int f = 0;

  @Override
  protected void initDefaultCommand() {
  }
  public void start(){
    if(Robot.m_Chassis.forward(40, 0.1)){
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
