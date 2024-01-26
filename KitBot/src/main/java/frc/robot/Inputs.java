package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.OperatorConstants;

public class Inputs {
    private static final XboxController driver1 = new XboxController(OperatorConstants.kDriver1ControllerPort);
    
    
	public static double getSpeed() {
        double speed = driver1.getLeftY();
        return speed;
    }

    public static double getTurn() {
        double turn = driver1.getRightX();
        return turn;
    }
}
