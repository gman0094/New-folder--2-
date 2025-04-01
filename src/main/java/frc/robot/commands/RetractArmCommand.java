// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.armsubsystem;

public class RetractArmCommand extends Command {
  private final armsubsystem armSubsystem;

  public RetractArmCommand(armsubsystem armSubsystem) {
      this.armSubsystem = armSubsystem;
      addRequirements(armSubsystem);
  }

  @Override
  public void initialize() {
      armSubsystem.retractArm(); // Moves the arm to retracted position
  }

  @Override
  public boolean isFinished() {
      return true; // Command ends immediately after execution
  }
}
