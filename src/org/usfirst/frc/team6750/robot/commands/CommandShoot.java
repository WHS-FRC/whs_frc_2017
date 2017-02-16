package org.usfirst.frc.team6750.robot.commands;

import org.usfirst.frc.team6750.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class CommandShoot extends Command {
	public double speed;
	
	public CommandShoot(double speed) {
		this.speed = speed;
		
		this.requires(RobotMap.shooterSystem);
	}
	
	@Override
	public void initialize() {
	}
	
	@Override
	public void execute() {
		RobotMap.shooterSystem.shooterMotor.set(speed);
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
	}
}