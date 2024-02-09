package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSubsystem extends SubsystemBase {
    private WPI_TalonSRX motor;

    private static ClimberSubsystem instance;

    public static ClimberSubsystem getInstance() {
        if (instance == null) instance = new ClimberSubsystem();
        return instance;
    }
    
    public ClimberSubsystem() {
        motor = new WPI_TalonSRX(7);
        motor.set(0);
    }
    
    public void setSpeed(double speed) {
        motor.set(speed);
    }
}