/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class ChassisDrive extends Command {
  private Joystick controllerJoystick; 
  private double x; 
  private double y; 
  private double x1; 
  private double x2; 
  public ChassisDrive() {
    requires(Robot.m_Chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  /*
 * @param speed
 *  
  */
  @Override
  protected void execute() {
    controllerJoystick = Robot.m_oi.controller_Joystick; 
    if(!controllerJoystick.getRawButton(1)){
      x = controllerJoystick.getRawAxis(0); 
      y = controllerJoystick.getRawAxis(1); 
      Robot.m_Chassis.moveInvert(x, y);
    }else if(!controllerJoystick.getRawButton(2)){
      x1 = controllerJoystick.getRawAxis(2); 
      x2 = controllerJoystick.getRawAxis(3); 
      Robot.m_Chassis.orientationL(x1, x2);
    }else{
      x = controllerJoystick.getRawAxis(0); 
      y = controllerJoystick.getRawAxis(1); 
      Robot.m_Chassis.moveNormal(x, y);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_Chassis.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
