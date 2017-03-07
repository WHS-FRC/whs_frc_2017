package org.usfirst.frc.team6750.robot.commands;

import org.usfirst.frc.team6750.robot.Settings;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The command group used during autonomous
 * 
 * Should ONLY be used during AUTONOMOUS
 */
public class AutonomousCommandGroup extends CommandGroup {
	public AutonomousCommandGroup() {
		super("Autonomous Commands");

		switch(Settings.STARTING_POSITION) {
		case MIDDLE: {
			/*
			 * 1) Go forward to middle gear axle
			 * 2) Go backward to deposit gear
			 * 3) Turn Left
			 * 4) Go forward (past the air ship)
			 * 5) Turn right
			 * 6) Go forward (past the base line)
			 */
			break;
		}
		case LEFT:
			/*
			 * 1) Go forward (align with left gear axle)
			 * 2) Turn ~45 degrees to the right (face gear axle)
			 * 3) Go forward to left gear axle
			 * 4) Go backward to deposit gear
			 * 5) Turn ~45 degrees to the left (face base line)
			 * 6) Move forward (past the base line)
			 */
			break;
		case RIGHT:
			/*
			 * 1) Go forward (align with right gear axle)
			 * 2) Turn ~45 degrees to the left (face gear axle)
			 * 3) Go forward to right gear axle
			 * 4) Go backward to deposit gear
			 * 5) Turn ~45 degrees to the right (face base line)
			 * 6) Move forward (past the base line)
			 */
			break;
		}
	}
}