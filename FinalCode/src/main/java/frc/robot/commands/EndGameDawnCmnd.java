/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class EndGameDawnCmnd extends Command {
  public EndGameDawnCmnd() {
    requires(Robot.m_EndGame);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.m_EndGame.limitTop.get() == false && Robot.m_EndGame.limitBottom.get() == false){
      Robot.m_EndGame.moveDown(200.0);
    }else{
      Robot.m_EndGame.stop();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.m_EndGame.isFinishedD();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_EndGame.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
