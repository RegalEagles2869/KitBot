// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootCommand extends Command {
  private int mTick;
  private int sTick;
  private int tick;
  private double s;
  private ShooterSubsystem shooter = ShooterSubsystem.getInstance();
  /** Creates a new IntakeCommand. */
  public ShootCommand(int secondTick, int maxTick, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooter);
    s = speed;
    tick = 0;
    sTick = secondTick;
    mTick = maxTick;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooter.shoot1(s);
    tick++;
    if (tick >= sTick) shooter.shoot2(s);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (tick == mTick) {
      shooter.stop();
      return true;
    }
    return false;
  }
}
