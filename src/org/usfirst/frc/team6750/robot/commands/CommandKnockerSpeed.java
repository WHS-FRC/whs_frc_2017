package org.usfirst.frc.team6750.robot.commands;

import org.usfirst.frc.team6750.robot.Settings;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Adds the given speed to the already set gear knocker speed
 */
public class CommandKnockerSpeed extends Command {
	private double speed = -100;

	public CommandKnockerSpeed(double speed) {
		this.speed = speed;
	}

	@Override
	public void initialize() {
	}

	@Override
	public void execute() {
		Settings.GEAR_KNOCKER_MOTOR_SPEED += speed;

		if(Settings.GEAR_KNOCKER_MOTOR_SPEED > 1D) {
			Settings.GEAR_KNOCKER_MOTOR_SPEED = 1D;
		} else if(Settings.GEAR_KNOCKER_MOTOR_SPEED < 0.2D) {
			Settings.GEAR_KNOCKER_MOTOR_SPEED = 0.2D;
		}
		
		System.out.println("Added " + speed);
		System.out.println("Current Speed: " + Settings.GEAR_KNOCKER_MOTOR_SPEED);
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