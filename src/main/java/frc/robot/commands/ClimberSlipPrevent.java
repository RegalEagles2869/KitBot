// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Inputs;
import frc.robot.subsystems.ClimberSubsystem;

public class ClimberSlipPrevent extends Command {
  ClimberSubsystem climber = ClimberSubsystem.getInstance();
  DigitalInput limit = ClimberSubsystem.getLimitSwitch();
  double speed;
  /** Creates a new ClimberSlipPrevent. */
  public ClimberSlipPrevent(double speed) {
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
    if(limit.get()) {
      climber.setSpeed(speed);
    } else {
      climber.setSpeed(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climber.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Inputs.getClimberDown().getAsBoolean()) {
      return true;
    } else {
      return false;
    }
  }
}
