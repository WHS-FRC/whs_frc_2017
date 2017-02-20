package org.usfirst.frc.team6750.robot;

import static org.usfirst.frc.team6750.robot.RobotMap.*;
import static org.usfirst.frc.team6750.robot.Settings.*;

import org.usfirst.frc.team6750.robot.commands.AutonomousCommandGroup;
import org.usfirst.frc.team6750.robot.commands.CommandShoot;
import org.usfirst.frc.team6750.robot.commands.SingleCommandGroup;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	@Override
	public void robotInit() {
		robotDrive.setExpiration(0.1D);

		robotDrive.setSafetyEnabled(true);
		
		SmartDashboard.putString("Starting Position", Settings.STARTING_POSITION.getName());
	}
	
	@Override
	public void testInit() {
		updateSettings();
	}

	@Override
	public void testPeriodic() {
		updateSettings();
		updateScheduler();
	}

	@Override
	public void autonomousInit() {
		System.out.println("autonomous started");

		updateSettings();
		new AutonomousCommandGroup().start();
	}

	@Override
	public void autonomousPeriodic() {
		updateSettings();
		updateScheduler();
	}

	@Override
	public void teleopInit() {
		updateSettings();
	}

	@Override
	public void teleopPeriodic() {
		while(isOperatorControl() && isEnabled()) {
			updateSettings();
			updateScheduler();

			drive();
			handleShooter();

			Timer.delay(0.005D);
		}
	}

	/**
	 * Drives the robot
	 */
	private void drive() {
		//Get axis values from the xbox controller
		double fastRotateAxis = xboxController.getRawAxis(0);
		double fastMoveAxis = xboxController.getRawAxis(1);
		double slowRotateAxis = xboxController.getRawAxis(4);
		double slowMoveAxis = xboxController.getRawAxis(5);

		//Values that will eventually pass into the RobotDrive
		double rotateSpeed = 0D, moveSpeed = 0D;

		//Determines whether to use the fast axis or the slow axis based on which one is faster
		if(Math.abs(fastRotateAxis) > Math.abs(slowRotateAxis * SLOW_MOVE_MODIFIER)) {
			rotateSpeed = fastRotateAxis;
		} else {
			rotateSpeed = (slowRotateAxis * SLOW_MOVE_MODIFIER);
		}

		if(Math.abs(fastMoveAxis) > Math.abs(slowMoveAxis * SLOW_MOVE_MODIFIER)) {
			moveSpeed = fastMoveAxis;
		} else {
			moveSpeed = (slowMoveAxis * SLOW_MOVE_MODIFIER);
		}

		moveSpeed *= -1D;
		rotateSpeed *= -1D;

		//Send move and rotate values to the RobotDrive
		robotDrive.arcadeDrive(moveSpeed, rotateSpeed);
	}

	/**
	 * Handles input used to shoot fuel cells
	 */
	private void handleShooter() {
		double shootAxis = lgController.getRawAxis(1);

		if(shootAxis < 0) {
			shootAxis = 0;
		}

		new SingleCommandGroup(new CommandShoot(shootAxis)).start();
	}

	/**
	 * Calls the run() method in Scheduler, I guess it's like an update method?
	 */
	private void updateScheduler() {
		Scheduler.getInstance().run();
	}
	
	/**
	 * Loads data from the dashboard to the Settings
	 * 
	 * Should be called in every init and periodic to ensure up-to-date information
	 */
	private void updateSettings() {
		Settings.STARTING_POSITION = Position.getPosition(SmartDashboard.getString("Starting Position", Position.MIDDLE.getName()));
	}
}
