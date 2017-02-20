package org.usfirst.frc.team6750.robot;

public class Settings {
	/**
	 * The axes input from the slow joystick are multiplied by this to get the speed sent to the RobotDrive
	 */
	public static final double SLOW_MOVE_MODIFIER = 0.65D;

	public static Position STARTING_POSITION = Position.LEFT;

	public enum Position {
		LEFT("Left"), MIDDLE("Middle"), RIGHT("Right");

		private final String name;

		Position(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
		
		public static Position getPosition(String name) {
			return name == "Left" ? LEFT : (name == "Middle" ? MIDDLE : RIGHT);
		}
	}
}