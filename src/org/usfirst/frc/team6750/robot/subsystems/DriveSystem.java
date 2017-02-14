package org.usfirst.frc.team6750.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem {
	/**
	 * 4 = front left
	 * 3 = back left
	 * 1 = front right
	 * 2 = back right
	 */
	public Spark backLeftMotor, frontLeftMotor, backRightMotor, frontRightMotor;
	
	public DriveSystem() {
		super();
		
		backLeftMotor = new Spark(3);
		frontLeftMotor = new Spark(4);
		backRightMotor = new Spark(2);
		frontRightMotor = new Spark(0);
		
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