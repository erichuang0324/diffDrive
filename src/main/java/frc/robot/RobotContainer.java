// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.hardware.Pigeon2;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.AutoPIDCommand;
import frc.robot.Commands.TeleDCommand;
import frc.robot.Subsystem.DriveTrainSubsystem;

public class RobotContainer {
  DriveTrainSubsystem dtSubsystem = new DriveTrainSubsystem();
  CommandXboxController commandController = new CommandXboxController(0);
  TeleDCommand teleDcommand = new TeleDCommand(dtSubsystem, commandController);
  AutoPIDCommand pidCommand = new AutoPIDCommand(dtSubsystem);
  
  public RobotContainer() {
    dtSubsystem.setDefaultCommand(teleDcommand);
    configureBindings();
  }

  private void configureBindings() {
    commandController.y().onTrue(pidCommand);
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
