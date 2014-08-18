/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.C_driveJoystick;

/**
 *
 * @author Angelique
 */
public class DriveTrainSS extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new C_driveJoystick());
    }
    
    public void driveF(double speed)
    {
        RobotMap.leftMotor1.set(-speed);
        RobotMap.leftMotor2.set(-speed);
        RobotMap.rightMotor1.set(speed);
        RobotMap.rightMotor2.set(speed);
    }
    
    public void arcade(Joystick driveStick)
    {
        RobotMap.chassis.arcadeDrive(driveStick);
    }
}
