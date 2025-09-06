package frc.robot.Subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix6.hardware.CANcoder;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase{

    WPI_TalonSRX frontRight = new WPI_TalonSRX(1);
    WPI_TalonSRX frontLeft = new WPI_TalonSRX(2);
    WPI_VictorSPX backLeft = new WPI_VictorSPX(3);
    WPI_VictorSPX backRight = new WPI_VictorSPX(4);

    CANcoder rightCan = new CANcoder(12);
    CANcoder leftCan = new CANcoder(11);
    
    DifferentialDrive robotDrive = new DifferentialDrive(frontLeft, frontRight);
    

    public DriveTrainSubsystem(){
        backLeft.setInverted(false);
        frontLeft.setInverted(false);
        
        frontRight.setInverted(true);
        backRight.setInverted(true);

        backLeft.follow(frontLeft);
        backRight.follow(frontRight);
    }
    public void drive(double leftSpeed, double rightSpeed){
        robotDrive.tankDrive(leftSpeed, rightSpeed);
    }
    @Override
    public void periodic() {
        robotDrive.feed();
    }

}
