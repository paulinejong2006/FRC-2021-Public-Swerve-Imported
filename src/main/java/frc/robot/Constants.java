/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final double TRACKWIDTH = 29.5;
    public static final double WHEELBASE = 29.5;

    public static final double SWERVE_MAX_VELOCITY = 10.0;
    public static final double SWERVE_MAX_ANGULAR_VELOCITY = 6*Math.PI;
    public static final double SWERVE_MAX_ANGULAR_ACCELERATION =  16*Math.PI;

    public static final double DEFAULT_DRIVE_ROTATIONS_PER_UNIT = (1.0 / (4.0 * Math.PI)) * (60.0 / 15.0) * (18.0 / 26.0) * (42.0 / 14.0);
    public static final double RPM_TO_MPS = ((11.9/3.281)/(5676 / 60))/60;
    // switched view from back to front intake, left right oriented
    public static final int DRIVETRAIN_FRONT_LEFT_DRIVE_MOTOR = 5;  //was 23
    public static final int DRIVETRAIN_FRONT_LEFT_ANGLE_MOTOR = 12; //was 10
    public static final int DRIVETRAIN_FRONT_LEFT_ANGLE_ENCODER = 3;  
    public static final double DRIVETRAIN_FRONT_LEFT_ANGLE_OFFSET = Math.toRadians(-3); //was -39

    public static final int DRIVETRAIN_FRONT_RIGHT_DRIVE_MOTOR = 23;  //was 5
    public static final int DRIVETRAIN_FRONT_RIGHT_ANGLE_MOTOR = 10; //was 12
    public static final int DRIVETRAIN_FRONT_RIGHT_ANGLE_ENCODER = 2;
    public static final double DRIVETRAIN_FRONT_RIGHT_ANGLE_OFFSET = Math.toRadians(-140); //was -333

    public static final int DRIVETRAIN_REAR_LEFT_DRIVE_MOTOR = 7; // was 3
    public static final int DRIVETRAIN_REAR_LEFT_ANGLE_MOTOR = 4; // was 21
    public static final int DRIVETRAIN_REAR_LEFT_ANGLE_ENCODER = 1;
    public static final double DRIVETRAIN_REAR_LEFT_ANGLE_OFFSET = Math.toRadians(-106); //was -348

    public static final int DRIVETRAIN_REAR_RIGHT_DRIVE_MOTOR = 3;  //was 22
    public static final int DRIVETRAIN_REAR_RIGHT_ANGLE_MOTOR = 21;  //was 4
    public static final int DRIVETRAIN_REAR_RIGHT_ANGLE_ENCODER = 0;
    public static final double DRIVETRAIN_REAR_RIGHT_ANGLE_OFFSET = Math.toRadians(170); //was -282

    public static int IntakeMotor = 16;
    public static int ElevatorLeftMotor = 11;
    public static int ElevatorRightMotor = 12;
    public static int ManipulatorEndMotor = 14;
    public static int ManipulatorMidMotor = 41;

    public static int ControllerPort = 0;

}
