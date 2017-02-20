package org.usfirst.frc.team6750.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Used to only call one command at a time instead of having a group of commands
 */
public class SingleCommandGroup extends CommandGroup {
	public SingleCommandGroup(Command command) {
		super(command.getName());

		this.addParallel(command);
	}
}