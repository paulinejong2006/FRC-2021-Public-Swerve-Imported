/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.PS4Controller.*;

public class DriveCommand extends CommandBase {
  /**
   * Creates a new DriveCommand.
   */
  DrivetrainSubsystem drivetrainSubsystem;
  PS4Controller m_controller;
  public DriveCommand(PS4Controller controller, DrivetrainSubsystem drivetrainSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivetrainSubsystem = drivetrainSubsystem;
    addRequirements(drivetrainSubsystem);
    this.m_controller = controller;
  }


// Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double left1 = -m_controller.getLeftX();
    double left0 = -m_controller.getLeftY();
    double right0 = m_controller.getRightX();

    //reduces sensitivity so that the wind doesnt blow it over
    if(Math.abs(left1) < 0.05){
      left1 = 0;
    }
    if(Math.abs(left0) < 0.05){
      left0 = 0;
    }
    if(Math.abs(right0) < 0.05){
      right0 = 0;
    }

    drivetrainSubsystem.drive(left1, left0, right0, true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}