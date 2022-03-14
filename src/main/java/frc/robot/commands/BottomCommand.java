package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ManipulatorSubsystem;

public class BottomCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final ManipulatorSubsystem m_manipulatorSubsystem;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public BottomCommand(ManipulatorSubsystem manipulatorSubsystem) {
      this.m_manipulatorSubsystem = manipulatorSubsystem;
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(m_manipulatorSubsystem);
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
      //init
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        //receives the balls
        m_manipulatorSubsystem.midMotor(0.8);
        m_manipulatorSubsystem.endMotor(-0.8);
        
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