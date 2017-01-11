package org.usfirst.frc.team6750.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		if (Reference.TEST_MODE) { //Checks if the program is being run in test mode
			LiveWindow.run(); //Opens the live window (has the console and customizable information)
			
			print("Starting in test mode");
		}
		
		print("Initializing robot");
	}

	/**
	 * This function is run when the autonomous period is started
	 */
	@Override
	public void autonomousInit() {
		print("Initializing autonomous");
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}

	/**
	 * This function is used to send messages to the console
	 * 
	 * @param text
	 *            the message
	 */
	public static void print(String text) {
		System.out.println(text);
	}
}
