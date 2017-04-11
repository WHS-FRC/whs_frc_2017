package org.usfirst.frc.team6750.robot.commands;

import org.usfirst.frc.team6750.robot.RobotMap;
import org.usfirst.frc.team6750.robot.subsystems.DriveSystem.Side;

import edu.wpi.first.wpilibj.command.Command;

public class CommandToggleWinchMotor extends Command {
	public CommandToggleWinchMotor() {
		this.requires(RobotMap.winchSystem);
	}

	@Override
	public void initialize() {
		RobotMap.winchSystem.on = !RobotMap.winchSystem.on;
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