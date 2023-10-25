package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Joystick;

public class Updown {

    private static VictorSPX updownL = new VictorSPX(0);
    private static VictorSPX updownR = new VictorSPX(0);

    private static Joystick joy1 = new Joystick(0);
    
    public static void up_down()
    {
        if (joy1.getRawButton(3))
        {
            updownL.set(ControlMode.PercentOutput,0.2);
            updownR.set(ControlMode.PercentOutput,-0.2);
        }
        if (joy1.getRawButton(0))
        {
            updownL.set(ControlMode.PercentOutput, -0.2);
            updownR.set(ControlMode.PercentOutput,0.2);
        }
    }
}