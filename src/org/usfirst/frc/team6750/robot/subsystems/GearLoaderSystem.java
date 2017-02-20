package org.usfirst.frc.team6750.robot.subsystems;

import org.usfirst.frc.team6750.robot.RobotMap;
import org.usfirst.frc.team6750.robot.commands.CommandKnockGears;
import org.usfirst.frc.team6750.robot.commands.SingleCommandGroup;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Composed of the 4 motors used to drive the robot
 */
public class GearLoaderSystem extends Subsystem {
	public Spark gearKnocker; //AKA the winch motor AKA the double whammy

	public GearLoaderSystem() {
		super();

		gearKnocker = new Spark(RobotMap.GEAR_KNOCKER_MOTOR);
	}

	@Override
	protected void initDefaultCommand() {
		new SingleCommandGroup(new CommandKnockGears());
	}
}