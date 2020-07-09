

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class ShooterCommand extends Command {
  public ShooterCommand() {
    requires(Robot.m_Intake);
    requires(Robot.m_Shooter);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_Intake.initialize();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_Intake.take(0, 1, Value.kReverse);
    Robot.m_Shooter.shoot();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.m_Shooter.isFinished();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_Intake.stop();
    Robot.m_Shooter.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
