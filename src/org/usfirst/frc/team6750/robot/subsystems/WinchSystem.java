package org.usfirst.frc.team6750.robot.subsystems;

import org.usfirst.frc.team6750.robot.RobotMap;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Composed of the 4 motors used to drive the robot
 */
public class WinchSystem extends Subsystem {
	public Jaguar winchMotor;

	public WinchSystem() {
		super();

		winchMotor = new Jaguar(RobotMap.WINCH_MOTOR);
	}

	@Override
	protected void initDefaultCommand() {
	}
}