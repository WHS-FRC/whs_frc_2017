package org.usfirst.frc.team6750.robot.commands;

import org.usfirst.frc.team6750.robot.Settings;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The command group used during autonomous
 * 
 * Should ONLY be used during AUTONOMOUS
 */
public class AutonomousCommandGroup extends CommandGroup {
	public static double[] durations = new double[8], speeds = new double[8], rotations = new double[8];

	public AutonomousCommandGroup() {
		super("Autonomous Commands"); // 15 SECONDS!!
		
		addSequential(new CommandDrive(5D, 0.6D, 0D)); //TEMP

		switch (Settings.STARTING_POSITION) {
		case MIDDLE: {
			for (int i = 0; i < durations.length; i++) {
				//addSequential(new CommandDrive(durations[i], speeds[i], rotations[i]));
			}
			/*
			 * 1) Go forward to middle gear axle 2) Go backward to deposit gear
			 * 3) Turn Left 4) Go forward (past the air ship) 5) Turn right 6)
			 * Go forward (past the base line)
			 */
			break;
		}
		case LEFT:
			for (int i = 0; i < durations.length; i++) {
				//addSequential(new CommandDrive(durations[i], speeds[i], rotations[i]));
			}
			/*
			 * 1) Go forward 2) Turn ~60 degrees to the right (face gear axle)
			 * 3) Go forward to left gear axle 4) Go backward to deposit gear
			 */
			break;
		case RIGHT:
			for (int i = 0; i < durations.length; i++) {
				//addSequential(new CommandDrive(durations[i], speeds[i], rotations[i]));
			}
			/*
			 * 1) Go forward (align with right gear axle) 2) Turn ~60 degrees to
			 * the left (face gear axle) 3) Go forward to right gear axle 4) Go
			 * backward to deposit gear
			 */
			break;
		}
	}
}