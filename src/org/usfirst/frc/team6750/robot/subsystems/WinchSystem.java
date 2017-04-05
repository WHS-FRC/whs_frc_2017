package org.usfirst.frc.team6750.robot.subsystems;

import static org.usfirst.frc.team6750.robot.RobotMap.*;

import org.usfirst.frc.team6750.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Composed of the 4 motors used to drive the robot
 */
public class WinchSystem extends Subsystem {
	public Spark winchMotor;

	public boolean on = false;
	public double speed = 0D;

	public WinchSystem() {
		super();

		winchMotor = new Spark(RobotMap.WINCH_MOTOR);
	}

	@Override
	protected void initDefaultCommand() {
	}

	public void update() {
		if(xboxController.getXButton()) {
			speed = -1D;
		}

		if(xboxController.getBButton()) {
			speed = 1D;
		}

		if(xboxController.getAButton()) {
			on = false;
		} else if(xboxController.getYButton()) {
			on = true;
		}

		if(on) {
			winchMotor.setSpeed(speed);
		}
	}
}