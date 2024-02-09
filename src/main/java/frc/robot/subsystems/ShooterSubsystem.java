package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

    private static ShooterSubsystem instance;
    private WPI_TalonSRX shooter1;
    private WPI_TalonSRX shooter2;

    public static ShooterSubsystem getInstance() {
        if (instance == null) instance = new ShooterSubsystem();
        return instance;
    }

    public ShooterSubsystem() {
        shooter1 = new WPI_TalonSRX(1);
        shooter2 = new WPI_TalonSRX(2);
        stop();
    }
    
    public void shoot1(double speed) {
        shooter1.set(speed);
    }

    public void shoot2(double speed) {
        shooter2.set(speed);
    }

    public void intake(double speed) {
        shooter1.set(-speed);
        shooter2.set(-speed);
    }

    public void stop() {
        shooter1.set(0);
        shooter2.set(0);
    }
}
