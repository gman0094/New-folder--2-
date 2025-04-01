package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;


public class armsubsystem extends SubsystemBase {
    private final SparkMax armMotor = new SparkMax(20, MotorType.kBrushless); // Set correct CAN ID
    private boolean armExtended = false;

    public armsubsystem() {
      SparkMaxConfig armconfig = new SparkMaxConfig();
     armconfig.voltageCompensation(12.0);
     armconfig.smartCurrentLimit(40);
     armconfig.inverted(false);
     armMotor.configure(armconfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    /**
     * Extends the arm forward.
     */
    public void extendArm() {
        armMotor.set(0.4); // Adjust speed as needed
        armExtended = true;
    }

    /**
     * Retracts the arm backward.
     */
    public void retractArm() {
        armMotor.set(-0.05); // Adjust speed as needed
        armExtended = false;
    }

    /**
     * Stops the arm movement.
     */
    public void stopArm() {
        armMotor.set(0);
    }

    /**
     * Checks if the arm is extended.
     */
    public boolean isArmExtended() {
        return armExtended;
    }

    @Override
    public void periodic() {
        // Optional: Update telemetry data here if needed.
    }
}
