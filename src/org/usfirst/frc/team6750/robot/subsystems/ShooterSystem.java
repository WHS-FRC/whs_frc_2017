package org.usfirst.frc.team6750.robot.subsystems;

import org.usfirst.frc.team6750.robot.RobotMap;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * TODO Figure out if we're going to have a shooter
 * TODO The motor probably isn't going to be a jaguar
 */
public class ShooterSystem extends Subsystem {
	public Jaguar shooterMotor;

	public ShooterSystem() {
		super();

		shooterMotor = new Jaguar(RobotMap.SHOOTER_MOTOR);
	}

	@Override
	protected void initDefaultCommand() {
	}
}