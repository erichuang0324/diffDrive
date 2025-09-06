package frc.robot.Commands;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Subsystem.DriveTrainSubsystem;

public class TeleDCommand extends Command{
    DriveTrainSubsystem subsystem = new DriveTrainSubsystem();
    CommandXboxController controller = new CommandXboxController(0);
    public TeleDCommand(DriveTrainSubsystem subsystem, CommandXboxController controller){
        this.subsystem = subsystem;
        this.controller = controller;
        addRequirements(subsystem);
    }
    @Override
    public void initialize() {
    }
    @Override
    public void execute() {
        subsystem.drive(-controller.getLeftY(), -controller.getRightY());
    }
    @Override
    public void end(boolean interrupted) {
        
    }
    
}
