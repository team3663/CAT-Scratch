
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.ArcadeDriveC;
import edu.wpi.first.wpilibj.templates.commands.changeMotorSpeedAutoC;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    private static Joystick DriveStick = new Joystick(1);

    private static Button button2,button3,button4,button5,button6;
    private static Button buttonDontUse;
    private static Button button1;
    public OI()
    {
        //button2 = new JoystickButton(DriveStick, 2);
       // button2.whenPressed(new changeMotorSpeed(-0.1));
        
        
        button3 = new JoystickButton(DriveStick, 3);
        //button3.whenPressed(new changeMotorSpeed(0.1));
        button3.whileHeld(new ArcadeDriveC(3));
        
        button4 = new JoystickButton(DriveStick, 4);
        button4.whileHeld(new ArcadeDriveC(4));
        
        button1 = new JoystickButton(DriveStick, 1);
     //   button1.whenPressed(new changeMotorSpeedAutoC());
        
    }
    public Joystick getDriveStick()
    {
        return DriveStick;
    }
    public int getButtonPressed()
    {
      //  int buttonNum = 0;
        for (int i = 1; i < 10; i++)
        {
            if (DriveStick.getRawButton(i))
            {
        //        buttonNum = i;
                return i;
            }
        }
        return 0;
     /*   switch(buttonNum)
        {
            case 5:
                return button5;
            case 3:
                return button3;
            default:
                return buttonDontUse;
        }*///when method is Button
    }
    
    
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

