package org.usfirst.frc.team6750.robot.subsystems;

import org.usfirst.frc.team6750.robot.RobotMap;
import org.usfirst.frc.team6750.robot.Settings;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Composed of the 4 motors used to drive the robot
 */
public class WinchSystem extends Subsystem {
	private boolean on = false, reverse = false;
	public Spark leftMotor, rightMotor; // AKA the winch motor AKA the double
										// whammy

	public WinchSystem() {
		super();

		leftMotor = new Spark(RobotMap.WINCH_LEFT_MOTOR);
		rightMotor = new Spark(RobotMap.WINCH_RIGHT_MOTOR);

		updateSpeed();
	}

	@Override
	protected void initDefaultCommand() {
	}

	public void updateSpeed() {
		if (!on) {
			leftMotor.setSpeed(0D);
			rightMotor.setSpeed(0D);
		} else {
			double speed = RobotMap.lgController.getRawAxis(3);
			speed *= (-1D);
			speed += 1D;
			speed *= (0.5D);

			if (reverse) {
				speed *= (-1D);
			}

			leftMotor.setSpeed(-speed);
			rightMotor.setSpeed(speed);
		}
	}

	public boolean isOn() {
		return on;
	}

	public void set(boolean on) {
		this.on = on;
	}

	public void toggle() {
		on = on ? false : true;
	}

	public void reverse() {
		reverse = reverse ? false : true;
	}
}