package org.usfirst.frc.team6750.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class SingleCommandGroup extends CommandGroup {
	public SingleCommandGroup(Command command) {
		super(command.getName());
		
		this.addParallel(command);
	}
}