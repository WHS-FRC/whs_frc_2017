package org.usfirst.frc.team6750.robot;

import static org.usfirst.frc.team6750.robot.RobotMap.*;
import static org.usfirst.frc.team6750.robot.Settings.*;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 *
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 * WARNING: While it may look like a good choice to use for your code if you're
 * inexperienced, don't. Unless you know what you are doing, complex code will
 * be much more difficult under this system. Use IterativeRobot or Command-Based
 * instead if you're new.
 */
public class Robot extends SampleRobot {
	public Robot() {
		initRobotDrive();
		initMotors();
	}

	private void initRobotDrive() {
		robotDrive.setExpiration(0.1D);

		//"Who needs safety?"
		robotDrive.setSafetyEnabled(false);
	}

	private void initMotors() {
		//Motors were attached backwards
		backLeftMotor.setInverted(true);
		frontLeftMotor.setInverted(true);
		backRightMotor.setInverted(true);
		frontRightMotor.setInverted(true);
	}

	@Override
	public void operatorControl() {
		while(isOperatorControl() && isEnabled()) {
			drive();

			Timer.delay(0.005D);
		}
	}

	@Override
	protected void disabled() {
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
}
