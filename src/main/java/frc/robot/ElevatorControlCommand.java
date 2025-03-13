package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.elevatorsubsystem;;

public class ElevatorControlCommand extends Command {

    private final elevatorsubsystem elevatorSubsystem;
    private final double targetPosition;

    public ElevatorControlCommand(elevatorsubsystem elevatorSubsystem, double targetPosition) {
        this.elevatorSubsystem = elevatorSubsystem;
        this.targetPosition = targetPosition;
        addRequirements(elevatorSubsystem); // Now we pass in the subsystem
    }

    @Override
    public void initialize() {
        if (targetPosition > 0) {
            elevatorSubsystem.moveup(targetPosition); // Move elevator up
        } else {
            elevatorSubsystem.moveDown(targetPosition); // Move elevator down
        }
    }

    @Override
    public void end(boolean interrupted) {
        elevatorSubsystem.stop(); // Stop the elevator when the command ends
    }

    @Override
    public boolean isFinished() {
        // You can implement logic to determine when to stop the command (e.g., time-based, position-based)
        return true; // Finish immediately after executing
    }
}
