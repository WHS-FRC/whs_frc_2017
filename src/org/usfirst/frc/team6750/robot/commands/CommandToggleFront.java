package org.usfirst.frc.team6750.robot.commands;

import org.usfirst.frc.team6750.robot.RobotMap;
import org.usfirst.frc.team6750.robot.subsystems.DriveSystem.Side;

import edu.wpi.first.wpilibj.command.Command;

public class CommandToggleFront extends Command {
	public CommandToggleFront() {
		this.requires(RobotMap.driveSystem);
	}

	@Override
	public void initialize() {
		if(RobotMap.driveSystem.frontSide == Side.GEARCATCHER) {
			RobotMap.driveSystem.frontSide = Side.WINCH;
		} else {
			RobotMap.driveSystem.frontSide = Side.GEARCATCHER;
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