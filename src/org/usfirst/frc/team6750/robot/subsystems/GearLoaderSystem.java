package org.usfirst.frc.team6750.robot.subsystems;

import org.usfirst.frc.team6750.robot.RobotMap;
import org.usfirst.frc.team6750.robot.Settings;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Composed of the 4 motors used to drive the robot
 */
public class GearLoaderSystem extends Subsystem {
	private boolean on = false;
	public Spark gearKnocker; //AKA the winch motor AKA the double whammy

	public GearLoaderSystem() {
		super();

		gearKnocker = new Spark(RobotMap.GEAR_KNOCKER_MOTOR);

		updateSpeed();
	}

	@Override
	protected void initDefaultCommand() {
	}

	public void updateSpeed() {
		if(!on) {
			gearKnocker.set(0D);
		} else {
			gearKnocker.set(Settings.GEAR_KNOCKER_MOTOR_SPEED);
			
			System.out.println("GEAR KNOCKER SPEED :" + Settings.GEAR_KNOCKER_MOTOR_SPEED);
			System.out.println("SPEED: " + gearKnocker.getSpeed());
		}
	}
	
	public boolean isOn() {
		return on;
	}
	
	public void set(boolean on) {
		this.on = on;
	}
	
	public void toggle() {
		on = on ? false : true;
	}
}