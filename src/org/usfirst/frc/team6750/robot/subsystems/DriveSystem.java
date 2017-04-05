package org.usfirst.frc.team6750.robot.subsystems;

import static org.usfirst.frc.team6750.robot.RobotMap.*;

import org.usfirst.frc.team6750.robot.RobotMap;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Composed of the 4 motors used to drive the robot
 */
public class DriveSystem extends Subsystem {
	/**
	 * The axes input from the slow joystick are multiplied by this to get the speed sent to the RobotDrive
	 */
	public static final double SLOW_MOVE_MODIFIER = 0.65D;

	public Jaguar backLeftMotor, frontRightMotor;
	public Spark backRightMotor, frontLeftMotor;

	public DriveSystem() {
		super();

		backLeftMotor = new Jaguar(RobotMap.BACK_LEFT_MOTOR);
		backRightMotor = new Spark(RobotMap.BACK_RIGHT_MOTOR);
		frontLeftMotor = new Spark(RobotMap.FRONT_LEFT_MOTOR);
		frontRightMotor = new Jaguar(RobotMap.FRONT_RIGHT_MOTOR);
	}

	@Override
	protected void initDefaultCommand() {
	}

	/**
	 * Drives the robot
	 */
	public void update() {
		// Get axis values from the xbox controller
		double fastRotateAxis = xboxController.getRawAxis(0);
		double fastMoveAxis = xboxController.getRawAxis(1);
		double slowRotateAxis = xboxController.getRawAxis(4);
		double slowMoveAxis = xboxController.getRawAxis(5);

		// Values that will eventually pass into the RobotDrive
		double rotateSpeed = 0D, moveSpeed = 0D;

		double slowRotateSpeed = slowRotateAxis * SLOW_MOVE_MODIFIER, slowMoveSpeed = slowMoveAxis * SLOW_MOVE_MODIFIER;

		// Determines whether to use the fast axis or the slow axis based on
		// which one is faster
		if(Math.abs(fastRotateAxis) > Math.abs(slowRotateSpeed)) {
			rotateSpeed = fastRotateAxis;
		} else {
			rotateSpeed = slowRotateSpeed;
		}

		if(Math.abs(fastMoveAxis) > Math.abs(slowMoveSpeed)) {
			moveSpeed = fastMoveAxis;
		} else {
			moveSpeed = slowMoveSpeed;
		}

		moveSpeed *= 1D; //finally forward (battery is in the front)
		rotateSpeed *= -1D; // rotate is always backwards

		// Send move and rotate values to the RobotDrive
		robotDrive.arcadeDrive(moveSpeed, rotateSpeed);

		adjustSpeeds();
	}

	/**
	 * Left is faster than right
	 * 
	 */
	private void adjustSpeeds() {
		double offset = 0.175D;

		double backSpeed = backLeftMotor.getSpeed(), frontSpeed = frontLeftMotor.getSpeed();
		boolean bPositive = backSpeed > offset, fPositive = frontSpeed > (-offset);

		backSpeed += offset * (bPositive ? 1D : -1D);
		frontSpeed += offset * (fPositive ? 1D : -1D);

		backLeftMotor.setSpeed(backSpeed);
		frontLeftMotor.setSpeed(frontSpeed);
	}
}