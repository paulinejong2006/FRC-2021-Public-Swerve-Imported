/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.Button;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.PS4Controller;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  final PS4Controller m_controller = new PS4Controller(Constants.ControllerPort);
  final XboxController m_xbox = new XboxController(Constants.ControllerPort2);

  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final ZeroFieldOrientedCommand zeroCommand = new ZeroFieldOrientedCommand(m_drivetrainSubsystem);
  
  public static DrivetrainSubsystem m_drivetrainSubsystem = new DrivetrainSubsystem();
  public final DriveCommand driveCommand = new DriveCommand(m_controller, m_drivetrainSubsystem);
  public final DriveTest driveTest = new DriveTest(m_drivetrainSubsystem);

  public static ElevatorSubsystem m_elevatorSubsystem = new ElevatorSubsystem();
  public final ClimbUpCommand upCommand = new ClimbUpCommand(m_xbox, m_elevatorSubsystem);
  public final ClimbDownCommand downCommand = new ClimbDownCommand(m_xbox, m_elevatorSubsystem);

  public static ManipulatorSubsystem m_manipulatorSubsystem = new ManipulatorSubsystem();
  public final BottomCommand bottomCommand = new BottomCommand(m_manipulatorSubsystem);
  public final TopCommand topCommand = new TopCommand(m_manipulatorSubsystem);
  public final StopManipulatorCommand stopManipulatorCommand = new StopManipulatorCommand(m_manipulatorSubsystem);

  public static IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  public final IntakeCommand intakeCommand = new IntakeCommand(m_intakeSubsystem);
  public final StopIntakeCommand stopIntakeCommand = new StopIntakeCommand(m_intakeSubsystem);
  
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
      driveCommand.schedule();
      downCommand.schedule();
      upCommand.schedule();
      // Configure the button bindings
      configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
      //ps4 controller for the driver
      //zeroButton.whenPressed(zeroCommand);
      //driveCommand.schedule(false);
      new Button(m_controller::getCircleButton)
        .whenPressed(zeroCommand);
      // new Button(m_controller::getCrossButton)
      //   .whileHeld(bottomCommand);
      // new Button(m_controller::getTriangleButton)
      //   .whileHeld(topCommand);
      // new Button(m_controller::getL2Button)
      //   .whenActive(climbCommand);
      // new Button(m_controller::getR2Button)
      //   .whenActive(climbCommand);
      // new Button(m_controller::getSquareButton)
      //   .whenActive(stopIntakeCommand);  
      
      //xbox controlller for the operator
      new Button(m_xbox::getXButton)
        .whenPressed(bottomCommand);
      new Button(m_xbox::getBButton)
        .whenPressed(topCommand);
      new Button(m_xbox::getAButton)
        .whenPressed(stopManipulatorCommand);
      new Button(m_xbox::getYButton)
        .whenPressed(intakeCommand);
      new Button(m_xbox::getYButton)
        .whenReleased(stopIntakeCommand);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
    Command driveBackStart = new InstantCommand(()->m_drivetrainSubsystem.drive(0, -0.5, 0, false), m_drivetrainSubsystem);
    Command wait = new WaitCommand(2);
    Command driveBackStop = new InstantCommand(()->m_drivetrainSubsystem.drive(0, 0, 0, false), m_drivetrainSubsystem);
    // Run 3 commands in sequence - start driving, drive for 2s, stop driving
    return new SequentialCommandGroup(driveBackStart, wait, driveBackStop);
  }
}
