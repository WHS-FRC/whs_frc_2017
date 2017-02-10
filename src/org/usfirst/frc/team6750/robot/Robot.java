package org.usfirst.frc.team6750.robot;

import static org.usfirst.frc.team6750.robot.RobotMap.*;

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
	}

	private void initMotors() {
		backLeftMotor.setInverted(true);
		frontLeftMotor.setInverted(true);
		backRightMotor.setInverted(true);
		frontRightMotor.setInverted(true);

		backLeftMotor.setSafetyEnabled(false);
		frontLeftMotor.setSafetyEnabled(false);
		backRightMotor.setSafetyEnabled(false);
		frontRightMotor.setSafetyEnabled(false);
	}

	/**
	 * Runs the motors with tank steering.
	 */
	@Override
	public void operatorControl() {
		while(isOperatorControl() && isEnabled()) {
			drive();

			Timer.delay(0.005);
		}
	}

	private void drive() {
		//robotDrive.arcadeDrive(xboxController);
		
		//robotDrive.setSensitivity(1D);
		//robotDrive.setMaxOutput(1D);
		
		double fastRotateAxis = xboxController.getRawAxis(0);
		double fastMoveAxis = xboxController.getRawAxis(1);
		
		double slowRotateAxis = xboxController.getRawAxis(4);
		double slowMoveAxis = xboxController.getRawAxis(5);
		
		double rotateSpeed = 0D, moveSpeed = 0D;
		
		if(fastRotateAxis > slowRotateAxis) {
			rotateSpeed = fastRotateAxis;
		} else {
			rotateSpeed = slowRotateAxis / 2D;
		}
		
		if(fastMoveAxis > slowMoveAxis) {
			moveSpeed = fastMoveAxis;
		} else {
			moveSpeed = slowMoveAxis / 2D;
		}
		
		robotDrive.arcadeDrive(moveSpeed, rotateSpeed);
		
		System.out.println("FAST MOVE AXIS: " + fastMoveAxis);
		System.out.println("MOVE SPEED: " + moveSpeed);
	}
}
