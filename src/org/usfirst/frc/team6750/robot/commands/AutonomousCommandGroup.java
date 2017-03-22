package org.usfirst.frc.team6750.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The command group used during autonomous
 * 
 * Should ONLY be used during AUTONOMOUS
 */
public class AutonomousCommandGroup extends CommandGroup {
	public AutonomousCommandGroup() {
		super("Autonomous Commands"); // 15 SECONDS!!
		
		addSequential(new CommandDrive(5D, 0.6D, 0D)); //TEMP
	}
}