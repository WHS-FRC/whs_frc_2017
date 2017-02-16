package org.usfirst.frc.team6750.robot;

import org.usfirst.frc.team6750.robot.subsystems.DriveSystem;
import org.usfirst.frc.team6750.robot.subsystems.ShooterSystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

public class RobotMap {
	public static final int BACK_LEFT_MOTOR = 3, FRONT_LEFT_MOTOR = 4, BACK_RIGHT_MOTOR = 2, FRONT_RIGHT_MOTOR = 0;
	public static final int SHOOTER_MOTOR = 5;
	
	public static DriveSystem driveSystem = new DriveSystem();
	
	public static ShooterSystem shooterSystem = new ShooterSystem();

	public static RobotDrive robotDrive = new RobotDrive(driveSystem.backLeftMotor, driveSystem.frontLeftMotor, driveSystem.backRightMotor, driveSystem.frontRightMotor);

	public static Joystick xboxController = new Joystick(0);
	public static Joystick LGController = new Joystick(1);
}