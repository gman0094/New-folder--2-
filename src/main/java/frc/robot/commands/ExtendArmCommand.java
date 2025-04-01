package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.armsubsystem;

import java.util.function.DoubleSupplier;

public class ExtendArmCommand extends Command {
  private final armsubsystem armSubsystem;

  public ExtendArmCommand(armsubsystem armSubsystem) {
      this.armSubsystem = armSubsystem;
      addRequirements(armSubsystem);
  }

  @Override
  public void initialize() {
      armSubsystem.extendArm(); // Moves the arm to extended position
  }

  @Override
  public boolean isFinished() {
      return true; // Command ends immediately after execution
  }
}
