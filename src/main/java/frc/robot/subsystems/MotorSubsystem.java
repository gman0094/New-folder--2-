package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MotorSubsystem extends SubsystemBase {
    private final SparkMax motor;
    private final Timer timer = new Timer();
    
    private final double moveTime = 30; // Time in seconds to move motor
    private final double motorPower = 0.70; // Adjust based on your mechanism
    private boolean toggleState = false; // Tracks the target position

    public MotorSubsystem(int canID) {
        motor = new SparkMax(1, MotorType.kBrushed); // Brushed motor
    }

    public void toggleMotor() {
        toggleState = !toggleState; // Toggle between two positions
        timer.reset();
        timer.start();
    }

    @Override
    public void periodic() {
        if (timer.get() < moveTime) {
            motor.set(toggleState ? motorPower : -motorPower); // Move motor
        } else {
            motor.set(0); // Stop after moving
            timer.stop();
        }
    }
}
