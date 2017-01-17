package org.usfirst.frc.team6750.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class RobotMap {
	/**
	 * The Logitech controller
	 */
	public static Joystick logitechController;
	
	/**
	 * The buttons on the Logitech controller (by their physical labels)
	 */
	public static JoystickButton trigger,
			button2, button3, button4, button5, button6,
			button7, button8, button9, button10, button11, button12;
	
	/**
	 * TODO name axes
	 */
	public static AxisType axis;

	/**
	 * The Xbox controller
	 */
	public static Joystick xboxController;
	
	/**
	 * The buttons on the Xbox controller
	 */
	public static JoystickButton buttonX, buttonA, buttonB, buttonY,
			leftBumper, leftTrigger, rightBumper, rightTrigger,
			buttonStart, buttonSelect;

	/**
	 * The drive motors of the robot
	 */
	public static Spark leftMotor1, leftMotor2, rightMotor1, rightMotor2;
	
	/**
	 * The motor used to agitate the "fuel cells"
	 */
	public static Spark agitatorMotor;
	
	/**
	 * Initializes the variables
	 */
	public static void init() {
		logitechController = new Joystick(0);

		//TODO initialize logitech buttons
		
		xboxController = new Joystick(1);

		//TODO initialize xbox buttons
		
		leftMotor1 = new Spark(0);
		leftMotor2 = new Spark(1);
		rightMotor1 = new Spark(2);
		rightMotor2 = new Spark(3);
		
		agitatorMotor = new Spark(4);
	}
}