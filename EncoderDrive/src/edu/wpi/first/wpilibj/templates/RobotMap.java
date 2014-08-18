package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    public static final int leftMotorPort1 = 3;
    public static final int leftMotorPort2 = 4;
    public static final int rightMotorPort1 = 1;
    public static final int rightMotorPort2 = 2;
    public static final int encoderPort1 = 7;
    public static final int encoderPort2 = 6;
    
    public static Encoder leftEncoder;
    
    public static Victor leftMotor1;
    public static Victor leftMotor2;
    public static Victor rightMotor1;
    public static Victor rightMotor2;
    
    public static RobotDrive chassis;
    
    public static void init()
    {
        leftMotor1 = new Victor(leftMotorPort1);
        leftMotor2 = new Victor(leftMotorPort2);
        rightMotor1 = new Victor(rightMotorPort1);
        rightMotor2 = new Victor(rightMotorPort2);
        
        chassis = new RobotDrive(leftMotor1,leftMotor2,rightMotor1,rightMotor2);
        chassis.setSafetyEnabled(false);
        
        leftEncoder = new Encoder(encoderPort2,encoderPort1);
        leftEncoder.start();
    }
}
