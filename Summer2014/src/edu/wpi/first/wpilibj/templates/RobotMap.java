package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
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
    public static final int leftFrontMotorPort = 4;
    public static final int rightFrontMotorPort = 2;
    public static final int leftRearMotorPort = 3;
    public static final int rightRearMotorPort = 1;
    
    public static final int MainModule = 1;
    
    public static SpeedController leftFrontMotor;
    public static SpeedController rightFrontMotor;
    public static SpeedController leftRearMotor;
    public static SpeedController rightRearMotor;
    
    public static RobotDrive chassis;
    
    public static void init()
    {
        leftFrontMotor = new Victor(MainModule, leftFrontMotorPort);
        rightFrontMotor = new Victor(MainModule, rightFrontMotorPort);
        leftRearMotor = new Victor(MainModule, leftRearMotorPort);
        rightRearMotor = new Victor(MainModule, rightRearMotorPort);
        
        chassis = new RobotDrive(leftFrontMotor, leftRearMotor, 
                                    rightFrontMotor, rightRearMotor);
        chassis.setSafetyEnabled(false);
 /*       leftFrontMotor.set(0.5);
        rightFrontMotor.set(0.3);
        leftRearMotor.set(0.5);
        rightRearMotor.set(0.3);
        System.out.println("it should be driving");*/
    }
}
