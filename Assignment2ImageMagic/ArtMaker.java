/**
 * This program transforms images into simulated-Pointillist artwork!
 * 
 * Fill in all of the following information before submitting.
 * 
 * @author Your Name Here
 * @date Today's Date
 * 
 * Does this program meet all the assignment specifications? Y/N
 * If NOT, then list what WORKS and what DOESN'T (known caveats) here: 
 *
 *
 * 
 * 
 * I was assisted by:  (list persons/sources if applicable) 
 *  (Explain the contribution)
 *   
 * I gave assistance to: (list classmates if applicable)
 *  (Explain how you assisted)
 *   
 * Brief reflection on what you learned from this programming assignment
 *  and whether or not you enjoyed it:
 */

// Note: I'm helpfully including these imports you'll presumably need.
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.*;

public class ArtMaker {

	public static void main(String[] args) {
		// Eventually CHANGE the code below so that the user can enter
		// values for these variables from the console
		
		
		Scanner console = new Scanner(System.in);
		
		System.out.println("Please give the filename. (Ex: bird1.jpg)");
		String fileName = console.next();
		System.out.println("Please give the number of shapes you want. (Ex: 10000)");
		int numDots = console.nextInt();
		System.out.println("Please give the maximum shape size wanted. (Ex: 6)");
		int maxDotSize = console.nextInt();
		System.out.println("Please input the style type wanted. (circle, square, or arc)");
		String style = console.next();
		
		// We modify the filename String to look for the file inside 
		// of the images subfolder, instead of the main project folder.
		fileName = "images/" + fileName; 

		// Next, call the method that does the "real" work of this program
		// and pass in appropriate parameters
		DrawingPanel panel = new DrawingPanel(600, 600);
		Graphics g = panel.getGraphics();
		panel.setBackground(Color.BLACK);
		//makeArt(...);
		makeArt(panel, fileName, numDots, maxDotSize, style);

	}
	
	public static void makeArt(DrawingPanel panel, String inputFileName, 
								int numDots, int maxDotSize, String style) {
		
		Graphics g = panel.getGraphics();
		
		BufferedImage myImage = ExtraImageSpells.loadImage(inputFileName);
		
		//for loop with i++ to max of numDots
		
		for(int i=0; i < numDots; i++){
		
			int imgWidth = myImage.getWidth();
			int imgHeight = myImage.getHeight();
			
			int RandPixelx = (int)(imgWidth* Math.random() - 1);
			int RandPixely = (int)(imgHeight* Math.random() - 1);
		
			Color pixelColor = new Color(myImage.getRGB(RandPixelx, RandPixely));
		
			//generate coords of ^ onto this drawpanel then scale it
			int newPixelx = (int)((RandPixelx / (double)imgWidth) * 600); 
			int newPixely = (int)((RandPixely / (double)imgHeight) * 600);
		
			int randCircRad = (int)(Math.random()*maxDotSize);
			g.setColor(pixelColor);
			
			//style
			if (style.equals("square")) {
				g.fillRect(newPixelx, newPixely, randCircRad, randCircRad);
				} else if (style.equals("arc")) {
				g.fillArc(newPixelx, newPixely, randCircRad*2, randCircRad*2, 45, 90);
				} else {
				g.fillOval(newPixelx, newPixely, randCircRad, randCircRad);
				}
		
			
		
		}
		/*
			if (style = "square") {
			g.fillRect(newPixelx, newPixely, randCircRad, randCircRad);
			} else if (style = "arc") {
			g.fillArc(newPixelx, newPixely, randCircRad, randCircRad, 45, 90);
			} else {
			g.fillOval(newPixelx, newPixely, randCircRad, randCircRad);
			} 
			
			
			
		 */
	}
	

}
