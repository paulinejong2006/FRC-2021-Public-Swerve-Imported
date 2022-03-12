package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase{
    public static VictorSPX intakeMotor;

    public IntakeSubsystem() {
      intakeMotor = new VictorSPX(Constants.IntakeMotor);
    }

    public void percentMotor(double input){
      intakeMotor.set(ControlMode.PercentOutput, input);
    }

    public void go(){
        percentMotor(0.5);
    }
    public void stop(){
        percentMotor(0.0);
    }
  
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
}
