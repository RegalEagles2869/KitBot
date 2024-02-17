// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootCommand extends Command {
  private int sTick;
  private int tick;
  private int mTick;
  private double s;
  private ShooterSubsystem shooter = ShooterSubsystem.getInstance();
  /** Creates a new IntakeCommand. */
  public ShootCommand(int secondTick, double speed, int maxTick) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooter);
    s = speed;
    tick = 0;
    sTick = secondTick;
    mTick = maxTick;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    tick = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooter.shoot1(s);
    if (tick >= sTick) shooter.shoot2(s);
    tick++;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (tick == mTick) {
      return true;
    }
    return false;
  }
}
