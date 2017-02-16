package org.usfirst.frc.team6750.robot;

import static org.usfirst.frc.team6750.robot.RobotMap.*;
import static org.usfirst.frc.team6750.robot.Settings.*;

import org.usfirst.frc.team6750.robot.commands.CommandDrive;
import org.usfirst.frc.team6750.robot.commands.CommandShoot;
import org.usfirst.frc.team6750.robot.commands.SingleCommandGroup;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {
	public Robot() {
		robotDrive.setExpiration(0.1D);

		//"Who needs safety?"
		robotDrive.setSafetyEnabled(false);
	}

	@Override
	public void autonomousInit() {
		System.out.println("autonomous started");

		//Test autonomous command
		new SingleCommandGroup(new CommandDrive(2D, 0.75D, 0D));
	}

	@Override
	public void autonomousPeriodic() {
		 updateScheduler();
	}
	
	@Override
	public void teleopInit() {
	}

	@Override
	public void teleopPeriodic() {
		while(isOperatorControl() && isEnabled()) {
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
}
