// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimberSubsystem;

public class SetClimberSpeed extends Command {
  ClimberSubsystem climber = ClimberSubsystem.getInstance();
  double speed;
  /** Creates a new MoveClimberUp. */
  public SetClimberSpeed(double speed) {
    addRequirements(climber);
    this.speed = speed;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    climber.setSpeed(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climber.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
    
  }
  /* If CDVDD breaks due to there being no safety, it is ALL Jackson's fault.
   * - Hunter
   * - Navreet 
   * - Matthew Tusa :)
   */
}
