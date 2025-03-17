package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

/** Class to run the algae rollers over CAN */
public class armsubsystem extends SubsystemBase {
  private final SparkMax armmotor;
  // private final SparkMaxConfig armConfig;


  public armsubsystem() {
    // Set up the roller motors as brushed motors
    armmotor = new SparkMax(5, MotorType.kBrushed);
    SparkMaxConfig armConfig = new SparkMaxConfig();

    armmotor.setCANTimeout(250);



    armConfig.voltageCompensation(12.0);  // Set to 12V
    armConfig.smartCurrentLimit(40);
    armConfig.inverted(false);  // false = normal, true = inverted

    armmotor.configure(armConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);




  }

  @Override
  public void periodic() {
  }

  /** This is a method that makes the roller spin */
  public void runalage(double forward, double reverse) {
    armmotor.set(forward - reverse);
  }
}