package org.usfirst.frc.team6750.robot;

import static org.usfirst.frc.team6750.robot.RobotMap.lg7;
import static org.usfirst.frc.team6750.robot.RobotMap.lg8;
import static org.usfirst.frc.team6750.robot.RobotMap.robotDrive;
import static org.usfirst.frc.team6750.robot.RobotMap.xboxController;
import static org.usfirst.frc.team6750.robot.Settings.SLOW_MOVE_MODIFIER;

import org.usfirst.frc.team6750.robot.commands.AutonomousCommandGroup;
import org.usfirst.frc.team6750.robot.commands.CommandToggleWinch;
import org.usfirst.frc.team6750.robot.commands.CommandWinchReverse;
import org.usfirst.frc.team6750.robot.commands.SingleCommandGroup;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Main robot class
 * 
 * Don't delete
 */
public class Robot extends IterativeRobot {
	@Override
	public void robotInit() {
		robotDrive.setExpiration(0.1D);

		robotDrive.setSafetyEnabled(true);

		addDashboardSettings();
		addCommands();
	}

	private void addDashboardSettings() {
		SmartDashboard.putNumber("Back Left Motor", RobotMap.driveSystem.backLeftMotor.getSpeed());
		SmartDashboard.putNumber("Front Left Motor", RobotMap.driveSystem.frontLeftMotor.getSpeed());
		SmartDashboard.putNumber("Back Right Motor", RobotMap.driveSystem.backRightMotor.getSpeed());
		SmartDashboard.putNumber("Front Right Motor", RobotMap.driveSystem.frontRightMotor.getSpeed());

		SmartDashboard.putNumber("Left Winch Motor", RobotMap.winchSystem.leftMotor.getSpeed());
		SmartDashboard.putNumber("Right Winch Motor", RobotMap.winchSystem.rightMotor.getSpeed());
	}

	private void addCommands() {
		lg7.whenPressed(new SingleCommandGroup(new CommandToggleWinch()));
		lg8.whenPressed(new SingleCommandGroup(new CommandWinchReverse()));

	}

	@Override
	public void testInit() {
	}

	@Override
	public void testPeriodic() {
		updateScheduler();
	}

	@Override
	public void autonomousInit() {
		System.out.println("Autonomous Started`");

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
		while (isOperatorControl() && isEnabled()) {
			updateSettings();
			updateScheduler();

			handleWinch();
			drive();

			Timer.delay(0.005D);
		}
	}

	private void handleWinch() {
		RobotMap.winchSystem.updateSpeed();
	}

	/**
	 * Drives the robot
	 */
	private void drive() {
		// Get axis values from the xbox controller
		double fastRotateAxis = xboxController.getRawAxis(0);
		double fastMoveAxis = xboxController.getRawAxis(1);
		double slowRotateAxis = xboxController.getRawAxis(4);
		double slowMoveAxis = xboxController.getRawAxis(5);

		// Values that will eventually pass into the RobotDrive
		double rotateSpeed = 0D, moveSpeed = 0D;

		// Determines whether to use the fast axis or the slow axis based on
		// which one is faster
		if (Math.abs(fastRotateAxis) > Math.abs(slowRotateAxis * SLOW_MOVE_MODIFIER)) {
			rotateSpeed = fastRotateAxis;
		} else {
			rotateSpeed = (slowRotateAxis * SLOW_MOVE_MODIFIER);
		}

		if ((Math.abs(fastMoveAxis * SLOW_MOVE_MODIFIER)) > Math.abs(slowMoveAxis * SLOW_MOVE_MODIFIER)) {
			moveSpeed = fastMoveAxis;
		} else {
			moveSpeed = (slowMoveAxis * SLOW_MOVE_MODIFIER);
		}

		moveSpeed *= -1D; // Either the controller axes are backwards or the
							// motors are backwards
		rotateSpeed *= -1D;

		// Send move and rotate values to the RobotDrive
		robotDrive.arcadeDrive(moveSpeed, rotateSpeed);
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
	 * Should be called in every init and periodic to ensure up-to-date
	 * information
	 */
	private void updateSettings() {
		SmartDashboard.putNumber("Back Left Motor", RobotMap.driveSystem.backLeftMotor.getSpeed());
		SmartDashboard.putNumber("Front Left Motor", RobotMap.driveSystem.frontLeftMotor.getSpeed());
		SmartDashboard.putNumber("Back Right Motor", RobotMap.driveSystem.backRightMotor.getSpeed());
		SmartDashboard.putNumber("Front Right Motor", RobotMap.driveSystem.frontRightMotor.getSpeed());

		SmartDashboard.putNumber("Left Winch Motor", RobotMap.winchSystem.leftMotor.getSpeed());
		SmartDashboard.putNumber("Right Winch Motor", RobotMap.winchSystem.rightMotor.getSpeed());
	}
}
