package org.usfirst.frc.team6750.robot;

import static org.usfirst.frc.team6750.robot.RobotMap.*;

import org.usfirst.frc.team6750.robot.commands.AutonomousCommandGroup;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Main robot class
 * 
 * Don't delete
 */
public class Robot extends IterativeRobot {
	@Override
	public void robotInit() {
		robotDrive.setExpiration(0.1D);

		robotDrive.setSafetyEnabled(true);
	}

	@Override
	public void testInit() {
	}

	@Override
	public void testPeriodic() {
		updateScheduler();
	}

	@Override
	public void autonomousInit() {
		new AutonomousCommandGroup().start();
	}

	@Override
	public void autonomousPeriodic() {
		updateScheduler();
	}

	@Override
	public void teleopInit() {
	}

	@Override
	public void teleopPeriodic() {
		while(isOperatorControl() && isEnabled()) {
			updateScheduler();
			updateSettings();

			RobotMap.driveSystem.update();
			RobotMap.winchSystem.update();

			Timer.delay(0.005D);
		}
	}

	/**
	 * Calls the run() method in Scheduler, I guess it's like an update method?
	 */
	private void updateScheduler() {
		Scheduler.getInstance().run();
	}

	/**
	 * Loads data from the dashboard to the Settings
	 * 
	 * Should be called in every init and periodic to ensure up-to-date
	 * information
	 */
	private void updateSettings() {
		SmartDashboard.putNumber("Back Left Motor", RobotMap.driveSystem.backLeftMotor.getSpeed());
		SmartDashboard.putNumber("Front Left Motor", RobotMap.driveSystem.frontLeftMotor.getSpeed());
		SmartDashboard.putNumber("Back Right Motor", RobotMap.driveSystem.backRightMotor.getSpeed());
		SmartDashboard.putNumber("Front Right Motor", RobotMap.driveSystem.frontRightMotor.getSpeed());
		SmartDashboard.putNumber("Winch Motor", RobotMap.winchSystem.winchMotor.getSpeed());
	}
}
