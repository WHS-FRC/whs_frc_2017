package org.usfirst.frc.team6750.robot;

/**
 * A "reference" class to provide access to commonly used variables
 */
public class Settings {
	/**
	 * The axes input from the slow joystick are multiplied by this to get the speed sent to the RobotDrive
	 */
	public static final double SLOW_MOVE_MODIFIER = 0.65D;

	/**
	 * The speed value for the gear knocker winch motor double whammy thing
	 */
	public static double GEAR_KNOCKER_MOTOR_SPEED = 0.5D;

	/**
	 * Defines what position the robot is starting in
	 * 
	 * Can be changed in the dashboard and should always be defined before anything else
	 */
	public static Position STARTING_POSITION = Position.RIGHT;

	public static double FORWARD_LIMIT = 0.5D, BACKWARD_LIMIT = 0.5D, ROTATE_LIMIT = 0.5D;
	
	/**
	 * Used to determine where the robot starts on the field
	 */
	public enum Position {
		LEFT("Left"), MIDDLE("Middle"), RIGHT("Right");

		private final String name;

		Position(String name) {
			this.name = name;
		}

		/**
		 * Returns the localized name of the position
		 * 
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * Converts the name given to the position
		 * 
		 * @param name name of position
		 * @return the position
		 */
		public static Position getPosition(String name) {
			return name == "Left" ? LEFT : (name == "Middle" ? MIDDLE : RIGHT);
		}
	}
}