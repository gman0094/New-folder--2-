package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.io.ObjectInputFilter.Config;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;


public class elevatorsubsystem extends SubsystemBase {

    private final SparkMax elevatorMotor1;
    private final SparkMax elevatorMotor2;
    private double targetPosition;

    // Encoder constants
    private static final double POSITION_TOLERANCE = 0.05; // Allowable error when holding position
    private static final double MAX_SPEED = 0.5; // Max motor speed
    public void moveDown(double speed) {
      elevatorMotor1.set(speed); // Set motor speed in the reverse direction
      elevatorMotor2.set(speed);
    }

    public void moveup(double speed) {
      elevatorMotor1.set(-speed);
      elevatorMotor2.set(-speed);
    }


    public elevatorsubsystem() {
        // Initialize the two motors
        elevatorMotor1 = new SparkMax(2, MotorType.kBrushed); // Motor 1
        elevatorMotor2 = new SparkMax(3, MotorType.kBrushed); // Motor 2
        SparkMaxConfig config = new SparkMaxConfig();
        config.idleMode(IdleMode.kBrake);
        // Set both motors to brake mode
        elevatorMotor1.configure(config, SparkMax.ResetMode.kNoResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
        elevatorMotor2.configure(config, SparkMax.ResetMode.kNoResetSafeParameters, SparkMax.PersistMode.kPersistParameters);

        


        // Set encoder positions to 0 initially
        elevatorMotor1.getEncoder().setPosition(0);
        elevatorMotor2.getEncoder().setPosition(0);

        
    }

    // Method to move elevator to a specific position
    public void moveToPosition(double targetPosition) {
        this.targetPosition = targetPosition;
    }

    // Method to stop the elevator motors
    public void stop() {
        elevatorMotor1.set(0);
        elevatorMotor2.set(0);
    }

    // Method to hold the elevator's position
    public void holdPosition() {
        double currentPosition = elevatorMotor1.getEncoder().getPosition(); // Using motor 1's encoder
        if (Math.abs(currentPosition - targetPosition) > POSITION_TOLERANCE) {
            double speed = (targetPosition - currentPosition) > 0 ? MAX_SPEED : -MAX_SPEED;
            elevatorMotor1.set(speed);
            elevatorMotor2.set(speed); // Both motors move together
        } else {
            elevatorMotor1.set(0); // Hold position when close enough
            elevatorMotor2.set(0); // Both motors stop
        }
    }

    @Override
    public void periodic() {
        // Continuously check to hold position
        holdPosition();
    }

    public double getCurrentPosition() {
        return elevatorMotor1.getEncoder().getPosition(); // Get the current position from motor 1's encoder
    }
}
