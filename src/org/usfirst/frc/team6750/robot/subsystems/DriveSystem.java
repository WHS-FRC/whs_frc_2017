package org.usfirst.frc.team6750.robot.subsystems;

import org.usfirst.frc.team6750.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem {
	public Spark backLeftMotor, frontLeftMotor, backRightMotor, frontRightMotor;
	
	public DriveSystem() {
		super();
		
		backLeftMotor = new Spark(RobotMap.BACK_LEFT_MOTOR);
		frontLeftMotor = new Spark(RobotMap.FRONT_LEFT_MOTOR);
		backRightMotor = new Spark(RobotMap.BACK_RIGHT_MOTOR);
		frontRightMotor = new Spark(RobotMap.FRONT_RIGHT_MOTOR);
		
		//Motors were attached backwards
		backLeftMotor.setInverted(true);
		frontLeftMotor.setInverted(true);
		backRightMotor.setInverted(true);
		frontRightMotor.setInverted(true);
	}
	
	@Override
	protected void initDefaultCommand() {
	}
}