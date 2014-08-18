/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Angelique
 */
public class changeMotorSpeedAutoC extends CommandBase {
    
    private boolean increment = false;
    private final int sec = 10;
    
    public changeMotorSpeedAutoC() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if (chassis.currSpeed == 1.0)
        {
            increment = false;
        }
        else if (chassis.currSpeed == 0.0)
        {
            increment = true;
        }
        else 
        {
            increment = true;
        }
        //automatically increments unless already at 1.0
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (increment)
        {
            chassis.ChangeMotorSpeed(0.1);
        }
        else if (!increment)
        {
            chassis.ChangeMotorSpeed(-0.1);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        
        Timer.delay(sec);
        return (chassis.currSpeed == 1.0 || chassis.currSpeed == 0.0);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
