package org.usfirst.frc.team6750.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class RobotMap {
	/**
	 * The Logitech controller
	 */
	public Joystick logitechController;
	
	/**
	 * The buttons on the Logitech controller (by their physical labels)
	 */
	public JoystickButton trigger,
			button2, button3, button4, button5, button6,
			button7, button8, button9, button10, button11, button12;
	
	/**
	 * TODO name axes
	 */
	public AxisType axis;

	/**
	 * The Xbox controller
	 */
	public Joystick xboxController;
	
	/**
	 * The buttons on the Xbox controller
	 */
	public JoystickButton buttonX, buttonA, buttonB, buttonY,
			leftBumper, leftTrigger, rightBumper, rightTrigger,
			buttonStart, buttonSelect;

	/**
	 * The motors of the robot
	 */
	public Talon leftMotor1, leftMotor2, rightMotor1, rightMotor2;

	/**
	 * Initializes the variables
	 */
	public void init() {
		logitechController = new Joystick(0);

		//TODO initialize logitech buttons
		
		xboxController = new Joystick(1);

		//TODO initialize xbox buttons
		
		leftMotor1 = new Talon(0);
		leftMotor2 = new Talon(1);
		rightMotor1 = new Talon(2);
		rightMotor2 = new Talon(3);
	}
}