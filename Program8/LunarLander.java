/*
 * Name: Joseph Godfrey
 * Date: 6/April/2015
 * Course: CSC 212
 * Program: Program Ch8
 * 
 * Description:
 * this is the class that stores, maintains,
 * changes, and applies the values of the 
 * animation from the client program.
 * 
 * 
 */

class LunarLander {

	public static final int SAFE_LANDING = 4; // speed at which lander can land
												// safely
	public static final int INITIAL_ALTITUDE = 1000; // meters

	private static final int INITIAL_VELOCITY = 40; // meters/second
	private static final int INITIAL_FUEL = 25; // thrusts
	private static final int GRAVITY = 2; // gravitational acceleration in
											// meters/second/second
	private static final int THRUST = 4; // thrust acceleration in
											// meters/second/second

	private int currentAltitude;
	private int currentVelocity;
	private int currentFuel;
	private int thrustClicks;

	public LunarLander() {
		this.currentAltitude = INITIAL_ALTITUDE;
		this.currentVelocity = INITIAL_VELOCITY;
		this.currentFuel = INITIAL_FUEL;
		this.thrustClicks = 0;
	}

	// returns the current altitude
	public int getAltitude() {
		return currentAltitude;
	}

	// returns the current velocity
	public int getVelocity() {
		return currentVelocity;
	}

	// returns the current velocity
	public int getFuel() {
		return currentFuel;
	}

	// resets the game to defaults
	public void reset() {
		this.currentAltitude = INITIAL_ALTITUDE;
		this.currentVelocity = INITIAL_VELOCITY;
		this.currentFuel = INITIAL_FUEL;
		this.thrustClicks = 0;
	}

	// updates thrust button clicks and current fuel
	public void thrust() {
		if (currentFuel > 0) {
			thrustClicks++;
			currentFuel--;

		}

	}

	// updates the values the simulation uses when called and applies thrust if
	// called for
	public void tick() {

		currentVelocity = currentVelocity - (THRUST * thrustClicks) + GRAVITY;
		// System.out.print(thrustClicks + "    " + currentFuel);

		currentAltitude = currentAltitude - currentVelocity;
		if (currentAltitude < 0) {
			currentAltitude = 0;
		}

		thrustClicks = 0;

	}

}
