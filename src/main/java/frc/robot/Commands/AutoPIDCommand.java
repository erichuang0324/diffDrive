package frc.robot.Commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystem.DriveTrainSubsystem;

public class AutoPIDCommand extends Command{
    PIDController pid = new PIDController(0.01, 0, 0);
    DriveTrainSubsystem system = new DriveTrainSubsystem();
    public AutoPIDCommand(DriveTrainSubsystem system){
        this.system = system;
    }
    @Override
    public void initialize() {
        system.resetCanCoderValue();
    }
    @Override
    public void execute() {
        double pidValue = pid.calculate(system.getEncoderValueAsMeters(), 2);
        system.drive(pidValue,pidValue);
    }
    @Override
    public void end(boolean interrupted) {
        // TODO Auto-generated method stub
        super.end(interrupted);
    }
}
