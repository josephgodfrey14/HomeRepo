/*
 * The client code to test the Flyable interface
 * and associated concrete classes.
 */

import java.awt.*; 

public class Aviary {
	public static final int SIZE = 20;
	public static final int SIZE_IN_PIXELS = 10;
	public static final int WINDOW_SIZE = SIZE * SIZE_IN_PIXELS;
	public static final int ITERATIONS = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// create a drawing panel
		DrawingPanel panel = new DrawingPanel(WINDOW_SIZE, WINDOW_SIZE);
		Graphics g = panel.getGraphics();

		// create several flying creatures 
		Flyable[] flyers = {new Cardinal(7, 4), new Cardinal(3, 8),
				new Bluebird(4, 15), new Bluebird(8, 1), 
				new Vulture(3, 2), new Vulture(18, 14),
				new Mosquito(2, 9), new Mosquito(16, 11)
				};

		for (int i = 0; i < ITERATIONS; i++) {
			// clear screen
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, WINDOW_SIZE, WINDOW_SIZE);
			// tell each creature to fly, and redraw the creature
			for (Flyable flyer : flyers) {
				flyer.fly();
				g.setColor(flyer.getColor());
				Point pos = flyer.getPosition();
				g.fillOval(pos.getX() * SIZE_IN_PIXELS,
						pos.getY() * SIZE_IN_PIXELS, SIZE_IN_PIXELS, SIZE_IN_PIXELS);
			}
			panel.sleep(500);
		}
	}
}
