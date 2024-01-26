package frc.robot.subsystems;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase{
    
    private Talon leftMotor1;
    private Talon leftMotor2;
    private Talon rightMotor1;
    private Talon rightMotor2;

    private DifferentialDrive drive;

    private static DriveSubsystem ds;

    public DriveSubsystem() {
        leftMotor1 = new Talon(3);
        leftMotor2 = new Talon(4);
        rightMotor1 = new Talon(6);
        rightMotor2 = new Talon(5);
        leftMotor1.addFollower(leftMotor2);
        rightMotor1.addFollower(rightMotor2);
        drive = new DifferentialDrive(leftMotor1, rightMotor1);
    }

    public static DriveSubsystem getInstance() {
        if (ds == null) ds = new DriveSubsystem();
        return ds;
    }

    public void drive(double speed, double turn) {
        drive.arcadeDrive(speed, turn);
    }
}
