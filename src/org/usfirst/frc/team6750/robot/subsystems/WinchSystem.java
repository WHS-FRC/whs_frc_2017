package org.usfirst.frc.team6750.robot.subsystems;

import org.usfirst.frc.team6750.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Composed of the 4 motors used to drive the robot
 */
public class WinchSystem extends Subsystem {
	public Spark winchMotor;

	public boolean on = false;
	public double speed = 0D;
	public boolean alive = false;

	public WinchSystem() {
		super();

		winchMotor = new Spark(RobotMap.WINCH_MOTOR);
	}

	@Override
	protected void initDefaultCommand() {
	}

	public void update() {
		alive = winchMotor.isAlive();

		if(on) {
			winchMotor.setSpeed(speed);
		} else {
			winchMotor.setSpeed(0D);
		}
	}
}