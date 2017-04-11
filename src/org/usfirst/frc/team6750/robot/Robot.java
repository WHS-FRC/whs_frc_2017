package org.usfirst.frc.team6750.robot;

import static org.usfirst.frc.team6750.robot.RobotMap.*;

import org.usfirst.frc.team6750.robot.commands.AutonomousCommandGroup;
import org.usfirst.frc.team6750.robot.commands.CommandSetWinchSpeed;
import org.usfirst.frc.team6750.robot.commands.CommandToggleFront;
import org.usfirst.frc.team6750.robot.commands.CommandToggleWinchMotor;
import org.usfirst.frc.team6750.robot.commands.SingleCommandGroup;
import org.usfirst.frc.team6750.robot.subsystems.DriveSystem;
import org.usfirst.frc.team6750.robot.subsystems.DriveSystem.Side;
import org.usfirst.frc.team6750.robot.subsystems.WinchSystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
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
		driveSystem = new DriveSystem();
		winchSystem = new WinchSystem();

		robotDrive = new RobotDrive(driveSystem.frontLeftMotor, driveSystem.backLeftMotor, driveSystem.frontRightMotor, driveSystem.backRightMotor);

		xboxController = new XboxController(0);

		buttonA = new JoystickButton(xboxController, 1);
		buttonB = new JoystickButton(xboxController, 2);
		buttonX = new JoystickButton(xboxController, 3);
		buttonY = new JoystickButton(xboxController, 4);
		lBumper = new JoystickButton(xboxController, 5);
		rBumper = new JoystickButton(xboxController, 6);
		backButton = new JoystickButton(xboxController, 7);

		buttonA.whenPressed(new SingleCommandGroup(new CommandToggleWinchMotor()));
		buttonX.whenPressed(new SingleCommandGroup(new CommandSetWinchSpeed(1, -0.1D)));
		buttonB.whenPressed(new SingleCommandGroup(new CommandSetWinchSpeed(1, 0.1D)));
		lBumper.whenPressed(new SingleCommandGroup(new CommandSetWinchSpeed(0, -1D)));
		rBumper.whenPressed(new SingleCommandGroup(new CommandSetWinchSpeed(0, 1D)));
		backButton.whenPressed(new SingleCommandGroup(new CommandToggleFront()));
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

			driveSystem.update();
			winchSystem.update();

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
		SmartDashboard.putNumber("Back Left Speed", driveSystem.backLeftMotor.getSpeed());
		SmartDashboard.putNumber("Front Left Speed", driveSystem.frontLeftMotor.getSpeed());
		SmartDashboard.putNumber("Back Right Speed", driveSystem.backRightMotor.getSpeed());
		SmartDashboard.putNumber("Front Right Speed", driveSystem.frontRightMotor.getSpeed());
		SmartDashboard.putNumber("Current Winch Speed", winchSystem.winchMotor.getSpeed());

		SmartDashboard.putString("Winch State", winchSystem.on ? "On" : "Off");
		SmartDashboard.putNumber("Set Winch Speed", winchSystem.speed);

		SmartDashboard.putString("Current Front Side", driveSystem.frontSide == Side.GEARCATCHER ? "Gear Catcher" : "Winch");
	}
}
