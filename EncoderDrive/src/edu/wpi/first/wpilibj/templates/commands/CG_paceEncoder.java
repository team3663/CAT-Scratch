/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Angelique
 */
public class CG_paceEncoder extends CommandGroup {
    
    public CG_paceEncoder() {
        addSequential(new C_driveEncoder(6000));
        addSequential(new C_wait(0.7));
        addSequential(new C_turnRightEncoder(5300));
        addSequential(new C_wait(0.5));
        addSequential(new C_driveEncoder(6000));
        addSequential(new C_wait(0.7));
        addSequential(new C_turnLeftEncoder(4800));
        addSequential(new C_wait(0.3));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
