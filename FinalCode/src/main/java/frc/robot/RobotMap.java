package frc.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
public class RobotMap {
 
  //chassis
  private static final int chassis_L_motor1 = 2;
  private static final int chassis_L_motro2 = 6; 
  private static final int chassis_R_motro1 = 4; 
  private static final int chassis_R_motro2 = 8;
  //Hopper
  private static final int hopper_Motor1 = 4; 
  private static final int hopper_Motor2 = 5; 
  //Intake
  private static final int intake_Motor = 7;//CTRE
  private static final int solenoid_ChannelC = 1; 
  private static final int solenoid_ChannelF = 0; 
  private static final int solenoid_ChannelR = 1; 
  //Shooter
  private static final int shooter_Motor = 7; //sparkmax
  //End game
  private static final int endGame_Motor = 1; //Sparkmax
  private static final int limit_Top = 1; //DIO
  private static final int limit_bottom = 0; 
  //components 
   public static CANSparkMax chassis_L_Motor1; 
   public static CANSparkMax chassis_L_Motor2;
   public static CANSparkMax chassis_R_Motor1; 
   public static CANSparkMax chassis_R_Motor2;
   public static CANSparkMax shooter_MotorcCanSparkMax; 
   public static CANSparkMax endGame_MotorsCanSparkMax; 
   public static VictorSPX hopper_Motor1Spx;
   public static VictorSPX hopper_Motor2Spx; 
   public static VictorSPX intake_MotorVictorSPX;
   public static DigitalInput limit_topDigitalInput; 
   public static DigitalInput limit_BottomDigitalInput; 
   public static Compressor compressor; 
   public static DoubleSolenoid doubleSolenoid; 
   //instace 
   public static void init(){
     chassis_L_Motor1 = new CANSparkMax(chassis_L_motor1, CANSparkMaxLowLevel.MotorType.kBrushless); 
     chassis_L_Motor2 = new CANSparkMax(chassis_L_motro2, CANSparkMaxLowLevel.MotorType.kBrushless); 
     chassis_R_Motor1 = new CANSparkMax(chassis_R_motro1, CANSparkMaxLowLevel.MotorType.kBrushless); 
     chassis_R_Motor2 = new CANSparkMax(chassis_R_motro2, CANSparkMaxLowLevel.MotorType.kBrushless); 
     shooter_MotorcCanSparkMax = new CANSparkMax(shooter_Motor, CANSparkMaxLowLevel.MotorType.kBrushless); 
     endGame_MotorsCanSparkMax = new CANSparkMax(endGame_Motor, CANSparkMaxLowLevel.MotorType.kBrushless); 
     hopper_Motor1Spx = new VictorSPX(hopper_Motor1); 
     hopper_Motor2Spx = new VictorSPX(hopper_Motor2); 
     intake_MotorVictorSPX = new VictorSPX(intake_Motor); 
     limit_BottomDigitalInput = new DigitalInput(limit_bottom); 
     limit_topDigitalInput = new DigitalInput(limit_Top);
     compressor = new Compressor(solenoid_ChannelC);
     doubleSolenoid = new DoubleSolenoid(solenoid_ChannelC, solenoid_ChannelF, solenoid_ChannelR);
   }
}
