package org.usfirst.frc.team6750.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;

public class RobotMap {
	/**
	 * 4 = front left
	 * 3 = back left
	 * 1 = front right
	 * 2 = back right
	 */
	public static Spark backLeftMotor = new Spark(3), frontLeftMotor = new Spark(4), backRightMotor = new Spark(2), frontRightMotor = new Spark(0);

	//1 and 2 are right, 3 and 4 are left

	public static RobotDrive robotDrive = new RobotDrive(backLeftMotor, frontLeftMotor, backRightMotor, frontRightMotor);

	public static Joystick xboxController = new Joystick(0);
}