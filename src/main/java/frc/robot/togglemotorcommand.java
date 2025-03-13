package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorSubsystem;

public class togglemotorcommand extends Command {
    private final MotorSubsystem motorSubsystem;

    public togglemotorcommand(MotorSubsystem subsystem) {
        motorSubsystem = subsystem;
        addRequirements(motorSubsystem);
    }

    @Override
    public void initialize() {
        motorSubsystem.toggleMotor();
    }

    @Override
    public boolean isFinished() {
        return true;  // Runs once and exits
    }
}
