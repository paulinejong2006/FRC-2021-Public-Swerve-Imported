/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ManipulatorSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class StopCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ElevatorSubsystem m_elevatorSubsystem;
  private final ManipulatorSubsystem m_manipulatorSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public StopCommand(ElevatorSubsystem elevator, ManipulatorSubsystem manipulator) {
    this.m_elevatorSubsystem = elevator;
    this.m_manipulatorSubsystem = manipulator;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(elevator, manipulator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //init
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //execute
    m_elevatorSubsystem.percentMotor(0.0);
    m_manipulatorSubsystem.endMotor(0);
    m_manipulatorSubsystem.midMotor(0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //end
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
