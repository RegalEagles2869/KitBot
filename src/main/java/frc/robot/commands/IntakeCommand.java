// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class IntakeCommand extends Command {
  private double s;
  private ShooterSubsystem shooter = ShooterSubsystem.getInstance();
  /** Creates a new IntakeCommand. */
  public IntakeCommand(double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooter);
    s = speed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooter.intake(s);
    //tick++;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //if (mTick == tick) return true;
    return false;
  }
}
