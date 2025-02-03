package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase{
    
    private WPI_TalonSRX leftMotor1;
    private WPI_TalonSRX leftMotor2;
    private WPI_TalonSRX rightMotor1;
    private WPI_TalonSRX rightMotor2;
    private SupplyCurrentLimitConfiguration limit;

    private DifferentialDrive drive;

    private static DriveSubsystem ds;
    //talon.setNeutralMode(NeutralMode.)
    public DriveSubsystem() {
        // leftMotor1.setNeutralMode(NeutralMode.Coast);
        // leftMotor2.setNeutralMode(NeutralMode.Coast);
        // rightMotor1.setNeutralMode(NeutralMode.Coast);
        // rightMotor2.setNeutralMode(NeutralMode.Coast);

        limit  = new SupplyCurrentLimitConfiguration(true, 40, 40, 0);
        leftMotor1 = new WPI_TalonSRX(6);
        leftMotor2 = new WPI_TalonSRX(3);
        rightMotor1 = new WPI_TalonSRX(1);
        rightMotor2 = new WPI_TalonSRX(5);
        leftMotor1.configSupplyCurrentLimit(limit);
        leftMotor2.configSupplyCurrentLimit(limit);
        rightMotor1.configSupplyCurrentLimit(limit);
        rightMotor2.configSupplyCurrentLimit(limit);
        leftMotor1.follow(leftMotor2);
        rightMotor1.follow(rightMotor2);
        leftMotor1.setInverted(false);
        leftMotor2.setInverted(true);
        drive = new DifferentialDrive(leftMotor2, rightMotor2);
    }

    public static DriveSubsystem getInstance() {
        if (ds == null) ds = new DriveSubsystem();
        return ds;
    }

    public void drive(double speed, double turn) {
        drive.arcadeDrive(speed, turn);
    }
}
