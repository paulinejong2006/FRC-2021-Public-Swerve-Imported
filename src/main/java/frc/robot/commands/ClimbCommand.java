package frc.robot.commands;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class ClimbCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final ElevatorSubsystem m_elevatorSubsystem;
    private final PS4Controller m_controller;
  
    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public ClimbCommand(PS4Controller ps4, ElevatorSubsystem elevatorSubsytem) {
        this.m_elevatorSubsystem = elevatorSubsytem;
        this.m_controller = ps4;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(elevatorSubsytem);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        //this is to get the values of the L2 and R2 triggers for the climb
        double leftTrigger = m_controller.getL2Axis();
        double rightTrigger = m_controller.getR2Axis();

        if(Math.abs(leftTrigger) < 0.05){
            leftTrigger = 0;
        }
        if(Math.abs(leftTrigger) < 0.05){
            leftTrigger = 0;
        }
        if(Math.abs(rightTrigger) < 0.05){
            rightTrigger = 0;
        }

        ElevatorSubsystem.percentMotor(leftTrigger);
        ElevatorSubsystem.percentMotor(rightTrigger);
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
  