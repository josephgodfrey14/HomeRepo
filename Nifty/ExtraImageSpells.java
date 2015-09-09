import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/** This class provides a simple static method to allow you to 
 * load an image (BufferedImage) object from a file. 
 * 
 * You should NOT modify this class at all for your project.
 *  
 * @author Dr. Stonedahl
 *
 */
public class ExtraImageSpells {

	/**
	 * Loads an image file from disk and returns the image object. 
	 * @param filename - the path/name to load the file from.
	 * @return a BufferedImage image object.
	 */
	public static BufferedImage loadImage(String filename) {
		File inputFile = new File(filename);
		try {
			BufferedImage img = ImageIO.read(inputFile);
			return img;
		}
		catch (IOException ex) {
			System.err.println("ERROR loading image named: " + filename);
			System.err.println("Full path: " + inputFile.getAbsolutePath());			
			System.err.println("Error message: " + ex);
			System.out.println("Program exiting...");
			System.exit(1);
		}
		return null; // never happens, because if there was an error, the program quits.		
	}
	

	/**
	 * Takes whatever image is visible in the given DrawingPanel
	 * and saves it to disk using the specified filename.
	 * 
	 * @param panel - the window that is displaying the panel 
	 * @param filename
	 */
	public static void saveImage(DrawingPanel panel, String filename) {
		try {
			panel.save(filename);
		} 
		catch (IOException ex) {
			System.err.println("ERROR saving image named: " + filename);		
			System.err.println("Error message: " + ex);
			System.out.println("Program exiting...");
			System.exit(1);			
		}
	}

}
