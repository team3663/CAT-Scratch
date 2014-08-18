/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.changeMotorSpeed;

/**
 *
 * @author Angelique
 */
public class Chassis extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public double currSpeed = 0;
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
      //  setDefaultCommand(new ArcadeDriveC());
        setDefaultCommand(new changeMotorSpeed(0.0));
    }
    public void ChangeMotorSpeed(double change)
    {
        /*currSpeed += change;
        if (currSpeed > 1.0)
        {
            currSpeed = 1;
        }
        else if (currSpeed < 0.0)
        {
            currSpeed = 0;
        }
        RobotMap.leftFrontMotor.set(-currSpeed);
        RobotMap.rightFrontMotor.set(currSpeed);
        RobotMap.leftRearMotor.set(-currSpeed);
        RobotMap.rightRearMotor.set(currSpeed);
        System.out.println("Change: " + change);
        System.out.println("Speed: " + currSpeed);*/
    }
    public void ResetToZero()
    {
        RobotMap.chassis.arcadeDrive(0,0);
    }
    public void ArcadeDrive(double y, double x, double motor)
    {
       /* if (y < 0.05 && x < 0.05)
        {
            RobotMap.chassis.arcadeDrive(0, 0);
        }
        else
        {
            RobotMap.chassis.arcadeDrive(y, x);
        }*/
        if (motor == 1)
        {
            RobotMap.leftFrontMotor.set(y);
        }
        else if (motor == 2)
        {
            RobotMap.rightFrontMotor.set(y);
        }
        else if (motor == 3)
        {
            RobotMap.leftRearMotor.set(y);
        }
        else if (motor == 4)
        {
            RobotMap.rightRearMotor.set(y);
        }
        
    }
}
