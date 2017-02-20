package org.usfirst.frc.team6750.robot.commands;

import org.usfirst.frc.team6750.robot.RobotMap;
import org.usfirst.frc.team6750.robot.Settings;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Turns on the gear knocker
 * 
 * The speed can be set in the settings via the dash board
 */
public class CommandKnockGears extends Command {
	public CommandKnockGears() {
		this.requires(RobotMap.gearLoaderSystem);
	}

	@Override
	public void initialize() {
	}

	@Override
	public void execute() {
		RobotMap.gearLoaderSystem.gearKnocker.set(Settings.GEAR_KNOCKER_MOTOR_SPEED);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	public void end() {
		RobotMap.gearLoaderSystem.gearKnocker.set(0D);
	}

	@Override
	public void interrupted() {
		end();
	}
}