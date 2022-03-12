package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class ZeroFieldOrientedCommand extends CommandBase {
    private final DrivetrainSubsystem drivetrain;

    public ZeroFieldOrientedCommand(DrivetrainSubsystem drivetrain) {
        this.drivetrain = drivetrain;
    }

    @Override
    public void initialize() {
        //drivetrain.g
        //drivetrain.getGyroscope().getu
        drivetrain.getGyroscope().setAdjustmentAngle(drivetrain.getGyroscope().getUnadjustedAngle());
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        //end
    }
  

}
