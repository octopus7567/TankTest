package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Functions {
    
    private static Joystick joy1 = new Joystick(0);

    public static double speedmult = 0.4;
    public static double speed_limit()
    {
        if (joy1.getRawButtonPressed(5))
        {//botões iniciam em 1, não em 0      
            System.out.printf("%.1f",speedmult);
            speedmult -= 0.2;
            if (speedmult <= 0.2) speedmult = 0.2;
            System.out.printf(" [-] %.1f\n",speedmult);
        }        
        else if (joy1.getRawButtonPressed(6))
        {            
            System.out.printf("%.1f",speedmult);
            speedmult += 0.2;
            if (speedmult >= 1) speedmult = 1;
            System.out.printf(" [+] %.1f\n",speedmult);
        }   
        return speedmult;
    }
}

