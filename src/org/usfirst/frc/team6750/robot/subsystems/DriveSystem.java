package org.usfirst.frc.team6750.robot.subsystems;

import org.usfirst.frc.team6750.robot.RobotMap;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem {
	public Spark backLeftMotor, backRightMotor;
	public Jaguar frontLeftMotor, frontRightMotor;

	public DriveSystem() {
		super();

		backLeftMotor = new Spark(RobotMap.BACK_LEFT_MOTOR);
		backRightMotor = new Spark(RobotMap.BACK_RIGHT_MOTOR);
		frontLeftMotor = new Jaguar(RobotMap.FRONT_LEFT_MOTOR);
		frontRightMotor = new Jaguar(RobotMap.FRONT_RIGHT_MOTOR);
	}

	@Override
	protected void initDefaultCommand() {
	}
}