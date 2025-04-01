package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

/** Class to run the rollers over CAN */
public class algaesubsystem extends SubsystemBase {
  private final SparkMax alage;

  public algaesubsystem() {
    // Set up the roller motor as a brushless motor
    alage = new SparkMax(9, MotorType.kBrushed);

    // Set can timeout. Because this project only sets parameters once on
    // construction, the timeout can be long without blocking robot operation. Code
    // which sets or gets parameters during operation may need a shorter timeout.
    alage.setCANTimeout(250);

    // Create and apply configuration for roller motor. Voltage compensation helps
    // the roller behave the same as the battery
    // voltage dips. The current limit helps prevent breaker trips or burning out
    // the motor in the event the roller stalls.
    SparkMaxConfig alageConfig = new SparkMaxConfig();
   alageConfig.voltageCompensation(12.0);
   alageConfig.smartCurrentLimit(40);
    alageConfig.inverted(true);
    alage.configure(alageConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  @Override
  public void periodic() {
  }

  /** This is a method that makes the roller spin */
  public void runrollor(double forward, double reverse) {
    alage.set(forward - reverse);
  }
}