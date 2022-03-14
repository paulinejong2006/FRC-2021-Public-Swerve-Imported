package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class ClimbUpCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final ElevatorSubsystem m_elevatorSubsystem;
    private final XboxController m_controller;
  
    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public ClimbUpCommand(XboxController controller, ElevatorSubsystem elevatorSubsytem) {
        this.m_elevatorSubsystem = elevatorSubsytem;
        this.m_controller = controller;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(m_elevatorSubsystem);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        //init
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        //this is to get the values of the L2 and R2 triggers for the climb
        double Ltrig = m_controller.getLeftTriggerAxis();
        if (Ltrig < 0.05){
            Ltrig = 0;
        } else if (Ltrig > 0.5){
            Ltrig = 0.5;
        }
        m_elevatorSubsystem.percentMotor(Ltrig);
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        //ends
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
  }
  