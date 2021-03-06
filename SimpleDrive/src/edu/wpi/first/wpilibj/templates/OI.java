
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.C_driveFR;
import edu.wpi.first.wpilibj.templates.commands.C_driveFL;
import edu.wpi.first.wpilibj.templates.commands.C_driveRR;
import edu.wpi.first.wpilibj.templates.commands.C_driveRL;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    public Joystick driveStick = new Joystick(1);
    
    Button button3 = new JoystickButton(driveStick,3);
    Button button4 = new JoystickButton(driveStick,4);
    Button button5 = new JoystickButton(driveStick,5);
    Button button6 = new JoystickButton(driveStick,6);
    
    public OI()
    {
        button3.whileHeld(new C_driveFR(0.5));
        button4.whileHeld(new C_driveFL(0.5));
        button5.whileHeld(new C_driveRR(0.5));
        button6.whileHeld(new C_driveRL(0.5));
    }
    
}

