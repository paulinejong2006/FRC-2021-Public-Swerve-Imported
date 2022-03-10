package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ManipulatorSubsystem extends SubsystemBase{
    private static WPI_VictorSPX midMotor;
    private static WPI_VictorSPX endMotor;

    public ManipulatorSubsystem() {
        midMotor = new WPI_VictorSPX(Constants.ManipulatorMidMotor);
        endMotor = new WPI_VictorSPX(Constants.ManipulatorEndMotor);
      } 
    
      public static void percentMotor(double input){
        midMotor.set(ControlMode.PercentOutput, input);
        endMotor.set(ControlMode.PercentOutput, -input);
      }
        
        
      @Override
      public void periodic() {
      // This method will be called once per scheduler run
      }
      
}
