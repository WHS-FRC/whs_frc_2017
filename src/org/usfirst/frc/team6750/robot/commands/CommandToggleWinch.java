package org.usfirst.frc.team6750.robot.commands;

import org.usfirst.frc.team6750.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Turns on the gear knocker
 * 
 * The speed can be set in the settings via the dash board
 */
public class CommandToggleWinch extends Command {
	public CommandToggleWinch() {
		this.requires(RobotMap.winchSystem);
	}

	@Override
	public void initialize() {
		RobotMap.winchSystem.toggle();
	}

	@Override
	public void execute() {
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	public void end() {
	}

	@Override
	public void interrupted() {
		end();
	}
}