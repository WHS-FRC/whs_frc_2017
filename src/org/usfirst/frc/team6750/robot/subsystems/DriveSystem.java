package org.usfirst.frc.team6750.robot.subsystems;

import org.usfirst.frc.team6750.robot.RobotMap;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Composed of the 4 motors used to drive the robot
 */
public class DriveSystem extends Subsystem {
	public Jaguar backLeftMotor, frontRightMotor;
	public Spark backRightMotor, frontLeftMotor;

	public DriveSystem() {
		super();

		backLeftMotor = new Jaguar(RobotMap.BACK_LEFT_MOTOR);
		backRightMotor = new Spark(RobotMap.BACK_RIGHT_MOTOR);
		frontLeftMotor = new Spark(RobotMap.FRONT_LEFT_MOTOR);
		frontRightMotor = new Jaguar(RobotMap.FRONT_RIGHT_MOTOR);
		
		//frontRightMotor.setInverted(true);
	}

	@Override
	protected void initDefaultCommand() {
	}
	
	public void adjustJaguars() {
		backRightMotor.setSpeed(backRightMotor.getSpeed() * 1D); //spark
		frontLeftMotor.setSpeed(frontLeftMotor.getSpeed() * 1D); //spark
		
		backLeftMotor.setSpeed(backLeftMotor.getSpeed() * 1D); //jaguar
		frontRightMotor.setSpeed(frontRightMotor.getSpeed() * 1D); //jaguar
	}
}