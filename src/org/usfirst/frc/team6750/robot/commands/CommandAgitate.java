package org.usfirst.frc.team6750.robot.commands;

import org.usfirst.frc.team6750.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class CommandAgitate extends Command {
	private static final double AGITATOR_SPEED = 0.5D;
	
	public CommandAgitate() {
		super();
	}
	
	@Override
	protected void initialize() {
		RobotMap.agitatorMotor.set(AGITATOR_SPEED);
	}

	@Override
	protected void interrupted() {
		RobotMap.agitatorMotor.set(0D);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}