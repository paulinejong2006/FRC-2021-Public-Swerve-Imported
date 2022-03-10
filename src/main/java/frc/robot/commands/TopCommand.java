package frc.robot.commands;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ManipulatorSubsystem;

public class TopCommand extends CommandBase {
    private ManipulatorSubsystem m_manipulatorSubsystem;
    private PS4Controller m_controller;


    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    
    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public TopCommand(PS4Controller ps4, ManipulatorSubsystem manipulatorSubsystem) {
        this.m_manipulatorSubsystem = manipulatorSubsystem;
        this.m_controller = ps4;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(manipulatorSubsystem);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        //empties the balls
        boolean triangle = m_controller.getTriangleButtonPressed();
        if(triangle){
            ManipulatorSubsystem.percentMotor(0.5);
        } else {
            ManipulatorSubsystem.percentMotor(0);
        }
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