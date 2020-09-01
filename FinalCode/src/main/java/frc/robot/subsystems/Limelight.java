package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Limelight extends Subsystem{
    NetworkTable table;
    NetworkTableEntry tx;
    NetworkTableEntry ty;
    double x; double y;
    double x1, x2;
    double hcamera = 0.5, hField = 2, d, a1 =45, a2;
  
  @Override
  protected void initDefaultCommand() {
  }
  public Limelight(){
      table = NetworkTableInstance.getDefault().getTable("limelight");
      tx = table.getEntry("tx");
      ty = table.getEntry("ty");
  }
  public void showConnection(){
    if(table.getInstance() != null){
      SmartDashboard.putString("Connection", "Working");
      }else{
        SmartDashboard.putString("Connection", "Failed");
      }
  }
  public void show(){
    x = tx.getDouble(0.0);
    y = ty.getDouble(0.0);
    SmartDashboard.putNumber("tx", x);
    SmartDashboard.putNumber("ty", y);
  }
  public  double getDistance(){
    a2 = ty.getDouble(0.0);
    d = (hField - hcamera) / Math.tan(a1 + a2);
    return d;
  }
  public double getAngleX(){
    return tx.getDouble(0.0);
  }
}