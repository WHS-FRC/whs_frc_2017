package org.usfirst.frc.team6750.robot.commands;

import org.usfirst.frc.team6750.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class CommandSetWinchSpeed extends Command {
	public int mode;
	public double speed;

	/**
	 * 0 = set, 1 = add
	 * 
	 * @param speed
	 */
	public CommandSetWinchSpeed(int mode, double speed) {
		this.requires(RobotMap.winchSystem);

		this.mode = mode;
		this.speed = speed;
	}

	@Override
	public void initialize() {
		if(mode == 0) {
			RobotMap.winchSystem.speed = speed;
		} else if(mode == 1) {
			RobotMap.winchSystem.speed += speed;
		}
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