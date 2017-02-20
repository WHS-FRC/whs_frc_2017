package org.usfirst.frc.team6750.robot.commands;

import org.usfirst.frc.team6750.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	
	@Override
	public void initialize() {
		timer = new Timer();
		
		timer.start();
	}
	
	@Override
	public void execute() {
		RobotMap.robotDrive.arcadeDrive(moveSpeed, rotateSpeed);
		
		SmartDashboard.putNumber("Move Speed", moveSpeed);
		SmartDashboard.putNumber("Rotate Speed", rotateSpeed);
	}

	@Override
	protected boolean isFinished() {
		return timer.get() >= duration ? true : false;
	}
	
	@Override
	public void end() {
		timer.stop();
		RobotMap.robotDrive.arcadeDrive(0D, 0D);
		
		SmartDashboard.putNumber("Move Speed", 0);
		SmartDashboard.putNumber("Rotate Speed", 0);
	}

	@Override
	public void interrupted() {
		end();
	}
}