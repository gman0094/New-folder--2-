package frc.robot.subsystems;




import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class pnumaticssubsystem extends SubsystemBase {
  private final DoubleSolenoid doubleSolenoid;

  public pnumaticssubsystem() {
      doubleSolenoid = new DoubleSolenoid(
          PneumaticsModuleType.REVPH, 
          0,  
          1   
      );
  }

  public void extend() {
      doubleSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void retract() {
      doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void off() {
      doubleSolenoid.set(DoubleSolenoid.Value.kOff);
  }
}
