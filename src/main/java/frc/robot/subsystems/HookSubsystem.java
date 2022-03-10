package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HookSubsystem extends SubsystemBase{
    public HookSubsystem() {
      Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
      DoubleSolenoid exampleDoublePCM = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);

      pcmCompressor.enableDigital();

      boolean enabled = pcmCompressor.enabled();
      boolean pressureSwitch = pcmCompressor.getPressureSwitchValue();
      double current = pcmCompressor.getCurrent();
    }
  
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
}

