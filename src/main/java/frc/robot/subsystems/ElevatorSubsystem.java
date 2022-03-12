package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class ElevatorSubsystem extends SubsystemBase{
  private static WPI_TalonSRX leftMotor;
  private static WPI_TalonSRX rightMotor;

  public ElevatorSubsystem() {
    leftMotor = new WPI_TalonSRX(Constants.ElevatorLeftMotor);
    rightMotor = new WPI_TalonSRX(Constants.ElevatorRightMotor);
  } 

  public void percentMotor(double input){
    leftMotor.set(ControlMode.PercentOutput, input);
    rightMotor.set(ControlMode.PercentOutput, -input);
  }
  
  @Override
  public void periodic() {
  // This method will be called once per scheduler run
  }
}
