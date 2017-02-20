package org.usfirst.frc.team6750.robot.commands;

import org.usfirst.frc.team6750.robot.Settings;
import org.usfirst.frc.team6750.robot.Settings.Position;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommandGroup extends CommandGroup {
	public AutonomousCommandGroup() {
		super("Autonomous Commands");
		
		if(Settings.STARTING_POSITION == Position.MIDDLE) {
			this.addSequential(new CommandDrive(1D, 0D, 0.523D)); //Rotate 90 degrees to the left
			this.addSequential(new CommandDrive(2D, 0.7D, 0D)); //Drive for 2 seconds (until in same position if started left)
			this.addSequential(new CommandDrive(1D, 0D, -0.523D)); //Rotate 90 degrees to the right
		}
		
		this.addSequential(new CommandDrive(2D, 0.7D, 0D)); //Drive across the base line
		
		if(Settings.STARTING_POSITION == Position.LEFT) {
			this.addSequential(new CommandDrive(1D, 0D, -0.523D)); //Rotate 90 degrees to the right
		} else if (Settings.STARTING_POSITION == Position.RIGHT) { 
			this.addSequential(new CommandDrive(1D, 0D, -0.523D)); //Rotate 90 degrees to the right
		}
	}
}