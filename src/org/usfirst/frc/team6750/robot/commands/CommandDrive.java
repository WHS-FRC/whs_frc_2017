package org.usfirst.frc.team6750.robot.commands;

import org.usfirst.frc.team6750.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Drives the robot using a given duration, speed, and rotation
 */
public class CommandDrive extends Command {
	public Timer timer;
	public double duration, moveSpeed, rotateSpeed;

	/**
	 * Used to drive and steer the robot for a given speed and given duration
	 * 
	 * @param duration time in seconds for move to last
	 * @param moveSpeed speed in WPI Lib's "speed" units
	 * @param rotateSpeed rotate speed
	 */
	public CommandDrive(double duration, double moveSpeed, double rotateSpeed) {
		this.duration = duration;
		this.moveSpeed = moveSpeed;
		this.rotateSpeed = rotateSpeed;

		//this.requires(RobotMap.driveSystem);

		System.err.println("MOVE SPEED: " + moveSpeed);
	}

	/**
	 * Starts the timer
	 */
	@Override
	public void initialize() {
		timer = new Timer();

		timer.start();
	}

	/**
	 * Called every "periodic," ensures a constant speed
	 */
	@Override
	public void execute() {
		RobotMap.robotDrive.arcadeDrive(moveSpeed, rotateSpeed);
		RobotMap.driveSystem.adjustJaguars();
	}

	/**
	 * Returns true when finished
	 * 
	 * Only checks if the timer is past the duration
	 */
	@Override
	protected boolean isFinished() {
		return timer.get() >= duration ? true : false;
	}

	/**
	 * Shuts off all motors and stops the timer
	 */
	@Override
	public void end() {
		timer.stop();
		RobotMap.robotDrive.arcadeDrive(0D, 0D);

		RobotMap.driveSystem.backLeftMotor.setSpeed(0);
		RobotMap.driveSystem.backRightMotor.setSpeed(0);
	}

	@Override
	public void interrupted() {
		end();
	}
}