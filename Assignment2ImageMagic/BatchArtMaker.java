import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.*;

public class BatchArtMaker {

	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);
		
		
		
		
		System.out.println("First bird image number? (1-15)");
		int firstbird = console.nextInt();
		//String startbird = "images/bird" + firstbird + ".jpg";
		System.out.println("Last bird image number? (2-16)");
		int lastbird = console.nextInt();
		//String endbird = "images/bird" + lastbird + ".jpg";
		System.out.println("Number of shapes? (Ex: 10000)");
		int numDots = console.nextInt();
		System.out.println("Size of shapes? (Ex: 6)");
		int dotSize = console.nextInt();
		System.out.println("Please input the style type wanted. (circle, square, or arc)");
		String style = console.next();
		
		//panel & graphics stuff
		DrawingPanel panel = new DrawingPanel(600, 600);
		Graphics g = panel.getGraphics();
		panel.setBackground(Color.BLACK);
		
		for (int i=firstbird; i<=lastbird; i++) {
			String outBird = "images/bird" + i + ".jpg";
			String outFile = "images/art_bird" + i + ".png";
			ArtMaker.makeArt(panel, outBird, numDots, dotSize, style);
			ExtraImageSpells.saveImage(panel,outFile);
			panel.clear();
			
		}
		
		// fill in code here to convert a whole
		// sequence of birdX.jpg images into 
		// art_birdX.png images
		
	}
}
