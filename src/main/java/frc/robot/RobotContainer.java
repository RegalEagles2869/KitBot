// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ClimberSlipPrevent;
import frc.robot.commands.DefaultDriveCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.RevBackMotor;
import frc.robot.commands.RevFrontMotor;
import frc.robot.commands.SetAmpSpeed;
import frc.robot.commands.SetClimberSpeed;
import frc.robot.commands.ShootCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem driveSubSystem = DriveSubsystem.getInstance();
  private final ShooterSubsystem shooter = ShooterSubsystem.getInstance();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController = new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    driveSubSystem.setDefaultCommand(new DefaultDriveCommand());
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    Inputs.getShoot().onTrue(new ShootCommand(100, 1, 200));
    Inputs.getIntake().whileTrue(new IntakeCommand(.75));
    Inputs.getClimberDown().whileTrue(new SetClimberSpeed(1));
    Inputs.getClimberUp().whileTrue(new SetClimberSpeed(-1));
    Inputs.getSlipPrevent().onTrue(new ClimberSlipPrevent(-1));
    // Inputs.revShoot().whileTrue(new RevFrontMotor(1));
    // Inputs.revBack().whileTrue(new RevBackMotor(.5));
    Inputs.getAmpOutake().whileTrue(new SetAmpSpeed(1));
    Inputs.getAmpIntake().whileTrue(new SetAmpSpeed(-.5));
    
    Inputs.getAmpIntake().whileTrue(new SetAmpSpeed(-.5));

    
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    // m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
}
