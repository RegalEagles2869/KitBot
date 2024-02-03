package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;

public class Inputs {
    private static final XboxController driver1 = new XboxController(OperatorConstants.kDriver1ControllerPort);
	private static final CommandXboxController driver1Com = new CommandXboxController(OperatorConstants.kDriver1ControllerPort);
    
    
	public static double getSpeed() {
        double speed = driver1.getLeftY();
        return speed;
    }

    public static double getTurn() {
        double turn = driver1.getRightX();
        return turn;
    }

    public static Trigger getShoot() {
        return driver1Com.b();
    }
    public static Trigger getIntake() {
        return driver1Com.y();
    }
}
