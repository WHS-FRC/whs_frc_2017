package org.usfirst.frc.team6750.robot.subsystems;

import org.usfirst.frc.team6750.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DumperSystem extends Subsystem {
	public Spark dumperMotor;

	public DumperSystem() {
		super();

		dumperMotor = new Spark(RobotMap.DUMPER_MOTOR);
	}

	@Override
	protected void initDefaultCommand() {
	}
}