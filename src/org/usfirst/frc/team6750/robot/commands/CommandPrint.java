package org.usfirst.frc.team6750.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Use this command to send messages to the console (or the live window) Removes
 * itself immediately after printing the message
 * 
 * @author phank
 *
 */
public class CommandPrint extends Command {
	private String msg;

	/**
	 * Initializes an instance with a message
	 * 
	 * @param msg the message
	 */
	public CommandPrint(String msg) {
		this.msg = msg;
	}

	@Override
	protected void execute() {
		System.out.println(msg);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}