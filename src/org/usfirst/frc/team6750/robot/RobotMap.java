package org.usfirst.frc.team6750.robot;

import org.usfirst.frc.team6750.robot.subsystems.DriveSystem;
import org.usfirst.frc.team6750.robot.subsystems.ShooterSystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * Maps out the entire robot
 * 
 * Contains the motors, subsystems, controllers, pneumatics, etc.
 */
public class RobotMap {
	/**
	 * Used to globally define what motors are what
	 * 
	 * Also makes it easy to change the motors
	 */
	public static final int BACK_LEFT_MOTOR = 0, FRONT_LEFT_MOTOR = 2, BACK_RIGHT_MOTOR = 3, FRONT_RIGHT_MOTOR = 4;
	public static final int SHOOTER_MOTOR = 5;

	/**
	 * Contains the motors used to drive
	 */
	public static DriveSystem driveSystem = new DriveSystem();

	/**
	 * Contains the motor used to shoot fuel cells
	 */
	public static ShooterSystem shooterSystem = new ShooterSystem();

	/**
	 * Used to drive the robot
	 * 
	 * The order in which the parameters are entered is intended to be that way (see doc for RobotDrive)
	 */
	public static RobotDrive robotDrive = new RobotDrive(driveSystem.backLeftMotor, driveSystem.frontLeftMotor, driveSystem.backRightMotor, driveSystem.frontRightMotor);

	/**
	 * The Xbox controller
	 * 
	 * Should always be the first controller plugged in
	 */
	public static Joystick xboxController = new Joystick(0);

	/**
	 * The Logitech controller
	 * 
	 * Should always by the second controller plugged in
	 */
	public static Joystick lgController = new Joystick(1);
}