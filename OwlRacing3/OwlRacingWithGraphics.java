/**
 * This program simulates owls racing!
 *  
 * @author Joe Godfrey
 * @date 17/Jan/2015
 * 
 * Does this program meet all the assignment specifications? Y/N
 * If NOT, then list all known caveats of your program: 
 *
 * Follow-up: if you had more time to work on this program, what would you do?
 * 
 * If working in a pair, briefly explain EACH author's contribution to the project:
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
 *   
 *   
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.*;


public class OwlRacingWithGraphics {

	public static void main(String[] args) {
		
		//Scanner console = new Scanner(System.in);
		
		DrawingPanel panel = new DrawingPanel(1200, 800);
		Graphics g = panel.getGraphics();
		panel.setBackground(Color.BLACK);
		g.setColor(Color.YELLOW);
		while (panel.checkMouseClicked() == false){
		g.drawString("Click To Begin!", panel.getMouseX(), panel.getMouseY());
		panel.sleep(500);
		}
		
		int owl1dist = 0;
		int owl2dist = 0;
		int owl3dist = 0;
		
		int l = 0;
		int m = 0;
		int n = 0;		
		
		while (owl1dist<80 && owl2dist<80 && owl3dist<80){
		for(int i=0; i<240; i++) {	
			
			
			
			int heightAdd = 3*(1-(int)(3*Math.random()));
			
			int f = (int)(3*Math.random());
			if (f==1) {
				l = l + 1;			
			}else if (f==0) {
				m = m + 1;						
			}else{
				n = n + 1;					
			}

			
			for(int j=0; j<=l; j++ ) {
				owl1dist=l;
				owlHedwig(panel, 10*owl1dist, 100+heightAdd, "WHITE", "Hedwig");
			}
			
			for(int k=0; k<=m; k++ ) {
				owl2dist=m;
				owlHedwig(panel, 10*owl2dist, 350+heightAdd, "BROWN", "Screecher");
			}
			
			for(int r=0; r<=n; r++ ) {
				owl3dist=n;
				owlHedwig(panel, 10*owl3dist, 600+heightAdd, "MAROON", "Hooter");
			}
			panel.sleep(30);
			if(i<239){ //if i is divisible by 10, it clears the panel, 
				if(!(i%10==0)){ //otherwise it just black boxes it
			
			g.setColor(Color.BLACK);
			g.fillRect(10*l-50, 55, 200, 150);
			g.fillRect(10*m-50, 305, 200, 150);
			g.fillRect(10*n-50, 555, 200, 150);
				
				}else{
					panel.clear();
				}
				
			}
			
			
		}
		}
		
		
		int winner = Math.max(Math.max(owl1dist, owl2dist), owl3dist);
		
		if(owl1dist>owl2dist && owl1dist>owl3dist){
			String owlwins = "We Have A Winner!";
			g.drawString(owlwins, 10*winner-100, 200);
		}else if(owl2dist>owl1dist && owl2dist>owl3dist){
			String owlwins = "We Have A Winner!";
			g.drawString(owlwins, 10*winner-100, 450);
		}else{
			String owlwins = "We Have A Winner!";
			g.drawString(owlwins, 10*winner-100, 700);
		}
		
	}

	
	public static void owlHedwig(DrawingPanel panel, int x, int y, String owlColor, String name) {
		Graphics g = panel.getGraphics();
		
		g.setColor(new Color(127, 84, 23));
		int xPoints1[] = {x+80, x+40, x+40};
		int yPoints1[] = {y+5, y+5, y-40};
		g.fillPolygon(xPoints1, yPoints1, 3);
		int xPoints2[] = {x+80, x+40, x+40};
		int yPoints2[] = {y+45, y+45, y+90};
		g.fillPolygon(xPoints2, yPoints2, 3);
		g.fillRect(x-10, y+10, 20, 10);
		g.fillRect(x-10, y+30, 20, 10);
		int xPoints3[] = {x-10, x-10, x-25};
		int yPoints3[] = {y+5, y+25, y+15};
		g.fillPolygon(xPoints3, yPoints3, 3);
		int xPoints4[] = {x-10, x-10, x-25};
		int yPoints4[] = {y+25, y+45, y+35};
		g.fillPolygon(xPoints4, yPoints4, 3);
		if (owlColor == "WHITE"){
			g.setColor(Color.WHITE);
		}else if (owlColor=="BROWN") {
			g.setColor(new Color(48, 31, 13));
		}else{
			g.setColor(new Color(127, 23, 31));
		}
		
		g.fillOval(x, y, 100, 50);
		g.fillOval(x+85, y+8, 35, 35);
		g.setColor(Color.BLUE);
		g.fillOval(x+110, y+15, 5, 5);
		g.fillOval(x+110, y+30, 5, 5);
		g.setColor(Color.ORANGE);
		int xBeak[] = {x+118, x+118, x+133};
		int yBeak[] = {y+18, y+33, y+25};
		g.fillPolygon(xBeak, yBeak, 3);
		
		g.drawString(name, x-25, y+75);
		
		
		

	}
	





}


