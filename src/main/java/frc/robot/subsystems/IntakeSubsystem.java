package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase{
    public static VictorSPX intakeMotor;

    public IntakeSubsystem() {
      intakeMotor = new VictorSPX(Constants.IntakeMotor);
    }

    public static void percentMotor(double input){
      intakeMotor.set(ControlMode.PercentOutput, input);
    }

    public static void go(boolean isGo){
      if(isGo){
        percentMotor(0.8);
      } else {
        percentMotor(0.0);
      }
    }
  
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
}
