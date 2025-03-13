// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.pnumaticssubsystem;

public class retractsilonoidcommand extends Command {
  private final pnumaticssubsystem pneumatics;

  public retractsilonoidcommand(pnumaticssubsystem subsystem) {
      pneumatics = subsystem;
      addRequirements(pneumatics);
  }

  @Override
  public void initialize() {
      pneumatics.retract();
  }

  @Override
  public boolean isFinished() {
      return true;
  }
}
