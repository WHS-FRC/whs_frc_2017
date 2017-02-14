package org.usfirst.frc.team6750.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CommandGroupMove extends CommandGroup {
	public CommandGroupMove(double duration, double moveSpeed, double rotateSpeed) {
		super("CommandMove");

		this.addParallel(new CommandDrive(duration, moveSpeed, rotateSpeed));
	}
}