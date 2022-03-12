/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.model;

import com.revrobotics.*;
/**
 * Add your docs here.
 */

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import frc.robot.Constants;

public class SwerveModule {

    CANSparkMax driveMotor;
    CANSparkMax angleMotor;

    RelativeEncoder driveEncoder;
    
    AnalogInput angleEncoder;

    
    double angleOffset = 0.0;

    PIDController drivePIDController = new PIDController(0.34,0,0);

    ProfiledPIDController anglePIDController = new ProfiledPIDController(0.8, 0, 0,
      new TrapezoidProfile.Constraints(Constants.SWERVE_MAX_ANGULAR_VELOCITY, Constants.SWERVE_MAX_ANGULAR_ACCELERATION));

    public SwerveModule(int driveMotorChannel, int angleMotorChannel, int angleEncoderChannel, double angleOffset) {
        driveMotor = new CANSparkMax(driveMotorChannel, MotorType.kBrushless);
        angleMotor = new CANSparkMax(angleMotorChannel, MotorType.kBrushless);

        driveMotor.restoreFactoryDefaults();
        angleMotor.restoreFactoryDefaults();

        driveEncoder = driveMotor.getEncoder();
        angleEncoder = new AnalogInput(angleEncoderChannel);
      
        this.angleOffset = angleOffset;

        anglePIDController.enableContinuousInput(-Math.PI, Math.PI);
    }

    public SwerveModuleState getState() {
        return new SwerveModuleState(driveEncoder.getVelocity() * Constants.RPM_TO_MPS, new Rotation2d((1.0 - angleEncoder.getVoltage() / RobotController.getVoltage5V()) * 2.0 * Math.PI + angleOffset));
      }

    public double getAdjustedAngleEncoder() {
      double offset = Math.toDegrees((1.0 - angleEncoder.getVoltage() / RobotController.getVoltage5V()) * 2.0 * Math.PI + angleOffset);
      if(offset > 180) {
        return offset - 360;
      } else if(offset < -180) {
        return offset + 360;
      } else {
        return offset;
      }
      // return offset;
    }
    
    public void setDesiredState(SwerveModuleState state) {
        double setSpeed = state.speedMetersPerSecond;
        double setAngle = state.angle.getDegrees();
        double current = getAdjustedAngleEncoder();
       
        if(Math.abs(setAngle - current) > 90) {
          if(setAngle > 0) {
            setAngle = -(180 - setAngle);
          } else {
            setAngle = (180 + setAngle);
          }
          setSpeed = - setSpeed;
        }
        //System.out.print("set: ");

        double driveOutput = drivePIDController.calculate(driveEncoder.getVelocity() * Constants.RPM_TO_MPS, setSpeed);
        //System.out.println("DriveOutput: " + driveOutput);
        double angleOutput = anglePIDController.calculate(Math.toRadians(current), Math.toRadians(setAngle));

        // if(angleEncoder.getChannel() == 0) {
        //   double angle = state.angle.getDegrees(), pos = getAdjustedAngleEncoder(), err = Math.toDegrees(anglePIDController.getPositionError());
        //   if ((angle - pos) - err > 0.001)
        //   {
        //     int i=0;
        //   }
        //   System.out.println("Angle: " + getAdjustedAngleEncoder() + " Setpoint: " + state.angle.getDegrees() + " Error: " + Math.toDegrees(anglePIDController.getPositionError()));
        // }

        //System.out.println("Module Number: " + angleEncoder.getChannel() + " state.speed: " + state.speedMetersPerSecond + " state.angle: " + state.angle.getDegrees());
        //System.out.println("Module Number: " + angleEncoder.getChannel() + " driveOutput: " + driveOutput + " angleOutput: " + angleOutput);
        //SmartDashboard.putNumber("Module Number: " + angleEncoder.getChannel(), Math.toDegrees((1.0 - angleEncoder.getVoltage() / RobotController.getVoltage5V()) * 2.0 * Math.PI));
        
        SmartDashboard.putNumber("Module Number " + angleEncoder.getChannel() + " set angle", state.angle.getDegrees());
        SmartDashboard.putNumber("Velocity: ", driveEncoder.getVelocity());
        
        driveMotor.set(driveOutput);
        angleMotor.set(angleOutput);
    }

}
