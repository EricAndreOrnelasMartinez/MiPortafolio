package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.EndGameDawnCmnd;
import frc.robot.commands.EndGameUpCmd;
import frc.robot.commands.IntakeTake;
import frc.robot.commands.ShooterCommand;

public class OI {
  public Joystick controller_Joystick;
  public Joystick controller2_Joystick;
  private JoystickButton b4;
  private JoystickButton b5;  
  private JoystickButton b1;
  private JoystickButton b3; 
  
  public OI(){
    controller_Joystick = new Joystick(0);
    controller2_Joystick = new Joystick(1);  
    b1 = new JoystickButton(controller2_Joystick, 1); 
    b3 = new JoystickButton(controller2_Joystick, 3); 
    b4 = new JoystickButton(controller2_Joystick, 4);
    b5 = new JoystickButton(controller2_Joystick, 5);  
    b4.whileHeld(new IntakeTake());
    b5.whileHeld(new ShooterCommand());
    b1.whileHeld(new EndGameUpCmd());
    b3.whileHeld(new EndGameDawnCmnd());
  }
}
