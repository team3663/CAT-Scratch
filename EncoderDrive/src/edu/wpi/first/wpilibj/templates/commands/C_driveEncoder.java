/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Angelique
 */
public class C_driveEncoder extends CommandBase {
    
    public int amount;
    public int currTick;
    
    public C_driveEncoder(int tickAmount) {
        // Use requires() here to declare subsystem dependencies
        requires(driveTrainSS);
        amount = tickAmount;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        RobotMap.leftEncoder.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        driveTrainSS.driveF(0.3);
        currTick = RobotMap.leftEncoder.getRaw();
        if (currTick >= amount)
        {
            driveTrainSS.driveF(-0.1);
        }
        System.out.println("encoderTicks: " + currTick);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (currTick >= amount)
        {
            driveTrainSS.driveF(0);
            currTick = RobotMap.leftEncoder.getRaw();
            System.out.println("EncoderTicks: " + currTick);
            return true;
        }
        else
        {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
