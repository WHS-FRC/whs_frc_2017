package org.usfirst.frc.team6750.robot;

import org.usfirst.frc.team6750.robot.subsystems.DriveSystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Maps out the entire robot
 * 
 * Contains the motors, subsystems, controllers, pneumatics, etc.
 */
public class RobotMap {
	/**
	 * *gear catcher is in front
	 * Used to globally define what motors are what
	 * 
	 * 3 is back right spark
	 * 4 is front right jaguar
	 * 0 is back left jaguar
	 * 5 is front left spark
	 * 
	 * Also makes it easy to change the motors
	 * 
	 */
	public static final int BACK_LEFT_MOTOR = 0, FRONT_LEFT_MOTOR = 5, BACK_RIGHT_MOTOR = 3, FRONT_RIGHT_MOTOR = 4;

	/**
	 * Contains the motors used to drive
	 */
	public static DriveSystem driveSystem = new DriveSystem();

	/**
	 * Used to drive the robot
	 * 
	 * The order in which the parameters are entered is intended to be that way
	 * (see doc for RobotDrive)
	 */
	public static RobotDrive robotDrive = new RobotDrive(driveSystem.backLeftMotor, driveSystem.frontLeftMotor,
			driveSystem.backRightMotor, driveSystem.frontRightMotor);

	/**
	 * The Xbox controller
	 * 
	 * Should always be the first controller plugged in
	 */
	public static Joystick xboxController = new Joystick(0);

	public static JoystickButton xboxA = new JoystickButton(xboxController, 1),
			xboxB = new JoystickButton(xboxController, 2), xboxX = new JoystickButton(xboxController, 3),
			xboxY = new JoystickButton(xboxController, 4), xboxLT = new JoystickButton(xboxController, 5),
			xboxRT = new JoystickButton(xboxController, 6);

	/**
	 * The Logitech controller
	 * 
	 * Should always by the second controller plugged in
	 */
	public static Joystick lgController = new Joystick(1);

	public static JoystickButton lg7 = new JoystickButton(lgController, 7);
	public static JoystickButton lg8 = new JoystickButton(lgController, 8);
}