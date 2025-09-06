package frc.robot.Commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystem.DriveTrainSubsystem;

public class AutoPIDCommand extends Command{
    PIDController pid = new PIDController(1.2, 0, 0.05);
    DriveTrainSubsystem system = new DriveTrainSubsystem();
    public AutoPIDCommand(DriveTrainSubsystem system){
        this.system = system;

        SmartDashboard.putData(pid);
    }
    @Override
    public void initialize() {
        system.resetCanCoderValue();
    }
    @Override
    public void execute() {
        double pidValue = pid.calculate(system.getEncoderValueAsMeters(), 2);
        system.drive(pidValue, pidValue);
        SmartDashboard.putNumber("PID Value", pidValue);
        SmartDashboard.putNumber("postion", system.getEncoderValueAsMeters());
        SmartDashboard.putNumber("target", 2);
    }
    @Override
    public void end(boolean interrupted) {
        system.drive(0, 0);
    }

    @Override
    public boolean isFinished() {
        return pid.atSetpoint();
    }
}
