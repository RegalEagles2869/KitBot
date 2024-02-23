// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class AutoCommand extends Command {
  private int tick;
  private int maxTick;
  private double speed;
  private DriveSubsystem drive = DriveSubsystem.getInstance();
  /** Creates a new AutoCommand. */
  public AutoCommand(int maxTick, double speed) {
    addRequirements(drive);
    this.maxTick = maxTick;
    this.speed = speed;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    tick = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    tick++;
    drive.drive(speed, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (tick == maxTick) return true;
    return false;
  }
}
