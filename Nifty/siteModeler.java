import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class siteModeler {
	 //set run variables to public instant variables so work in all methods
	static int STILLRUN, HEADERGO, LAYOUTGO, BACKGROUNDGO, FINISHGO = 0;
	static Font ARIAL = new Font("Arial",1, 24);
	static Font COMIC = new Font("Comic Sans MS",2, 16);
	static int NOFONT, NOCOLOR, NOMEDIA, NOTITLE = 0; //HEADER
	static int NOCOLUMN, NOORGAN, NOPICS, NOFLOW = 0; //HEADER
	static Font HEADERFONT = new Font("Arial",1, 32);
	static Font SMBFONT = new Font("Arial",3, 32);
	static String HEADERCOLOR = "YELLOW"; //header color
	static String HEADERMEDIA = "YES"; //HEADER media buttons
	static String HEADERTITLE = "Your Title Here";//HEADER Title (font messed with later)
	static String LAYOUTCOLUMN = "CENTER";  static String LAYOUTORGAN = "DASHES";
	static String LAYOUTPICS = "IN_LAID";
	static String LAYOUTFLOW = "BLOCKS";
	static int WHERESTHECOLUMN = 0;
	static String BACKGROUNDPIC = "";
	static int BACKCOLOR = 0; static int BACKPICNUM = 0;
	public static void  main(String[] args){
		Scanner console = new Scanner(System.in);
		DrawingPanel panel = new DrawingPanel(1000, 700);
		Graphics g = panel.getGraphics();
		g.drawRect(0,0,1000,590);
		g.drawRect(0,590,1000,15);
		
		
		instructions(g);
		
		startMenu(console, g, panel,  0);
		mainMenuKeyboard(console, g, panel, 0);
		finished(panel, console, g);
		
		g.setColor(Color.GRAY);
		g.fillRect (0, 590, 1000, 110);
		while (true){
			g.setColor(Color.GRAY);
			g.fillRect (0, 590, 1000, 110);
			
		}
		

	}
	public static void instructions(Graphics g){ //tells user inst. in box
		g.drawString("Type 1, 2, 3, etc, followed by 'enter' to choose "
				+ "from options.  Sub-section options will culminate"
				+ " & be drawn when that section is completed."
				+ " 'X'-ed boxes indicate completion.", 0, 602);
	}
	
	public static void startMenu (Scanner console, Graphics g, DrawingPanel panel, int i){
		
		
			drawNumberedRects(0, 1, g);
			g.drawString("Header",70+165*i,660);
		if (HEADERGO == 1){
			g.drawLine(15, 625, 65, 675);
			g.drawLine(65, 625, 15, 675);//box 1 x
		}i++;
			drawNumberedRects(1, 2, g);
			g.drawString("Layout",70+165*i,660);
		if (LAYOUTGO==1){
			g.drawLine(180, 625, 230, 675);
			g.drawLine(230, 625, 180, 675);//box 2 x
		}i++;
			drawNumberedRects(2, 3, g);
			g.drawString("Background",70+165*i,660);
		if (BACKGROUNDGO==1){
			g.drawLine(345, 625, 395, 675);
			g.drawLine(395, 625, 345, 675);//box 3 x
		}i++;
		if (FINISHGO==0){
			drawNumberedRects(3, 4, g);
			g.drawString("Done?",70+165*i,660);
		}
	}
	public static void mainMenuKeyboard(Scanner console, Graphics g, DrawingPanel panel, int i){ 
		g.setColor(Color.WHITE);
		String mainMenuChoice = "";

		int mmcRun = 0;
		do {
		
			mainMenuChoice = keyboardInput(mainMenuChoice, panel, 0, 0);
	
			if (mainMenuChoice.equals("1")){
				g.fillRect (0, 606, 1000, 94);
				headerMenu(console, g,  1, panel, "");
			} else if (mainMenuChoice.equals("2")){
				g.fillRect (0, 606, 1000, 94);
				layoutMenu(console, g, 1, panel, "");
			} else if (mainMenuChoice.equals("3")){
				g.fillRect (0, 606, 1000, 94);
				backgroundMenu(console, g, 1, panel, "");
			} else if (mainMenuChoice.equals("4")){
				finished(panel, console, g);
				g.setColor(Color.GRAY);
				g.fillRect (0, 590, 1000, 110);
			} else{ //choice = choice + 0;
				panel.sleep(2500);
			} mmcRun++;
		}while (mmcRun == 0);
		
		
	}
	
	public static String keyboardInput(String menuChoice, DrawingPanel panel, int i, int j){
		if (STILLRUN!=0){return ""; }
		int keyRun = 0;
		while (keyRun == 0){
			menuChoice = panel.getKeyboardInput();
			panel.sleep(500);
			if ((menuChoice.equals("1")||menuChoice.equals("2")||
				menuChoice.equals("3")||menuChoice.equals("4")||
				menuChoice.equals("5")||menuChoice.equals("6"))&&
				!menuChoice.equals(""+i)&&!menuChoice.equals(""+j)
				){
				keyRun++;
			}	
			
		}
		panel.clearKeyboardInputQueue();
		return menuChoice;
	}

	public static void headerMenu(Scanner console, Graphics g, int i, DrawingPanel panel, String menuChoice){
		i = i-1;

		drawNumberedRects(1, 6, g);
		if (NOFONT == 1){
			g.drawLine(180, 625, 230, 675);
			g.drawLine(230, 625, 180, 675);
		}
		if (NOCOLOR == 1){
			g.drawLine(345, 625, 395, 675);
			g.drawLine(395, 625, 345, 675);
		}
		if (NOMEDIA == 1){
			g.drawLine(510, 625, 560, 675);
			g.drawLine(560, 625, 510, 675);
		}
		if (NOTITLE == 1){
			g.drawLine(725, 625, 675, 675);
			g.drawLine(675, 625, 725, 675);
		}
		
		g.setColor(Color.BLUE);
		
		g.setFont(ARIAL);
		g.drawString("Header",20+166*i,645);
		g.drawString("Options",20+166*i,670);
		
		
		g.setColor(Color.BLACK);
		g.setFont(COMIC);

		i++;
		g.drawString("Font",70+165*i,645);
		g.drawString("Size",70+165*i,670);
		i++;
		g.drawString("Color",70+165*i,665);
		i++;
		g.drawString("Social ",70+165*i,635);
		g.drawString("Media",70+165*i,655);
		g.drawString("Buttons",70+165*i,675);
		i++;
		g.drawString("Title",70+165*i,660);
		i++;
		g.drawString("Main",70+165*i,645);
		g.drawString("Menu",70+165*i,670);
		g.fillRect(0,0,1000,150);
		
		int hcRun = 0;
		
		do{
			String headerChoice = keyboardInput(menuChoice, panel, 1, 0);
			if (headerChoice.equals("2")){
				headerFont(i, menuChoice, panel, console, g);
			} else if(headerChoice.equals("3")){
				headerColor(i, menuChoice, panel, console, g);
			} else if(headerChoice.equals("4")){
				headerMedia(i,  menuChoice, panel,  console, g);
			} else if (headerChoice.equals("5")){
				headerTitle(i,  menuChoice, panel,  console, g);
			} else if (headerChoice.equals("6")){
				HEADERGO=1;
				
			}
			hcRun++;
		}while (hcRun == 0);
		
		//When the header options are done and/or the user goes back to the main 
		//menu from header, the following runs, and draws the culmination of the 
		//chosen header options (or default options if none are chosen).
			if (HEADERGO == 1){//TODO ALSO THIS
		/*		if (HEADERCOLOR.equals("BLUE")){g.setColor(Color.BLUE);}
				else if (HEADERCOLOR.equals("GREEN")){g.setColor(Color.GREEN);}
				else if (HEADERCOLOR.equals("RED")){g.setColor(Color.RED);}
				else if (HEADERCOLOR.equals("PURPLE")){g.setColor(Color.MAGENTA);}
				else{g.setColor(Color.GRAY);}
			g.fillRect(0,0,1000,150);
			g.setFont(HEADERFONT);
			g.setColor(Color.BLACK);
			g.drawString(HEADERTITLE, 10, 145);
			if (HEADERMEDIA.equals("YES")){
				g.setFont(SMBFONT);
				g.setColor(Color.BLUE);
				g.fillRect(950, 20, 30, 30);
				g.setColor(Color.CYAN);
				g.drawString("f", 957, 45);
				g.fillRect(950, 60, 30, 30);
				g.setColor(Color.BLUE);
				g.drawString("t", 957, 85);
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(950, 100, 30, 30);
				g.setColor(Color.ORANGE);
				g.drawString("r", 957, 125);
			}*/
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			startMenu(console, g, panel, 0);
			mainMenuKeyboard(console, g, panel, 0);
		}
	}
	public static void headerFont(int i, String menuChoice,
			DrawingPanel panel, Scanner console, Graphics g){
		i=0;
		g.setColor(Color.WHITE);
		g.fillRect (0, 606, 1000, 94);
		drawNumberedRects(1, 6, g);
		g.setFont(ARIAL);
		g.setColor(Color.BLUE);
		g.drawString("Header",20+166*i,645);
		g.drawString("Font & Size",20+166*i,670);
		g.setColor(Color.BLACK);
		g.setFont(COMIC);

		i++;
		g.drawString("Arial",70+165*i,645);
		g.drawString("72",70+165*i,670);
		i++;
		g.drawString("Arial",70+165*i,645);
		g.drawString("96",70+165*i,670);
		i++;
		g.drawString("Comic Sans",70+165*i,645);
		g.drawString("72",70+165*i,670);
		i++;
		g.drawString("Comic Sans",70+165*i,645);
		g.drawString("96",70+165*i,670);
		i++;
		g.drawString("Back",70+165*i,660);
		
		String fontChoice = keyboardInput(menuChoice, panel, 1, 0);
		if(fontChoice.equals("2")){ 
				
			HEADERFONT = new Font ("Arial", 1, 72);
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			NOFONT = 1;
			headerMenu(console, g, 1, panel, "");
		}else if(fontChoice.equals("3")){ 
			HEADERFONT = new Font ("Arial", 1, 96);
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			NOFONT = 1;
			headerMenu(console, g, 1, panel, "");
		}else if(fontChoice.equals("4")){ 
			HEADERFONT = new Font ("Comic Sans MS", 1, 72);
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			NOFONT = 1;
			headerMenu(console, g, 1, panel, "");
		}else if(fontChoice.equals("5")){ 
			HEADERFONT = new Font ("Comic Sans MS", 1, 96);
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			NOFONT = 1;
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			headerMenu(console, g, 1, panel, "");
		}else if(fontChoice.equals("6")){//back 
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			headerMenu(console, g, 1, panel, "");
		}else{panel.sleep(2500);}
	}
	public static void headerColor(int i, String menuChoice,
			DrawingPanel panel, Scanner console, Graphics g){
		i=0;
		g.setColor(Color.WHITE);
		g.fillRect (0, 606, 1000, 94);
		drawNumberedRects(1, 6, g);
		g.setFont(ARIAL);
		g.setColor(Color.BLUE);
		g.drawString("Header",20+166*i,645);
		g.drawString("Color",20+166*i,670);
		g.setColor(Color.BLACK);
		g.setFont(COMIC);

		i++;
		g.drawString("Blue",70+165*i,660);
		i++;
		g.drawString("Green",70+165*i,660);
		i++;
		g.drawString("Red",70+165*i,660);
		i++;
		g.drawString("Purple",70+165*i,660);
		i++;
		g.drawString("Back",70+165*i,660);
		
		String colorChoice = keyboardInput(menuChoice, panel, 1, 0);
		if(colorChoice.equals("2")){ 
				
			HEADERCOLOR = "BLUE";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			NOCOLOR = 1;
			headerMenu(console, g, 1, panel, "");
		}else if(colorChoice.equals("3")){ 
			HEADERCOLOR = "GREEN";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			NOCOLOR = 1;
			headerMenu(console, g, 1, panel, "");
		}else if(colorChoice.equals("4")){ 
			HEADERCOLOR = "RED";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			NOCOLOR = 1;
			headerMenu(console, g, 1, panel, "");
		}else if(colorChoice.equals("5")){ 
			HEADERCOLOR = "PURPLE";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			NOCOLOR = 1;
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			headerMenu(console, g, 1, panel, "");
		}else if(colorChoice.equals("6")){//back 
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			headerMenu(console, g, 1, panel, "");
		}else{panel.sleep(2500);}
	}
	public static void headerMedia(int i, String menuChoice,
			DrawingPanel panel, Scanner console, Graphics g){
		i=0;
		g.setColor(Color.WHITE);
		g.fillRect (0, 606, 1000, 94);
		drawNumberedRects(1, 4, g);
		g.setFont(ARIAL);
		g.setColor(Color.BLUE);
		g.drawString("Media",20+166*i,645);
		g.drawString("Buttons",20+166*i,670);
		g.setColor(Color.BLACK);
		g.setFont(COMIC);

		i++;
		g.drawString("Yes",70+165*i,660);
		i++;
		g.drawString("No",70+165*i,660);
		i++;
		g.drawString("Back", 70+165*i, 660);
		String smbChoice = keyboardInput(menuChoice, panel, 1, 0);
		if(smbChoice.equals("2")){ 
			HEADERMEDIA = "YES";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			NOMEDIA = 1;
			headerMenu(console, g, 1, panel, "");
		}else if(smbChoice.equals("3")){ 
			HEADERMEDIA = "NO";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			NOMEDIA = 1;
			headerMenu(console, g, 1, panel, "");
		}else if(smbChoice.equals("4")){//back 
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			headerMenu(console, g, 1, panel, "");
		}else{panel.sleep(2500);}
	}
	public static void headerTitle(int i,  String menuChoice,
			DrawingPanel panel, Scanner console, Graphics g){
		i=0;
		g.setColor(Color.WHITE);
		g.fillRect (0, 606, 1000, 94);
		drawNumberedRects(1, 3, g);
		g.setFont(ARIAL);
		g.setColor(Color.BLUE);
		g.drawString("Header",20+166*i,645);
		g.drawString("Title",20+166*i,670);
		g.setColor(Color.BLACK);
		g.setFont(COMIC);

		i++;
		g.drawString("Back", 70+165*i, 660);
		i++;
		g.drawString("Type in",70+165*i,645);
		g.drawString("Title",70+165*i,670);
		
		
		String titleChoice = keyboardInput(menuChoice, panel, 1, 0);
		if(titleChoice.equals("2")){//back 
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			headerMenu(console, g, 1, panel, "");
		}else if(titleChoice.equals("3")){
			HEADERTITLE = userTitle(console, panel, g);
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			NOTITLE = 1;
			headerMenu(console, g, 1, panel, "");
		}else{panel.sleep(2500);}
		
		
		
	}
	public static String userTitle(Scanner console, DrawingPanel panel, Graphics g){
		//currently it only works in the eclipse console
		//user inputs a title and this returns it to be used
		
		int run=1;
		String titleName ="";
		
		
		while (run == 1){
			while(!(titleName.contains("\n"))){
				String addOn = panel.getKeyboardInput();
				if (!addOn.equals("Shift") &&!addOn.equalsIgnoreCase("Caps Lock") ){
					titleName = titleName + addOn;
				}
				g.drawString(titleName, 550, 670);
			}
			g.setColor(Color.BLACK);
			run--;
			
		}
		panel.clearKeyboardInputQueue();
		return titleName;
		//return console.nextLine();
		}
	
	public static void layoutMenu(Scanner console, Graphics g, int i, DrawingPanel panel, String menuChoice){
		i = i-1;

		drawNumberedRects(1, 6, g);
		if (NOCOLUMN == 1){
			g.drawLine(180, 625, 230, 675);
			g.drawLine(230, 625, 180, 675);
		}
		if (NOORGAN == 1){
			g.drawLine(345, 625, 395, 675);
			g.drawLine(395, 625, 345, 675);
		}
		if (NOPICS == 1){
			g.drawLine(510, 625, 560, 675);
			g.drawLine(560, 625, 510, 675);
		}
		if (NOFLOW == 1){
			g.drawLine(725, 625, 675, 675);
			g.drawLine(675, 625, 725, 675);
		}
		
		g.setColor(Color.BLUE);
		
		g.setFont(ARIAL);
		g.drawString("Layout",20+166*i,645);
		g.drawString("Options",20+166*i,670);
		
		
		g.setColor(Color.BLACK);
		g.setFont(COMIC);

		i++;
		g.drawString("Main",70+165*i,645);
		g.drawString("Column",70+165*i,670);
		i++;
		g.drawString("Organization",70+165*i,665);
		i++;
		g.drawString("Pictures",70+165*i,665);
		i++;
		g.drawString("Post",70+165*i,645);
		g.drawString("Flow",70+165*i,670);
		i++;
		g.drawString("Main",70+165*i,645);
		g.drawString("Menu",70+165*i,670);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0,150,1000,439);
		g.setColor(Color.BLACK);
		g.fillRect(175,150,650,439);
		
		
		
		int lcRun = 0;
		
		do{
			String layoutChoice = keyboardInput(menuChoice, panel, 1, 0);
			if (layoutChoice.equals("2")){
				layoutColumn(i, menuChoice, panel, console, g);
			} else if(layoutChoice.equals("3")){
				layoutOrgan(i, menuChoice, panel, console, g);
			} else if(layoutChoice.equals("4")){
				layoutPics(i,  menuChoice, panel,  console, g);
			} else if (layoutChoice.equals("5")){
				layoutFlow(i,  menuChoice, panel,  console, g);
			} else if (layoutChoice.equals("6")){
				LAYOUTGO=1;
				
			}
			lcRun++;
		}while (lcRun == 0);
		
		//When the user goes back to the main menu from layout options,this 
		//runs, and draws the chosen options (or default options if none 
		//are chosen).
			if (LAYOUTGO == 1){
		/*		//TODO THIS
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0,150,1000,439);
				
				if (LAYOUTCOLUMN.equals("LEFT")){g.fillRect(0,150,650,439); WHERESTHECOLUMN = -185;}
				else if (LAYOUTCOLUMN.equals("CENTER")){g.fillRect(87,150,650,439);}
				else if (LAYOUTCOLUMN.equals("RIGHT")){g.fillRect(175,150,650,439);WHERESTHECOLUMN = 185;}
				else {g.fillRect(0,150,650,439);}
				
				if (LAYOUTFLOW.equals("CONNECTED")){
					g.setColor(Color.WHITE);
					g.fillRect(185+WHERESTHECOLUMN,160,630,420);
					g.setColor(Color.BLACK);
					g.fillRect(200+WHERESTHECOLUMN,175,600,390);
					g.setColor(Color.WHITE);
					if (LAYOUTORGAN.equals("BULLETS")){
						g.drawString("•", 205+WHERESTHECOLUMN, 190);
						g.drawString("•", 205+WHERESTHECOLUMN, 390);}
					else if (LAYOUTORGAN.equals("NUMBERS")){
						g.drawString("1", 205+WHERESTHECOLUMN, 190);
						g.drawString("2", 205+WHERESTHECOLUMN, 390);}
					else if (LAYOUTORGAN.equals("DASHES")){
						g.drawString("-", 205+WHERESTHECOLUMN, 190);
						g.drawString("-", 205+WHERESTHECOLUMN, 390);}	
					if (LAYOUTPICS.equals("POST_WIDTH")){
						g.setColor(Color.ORANGE);
						g.drawRect(625+WHERESTHECOLUMN, 175, 175, 195);
						g.drawRect(625+WHERESTHECOLUMN, 370, 175, 195);
						g.drawString("Image", 700+WHERESTHECOLUMN, 275);
						g.drawString("Image", 700+WHERESTHECOLUMN, 475);
					}else if (LAYOUTPICS.equals("IN_LAID")){
						g.setColor(Color.ORANGE);
						g.drawRect(675+WHERESTHECOLUMN, 190, 110, 155);
						g.drawRect(675+WHERESTHECOLUMN, 390, 110, 155);
						g.drawString("Image", 715+WHERESTHECOLUMN, 265);
						g.drawString("Image", 715+WHERESTHECOLUMN, 465);
					}else if (LAYOUTPICS.equals("DUAL_IN_LAID")){
						g.setColor(Color.ORANGE);
						g.drawRect(675+WHERESTHECOLUMN, 190, 110, 155);
						g.drawRect(675+WHERESTHECOLUMN, 390, 110, 155);
						g.drawRect(550+WHERESTHECOLUMN, 190, 110, 155);
						g.drawRect(550+WHERESTHECOLUMN, 390, 110, 155);
						g.drawString("Image", 685+WHERESTHECOLUMN, 265);
						g.drawString("Image", 685+WHERESTHECOLUMN, 465);
						g.drawString("Image", 565+WHERESTHECOLUMN, 265);
						g.drawString("Image", 565+WHERESTHECOLUMN, 465);
					}
				}
				else if (LAYOUTFLOW.equals("BLOCKS")){
					g.setColor(Color.WHITE);
					g.fillRect(185+WHERESTHECOLUMN,160,630,420);
					g.setColor(Color.BLACK);
					g.fillRect(200+WHERESTHECOLUMN,175,600,185);
					//g.fillRect(510,175,290,190);
					g.fillRect(200+WHERESTHECOLUMN,375,600,185);
					g.setColor(Color.WHITE);
					if (LAYOUTORGAN.equals("BULLETS")){
						g.drawString("•", 205+WHERESTHECOLUMN, 190);
						g.drawString("•", 515+WHERESTHECOLUMN, 190);
						g.drawString("•", 205+WHERESTHECOLUMN, 390);}
					else if (LAYOUTORGAN.equals("NUMBERS")){
						g.drawString("1", 205+WHERESTHECOLUMN, 190);
						g.drawString("2", 515+WHERESTHECOLUMN, 190);
						g.drawString("3", 205+WHERESTHECOLUMN, 390);}
					else if (LAYOUTORGAN.equals("DASHES")){
						g.drawString("-", 205+WHERESTHECOLUMN, 190);
						g.drawString("-", 515+WHERESTHECOLUMN, 190);
						g.drawString("-", 205+WHERESTHECOLUMN, 390);}
					if (LAYOUTPICS.equals("POST_WIDTH")){
						g.setColor(Color.ORANGE);
						g.drawRect(625+WHERESTHECOLUMN, 175, 175, 185);
						g.drawRect(625+WHERESTHECOLUMN, 375, 175, 185);
						g.drawString("Image", 700+WHERESTHECOLUMN, 275);
						g.drawString("Image", 700+WHERESTHECOLUMN, 475);
					}else if (LAYOUTPICS.equals("IN_LAID")){
						g.setColor(Color.ORANGE);
						g.drawRect(675+WHERESTHECOLUMN, 190, 110, 155);
						g.drawRect(675+WHERESTHECOLUMN, 390, 110, 155);
						g.drawString("Image", 715+WHERESTHECOLUMN, 265);
						g.drawString("Image", 715+WHERESTHECOLUMN, 465);
					}else if (LAYOUTPICS.equals("DUAL_IN_LAID")){
						g.setColor(Color.ORANGE);
						g.drawRect(675+WHERESTHECOLUMN, 190, 110, 155);
						g.drawRect(675+WHERESTHECOLUMN, 390, 110, 155);
						g.drawRect(550+WHERESTHECOLUMN, 190, 110, 155);
						g.drawRect(550+WHERESTHECOLUMN, 390, 110, 155);
						g.drawString("Image", 685+WHERESTHECOLUMN, 265);
						g.drawString("Image", 685+WHERESTHECOLUMN, 465);
						g.drawString("Image", 565+WHERESTHECOLUMN, 265);
						g.drawString("Image", 565+WHERESTHECOLUMN, 465);
					}
				}
				else if (LAYOUTFLOW.equals("SEP_BLOCKS")){
					g.setColor(Color.WHITE);
					g.fillRect(185+WHERESTHECOLUMN,160,630,420);
					g.setColor(Color.BLACK);
					g.fillRect(200+WHERESTHECOLUMN,175,290,185);
					g.fillRect(510+WHERESTHECOLUMN,175,290,185);
					g.fillRect(200+WHERESTHECOLUMN,375,290,185);
					g.fillRect(510+WHERESTHECOLUMN,375,290,185);
					g.setColor(Color.WHITE);
					if (LAYOUTORGAN.equals("BULLETS")){
						g.drawString("•", 205+WHERESTHECOLUMN, 190);
						g.drawString("•", 515+WHERESTHECOLUMN, 190);
						g.drawString("•", 205+WHERESTHECOLUMN, 390);
						g.drawString("•", 515+WHERESTHECOLUMN, 390);}
					else if (LAYOUTORGAN.equals("NUMBERS")){
						g.drawString("1", 205+WHERESTHECOLUMN, 190);
						g.drawString("2", 515+WHERESTHECOLUMN, 190);
						g.drawString("3", 205+WHERESTHECOLUMN, 390);
						g.drawString("4", 515+WHERESTHECOLUMN, 390);}
					else if (LAYOUTORGAN.equals("DASHES")){
						g.drawString("-", 205+WHERESTHECOLUMN, 190);
						g.drawString("-", 515+WHERESTHECOLUMN, 190);
						g.drawString("-", 205+WHERESTHECOLUMN, 390);
						g.drawString("-", 515+WHERESTHECOLUMN, 390);}	
					if (LAYOUTPICS.equals("POST_WIDTH")){
						g.setColor(Color.ORANGE);
						g.drawRect(625+WHERESTHECOLUMN, 175, 175, 185);
						g.drawRect(625+WHERESTHECOLUMN, 375, 175, 185);
						g.drawString("Image", 700+WHERESTHECOLUMN, 275);
						g.drawString("Image", 700+WHERESTHECOLUMN, 475);
					}else if (LAYOUTPICS.equals("IN_LAID")){
						g.setColor(Color.ORANGE);
						g.drawRect(675+WHERESTHECOLUMN, 190, 110, 155);
						g.drawRect(675+WHERESTHECOLUMN, 390, 110, 155);
						g.drawString("Image", 715+WHERESTHECOLUMN, 265);
						g.drawString("Image", 715+WHERESTHECOLUMN, 465);
					}else if (LAYOUTPICS.equals("DUAL_IN_LAID")){
						g.setColor(Color.ORANGE);
						g.drawRect(675+WHERESTHECOLUMN, 190, 110, 155);
						g.drawRect(675+WHERESTHECOLUMN, 390, 110, 155);
						g.drawRect(550+WHERESTHECOLUMN, 190, 110, 155);
						g.drawRect(550+WHERESTHECOLUMN, 390, 110, 155);
						g.drawString("Image", 685+WHERESTHECOLUMN, 265);
						g.drawString("Image", 685+WHERESTHECOLUMN, 465);
						g.drawString("Image", 565+WHERESTHECOLUMN, 265);
						g.drawString("Image", 565+WHERESTHECOLUMN, 465);
					}		
				}
				else {}
				
		*/		
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			startMenu(console, g, panel, 0);
			mainMenuKeyboard(console, g, panel, 0);
		}
	}
	public static void layoutColumn(int i, String menuChoice, DrawingPanel panel, Scanner console,Graphics g){
		i=0;
		g.setColor(Color.WHITE);
		g.fillRect (0, 606, 1000, 94);
		drawNumberedRects(1, 5, g);
		g.setFont(ARIAL);
		g.setColor(Color.BLUE);
		g.drawString("Column",20+166*i,645);
		g.drawString("Layout",20+166*i,670);
		g.setColor(Color.BLACK);
		g.setFont(COMIC);

		i++;
		g.drawString("Left",70+165*i,645);
		g.drawString("Aligned",70+165*i,670);
		i++;
		g.drawString("Center",70+165*i,645);
		g.drawString("Aligned",70+165*i,670);
		i++;
		g.drawString("Right",70+165*i,645);
		g.drawString("Aligned",70+165*i,670);
		i++;
		g.drawString("Back",70+165*i,660);
		
		String colorChoice = keyboardInput(menuChoice, panel, 1, 0);
		if(colorChoice.equals("2")){ 
				
			LAYOUTCOLUMN = "LEFT";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			NOCOLUMN = 1;
			layoutMenu(console, g, 1, panel, "");
		}else if(colorChoice.equals("3")){ 
			LAYOUTCOLUMN = "CENTER";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			NOCOLUMN = 1;
			layoutMenu(console, g, 1, panel, "");
		}else if(colorChoice.equals("4")){ 
			LAYOUTCOLUMN = "RIGHT";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			NOCOLUMN = 1;
			layoutMenu(console, g, 1, panel, "");
		}else if(colorChoice.equals("5")){//back 
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			layoutMenu(console, g, 1, panel, "");
		}else{panel.sleep(2500);}
	}
	public static void layoutOrgan(int i, String menuChoice, DrawingPanel panel, Scanner console,Graphics g){
		i=0;
		g.setColor(Color.WHITE);
		g.fillRect (0, 606, 1000, 94);
		drawNumberedRects(1, 5, g);
		g.setFont(ARIAL);
		g.setColor(Color.BLUE);
		g.drawString("Layout",20+166*i,645);
		g.drawString("Organization",20+166*i,670);
		g.setColor(Color.BLACK);
		g.setFont(COMIC);

		i++;
		g.drawString("Bullets",70+165*i,660);
		i++;
		g.drawString("Numbers",70+165*i,660);
		i++;
		g.drawString("Dashes",70+165*i,660);
		i++;
		g.drawString("Back",70+165*i,660);
		
		String organChoice = keyboardInput(menuChoice, panel, 1, 0);
		g.setColor(Color.WHITE);
		if(organChoice.equals("2")){ 
				
			LAYOUTORGAN = "BULLETS";
			g.fillRect (0, 606, 1000, 94);
			NOORGAN = 1;
			layoutMenu(console, g, 1, panel, "");
		}else if(organChoice.equals("3")){ 
			LAYOUTORGAN = "NUMBERS";
			g.fillRect (0, 606, 1000, 94);
			NOORGAN = 1;
			layoutMenu(console, g, 1, panel, "");
		}else if(organChoice.equals("4")){ 
			LAYOUTORGAN = "DASHES";
			g.fillRect (0, 606, 1000, 94);
			NOORGAN = 1;
			layoutMenu(console, g, 1, panel, "");
		}else if(organChoice.equals("5")){//back 
			g.fillRect (0, 606, 1000, 94);
			layoutMenu(console, g, 1, panel, "");
		}else{panel.sleep(2500);}
	}
	public static void layoutPics(int i, String menuChoice, DrawingPanel panel, Scanner console,Graphics g){
		i=0;
		g.setColor(Color.WHITE);
		g.fillRect (0, 606, 1000, 94);
		drawNumberedRects(1, 5, g);
		g.setFont(ARIAL);
		g.setColor(Color.BLUE);
		g.drawString("Picture",20+166*i,645);
		g.drawString("Layout",20+166*i,670);
		g.setColor(Color.BLACK);
		g.setFont(COMIC);

		i++;
		g.drawString("Post Width",70+165*i,660);
		i++;
		g.drawString("In-Laid",70+165*i,660);
		i++;
		g.drawString("Dual In-Laid",70+165*i,660);
		i++;
		g.drawString("Back",70+165*i,660);
		
		String picsChoice = keyboardInput(menuChoice, panel, 1, 0);
		g.setColor(Color.WHITE);
		if(picsChoice.equals("2")){ 
				
			LAYOUTPICS = "POST_WIDTH";
			g.fillRect (0, 606, 1000, 94);
			NOPICS = 1;
			layoutMenu(console, g, 1, panel, "");
		}else if(picsChoice.equals("3")){ 
			LAYOUTPICS = "IN_LAID";
			g.fillRect (0, 606, 1000, 94);
			NOPICS = 1;
			layoutMenu(console, g, 1, panel, "");
		}else if(picsChoice.equals("4")){ 
			LAYOUTPICS = "DUAL_IN_LAID";
			g.fillRect (0, 606, 1000, 94);
			NOPICS = 1;
			layoutMenu(console, g, 1, panel, "");
		}else if(picsChoice.equals("5")){//back 
			g.fillRect (0, 606, 1000, 94);
			layoutMenu(console, g, 1, panel, "");
		}else{panel.sleep(2500);}
	}
	public static void layoutFlow(int i, String menuChoice, DrawingPanel panel, Scanner console,Graphics g){
		i=0;
		g.setColor(Color.WHITE);
		g.fillRect (0, 606, 1000, 94);
		drawNumberedRects(1, 5, g);
		g.setFont(ARIAL);
		g.setColor(Color.BLUE);
		g.drawString("Post Flow",20+166*i,645);
		g.drawString("Layout",20+166*i,670);
		g.setColor(Color.BLACK);
		g.setFont(COMIC);

		i++;
		g.drawString("Connected",70+165*i,660);
		i++;
		g.drawString("Blocks",70+165*i,660);
		i++;
		g.drawString("Separated",70+165*i,645);
		g.drawString("Blocks",70+165*i,670);
		i++;
		g.drawString("Back",70+165*i,660);
		
		String flowChoice = keyboardInput(menuChoice, panel, 1, 0);
		g.setColor(Color.WHITE);
		if(flowChoice.equals("2")){ 
				
			LAYOUTFLOW = "CONNECTED";
			g.fillRect (0, 606, 1000, 94);
			NOFLOW = 1;
			layoutMenu(console, g, 1, panel, "");
		}else if(flowChoice.equals("3")){ 
			LAYOUTFLOW = "BLOCKS";
			g.fillRect (0, 606, 1000, 94);
			NOFLOW = 1;
			layoutMenu(console, g, 1, panel, "");
		}else if(flowChoice.equals("4")){ 
			LAYOUTFLOW = "SEP_BLOCKS";
			g.fillRect (0, 606, 1000, 94);
			NOFLOW = 1;
			layoutMenu(console, g, 1, panel, "");
		}else if(flowChoice.equals("5")){//back 
			g.fillRect (0, 606, 1000, 94);
			layoutMenu(console, g, 1, panel, "");
		}else{panel.sleep(2500);}
	}

	public static void backgroundMenu(Scanner console, Graphics g, int i, DrawingPanel panel, String menuChoice){
		i = i-1;

		drawNumberedRects(1, 6, g);
		if (BACKCOLOR > 0 || BACKPICNUM > 0){
			g.drawLine(180, 625, 230, 675);
			g.drawLine(230, 625, 180, 675);//box 2 x
			g.drawLine(345, 625, 395, 675);
			g.drawLine(395, 625, 345, 675);//box 3 x
			g.drawLine(510, 625, 560, 675);
			g.drawLine(560, 625, 510, 675);//box 4 x
			g.drawLine(725, 625, 675, 675);
			g.drawLine(675, 625, 725, 675);//box 5 x		
		}/*
		if (BACKCOLOR > 0){
			//g.setColor(Color.ORANGE);
			if (BACKCOLOR == 1){
				g.setColor(Color.BLUE);
			}else if (BACKCOLOR == 2){
				g.setColor(Color.GREEN);
			}else if (BACKCOLOR == 3){
				g.setColor(Color.RED);
			}else if (BACKCOLOR == 4){
				g.setColor(Color.MAGENTA);
			}
			
			if (WHERESTHECOLUMN==-185){
				g.fillRect(650,150,350,439);
			}else if (WHERESTHECOLUMN==0){
				g.fillRect(0,150,175,439);
				g.fillRect(825,150,175,439);
			}else if (WHERESTHECOLUMN==185){
				g.fillRect(0,150,350,439);}
			else {}	
		}
		
		if(BACKPICNUM >0){
		BufferedImage myImage = ExtraImageSpells.loadImage(BACKGROUNDPIC);
			if (WHERESTHECOLUMN==-185){
				//g.fillRect(650,150,350,439);
				g.drawImage(myImage, 650, 150, 350, 439, null);
			}else if (WHERESTHECOLUMN==0){
				//g.fillRect(0,150,175,439);
				g.drawImage(myImage, 0,150,175,439, null);
				//g.fillRect(825,150,175,439);
				g.drawImage(myImage, 825,150,175,439, null);
			}else if (WHERESTHECOLUMN==185){
				//g.fillRect(0,150,350,439);
				g.drawImage(myImage, 0,150,350,439, null);
			}else {}
		}
		*/
	
		
		
		
		g.setColor(Color.BLUE);
		
		g.setFont(ARIAL);
		g.drawString("Background",20+166*i,645);
		g.drawString("Options",20+166*i,670);
		
		
		g.setColor(Color.BLACK);
		g.setFont(COMIC);

		i++;
		g.drawString("Animals",70+165*i,665);
		i++;
		g.drawString("Colors",70+165*i,665);
		i++;
		g.drawString("Landscapes",70+165*i,665);
		i++;
		g.drawString("Other",70+165*i,665);
		i++;
		g.drawString("Main",70+165*i,645);
		g.drawString("Menu",70+165*i,670);
		if (BACKCOLOR == 0 && BACKPICNUM == 0){
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0,150,1000,439);
		}
		//g.setColor(Color.BLACK);
		//g.fillRect(175,150,650,439);
		
		
		
		int bgcRun = 0;
		
		do{
			String backgroundChoice = keyboardInput(menuChoice, panel, 1, 0);
			if (backgroundChoice.equals("2")){
				backgroundAnimal(i, menuChoice, panel, console, g);
			} else if(backgroundChoice.equals("3")){
				backgroundColor(i, menuChoice, panel, console, g);
			} else if(backgroundChoice.equals("4")){
				backgroundLandscape(i,  menuChoice, panel,  console, g);
			} else if (backgroundChoice.equals("5")){
				backgroundOther(i,  menuChoice, panel,  console, g);
			} else if (backgroundChoice.equals("6")){
				BACKGROUNDGO=1;
				
			}
			bgcRun++;
		}while (bgcRun == 0);
		
		//When the user goes back to the main menu from background options,this 
		//runs, and draws the chosen options (or default options if none 
		//are chosen).
			if (BACKGROUNDGO == 1){
				/*
				//TODO THIS
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(0,150,1000,439);
				*/
				
				
				
								
				
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			startMenu(console, g, panel, 0);
			mainMenuKeyboard(console, g, panel, 0);
			BACKGROUNDGO--;
		}
	}
	public static void backgroundAnimal(int i, String menuChoice,
			DrawingPanel panel, Scanner console, Graphics g){
		i=0;
		g.setColor(Color.WHITE);
		g.fillRect (0, 606, 1000, 94);
		drawNumberedRects(1, 6, g);
		g.setFont(ARIAL);
		g.setColor(Color.BLUE);
		g.drawString("Animal",20+166*i,645);
		g.drawString("Background",20+166*i,670);
		g.setColor(Color.BLACK);
		g.setFont(COMIC);

		i++;
		g.drawString("Owl",70+165*i,660);
		i++;
		g.drawString("Barks",70+165*i,645);
		g.drawString("Internally",70+165*i,670);
		i++;
		g.drawString("Peacock",70+165*i,645);
		g.drawString("Feather",70+165*i,670);
		i++;
		g.drawString("Cat",70+165*i,660);
		i++;
		g.drawString("Back",70+165*i,660);
		
		String animalChoice = keyboardInput(menuChoice, panel, 1, 0);
		if(animalChoice.equals("2")){ 
				
			BACKGROUNDPIC = "Images/1_owl.jpg";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			BACKPICNUM++;
			BACKCOLOR = 0;
			backgroundMenu(console, g, 1, panel, "");
		}else if(animalChoice.equals("3")){ 
			BACKGROUNDPIC = "Images/2_bark_intensifies.jpg";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			BACKPICNUM++;
			BACKCOLOR = 0;
			backgroundMenu(console, g, 1, panel, "");
		}else if(animalChoice.equals("4")){ 
			BACKGROUNDPIC = "Images/3_peacock.jpg";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			BACKPICNUM++;
			BACKCOLOR = 0;
			backgroundMenu(console, g, 1, panel, "");
		}else if(animalChoice.equals("5")){ 
			BACKGROUNDPIC = "Images/4_cat.jpg";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			BACKPICNUM++;
			BACKCOLOR = 0;
			backgroundMenu(console, g, 1, panel, "");
		}else if(animalChoice.equals("6")){//back 
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			backgroundMenu(console, g, 1, panel, "");
		}else{panel.sleep(2500);}
	}		
	public static void backgroundColor(int i, String menuChoice,
			DrawingPanel panel, Scanner console, Graphics g){
		i=0;
		g.setColor(Color.WHITE);
		g.fillRect (0, 606, 1000, 94);
		drawNumberedRects(1, 6, g);
		g.setFont(ARIAL);
		g.setColor(Color.BLUE);
		g.drawString("Solid",20+166*i,645);
		g.drawString("Color",20+166*i,670);
		g.setColor(Color.BLACK);
		g.setFont(COMIC);

		i++;
		g.drawString("Blue",70+165*i,660);
		i++;
		g.drawString("Green",70+165*i,660);
		i++;
		g.drawString("Red",70+165*i,660);
		i++;
		g.drawString("Purple",70+165*i,660);
		i++;
		g.drawString("Back",70+165*i,660);
		
		String colorChoice = keyboardInput(menuChoice, panel, 1, 0);
		if(colorChoice.equals("2")){ 
				
			//BACKGROUNDPIC = "Images/BLUE";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			BACKCOLOR = 1;
			BACKGROUNDPIC = "";
			backgroundMenu(console, g, 1, panel, "");
		}else if(colorChoice.equals("3")){ 
			//BACKGROUNDPIC = "Images/GREEN";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			BACKCOLOR = 2;
			BACKGROUNDPIC = "";
			backgroundMenu(console, g, 1, panel, "");
		}else if(colorChoice.equals("4")){ 
			//BACKGROUNDPIC = "Images/RED";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			BACKCOLOR = 3;
			BACKGROUNDPIC = "";
			backgroundMenu(console, g, 1, panel, "");
		}else if(colorChoice.equals("5")){ 
			//BACKGROUNDPIC = "Images/PURPLE";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			BACKCOLOR = 4;
			BACKGROUNDPIC = "";
			backgroundMenu(console, g, 1, panel, "");
		}else if(colorChoice.equals("6")){//back 
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			backgroundMenu(console, g, 1, panel, "");
		}else{panel.sleep(2500);}
		
	}
	public static void backgroundLandscape(int i, String menuChoice,
			DrawingPanel panel, Scanner console, Graphics g){
		i=0;
		g.setColor(Color.WHITE);
		g.fillRect (0, 606, 1000, 94);
		drawNumberedRects(1, 6, g);
		g.setFont(ARIAL);
		g.setColor(Color.BLUE);
		g.drawString("Landscape",20+166*i,645);
		g.drawString("Backgrounds",20+166*i,670);
		g.setColor(Color.BLACK);
		g.setFont(COMIC);

		i++;
		g.drawString("Bliss (XP)",70+165*i,660);
		i++;
		g.drawString("Apocalypse",70+165*i,645);
		g.drawString("Bridge",70+165*i,670);
		i++;
		g.drawString("Woods",70+165*i,660);
		i++;
		g.drawString("Road to",70+165*i,645);
		g.drawString("the Stars",70+165*i,670);
		i++;
		g.drawString("Back",70+165*i,660);
		
		String landscapeChoice = keyboardInput(menuChoice, panel, 1, 0);
		if(landscapeChoice.equals("2")){ 
				
			BACKGROUNDPIC = "Images/5_xp.jpg";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			BACKPICNUM++;
			BACKCOLOR = 0;
			backgroundMenu(console, g, 1, panel, "");
		}else if(landscapeChoice.equals("3")){ 
			BACKGROUNDPIC = "Images/6_bridge.jpg";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			BACKPICNUM++;
			BACKCOLOR = 0;
			backgroundMenu(console, g, 1, panel, "");
		}else if(landscapeChoice.equals("4")){ 
			BACKGROUNDPIC = "Images/7_woods.jpg";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			BACKPICNUM++;
			BACKCOLOR = 0;
			backgroundMenu(console, g, 1, panel, "");
		}else if(landscapeChoice.equals("5")){ 
			BACKGROUNDPIC = "Images/8_road_to_the_stars.jpg";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			BACKPICNUM++;
			BACKCOLOR = 0;
			backgroundMenu(console, g, 1, panel, "");
		}else if(landscapeChoice.equals("6")){//back 
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			backgroundMenu(console, g, 1, panel, "");
		}else{panel.sleep(2500);}
		
	}
	public static void backgroundOther(int i, String menuChoice,
			DrawingPanel panel, Scanner console, Graphics g){
		i=0;
		g.setColor(Color.WHITE);
		g.fillRect (0, 606, 1000, 94);
		drawNumberedRects(1, 6, g);
		g.setFont(ARIAL);
		g.setColor(Color.BLUE);
		g.drawString("Other",20+166*i,645);
		g.drawString("Backgrounds",20+166*i,670);
		g.setColor(Color.BLACK);
		g.setFont(COMIC);

		i++;
		g.drawString("Planet",70+165*i,645);
		g.drawString("Express",70+165*i,670);
		i++;
		g.drawString("Omnomnomagon",70+165*i,660);
		i++;
		g.drawString("Dogecoin",70+165*i,645);
		g.drawString("Airdrop",70+165*i,670);
		i++;
		g.drawString("You are Being",70+165*i,645);
		g.drawString("Monitored",70+165*i,670);
		i++;
		g.drawString("Back",70+165*i,660);
		
		String landscapeChoice = keyboardInput(menuChoice, panel, 1, 0);
		if(landscapeChoice.equals("2")){ 
				
			BACKGROUNDPIC = "Images/9_planet_express.jpg";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			BACKPICNUM++;
			BACKCOLOR = 0;
			backgroundMenu(console, g, 1, panel, "");
		}else if(landscapeChoice.equals("3")){ 
			BACKGROUNDPIC = "Images/10_omnomnomagon.jpg";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			BACKPICNUM++;
			BACKCOLOR = 0;
			backgroundMenu(console, g, 1, panel, "");
		}else if(landscapeChoice.equals("4")){ 
			BACKGROUNDPIC = "Images/11_dogecoin_airdrop.jpg";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			BACKPICNUM++;
			BACKCOLOR = 0;
			backgroundMenu(console, g, 1, panel, "");
		}else if(landscapeChoice.equals("5")){ 
			BACKGROUNDPIC = "Images/12_you_are_being_monitored.jpg";
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			BACKPICNUM++;
			BACKCOLOR = 0;
			backgroundMenu(console, g, 1, panel, "");
		}else if(landscapeChoice.equals("6")){//back 
			g.setColor(Color.WHITE);
			g.fillRect (0, 606, 1000, 94);
			backgroundMenu(console, g, 1, panel, "");
		}else{panel.sleep(2500);}
	}

	
	public static void drawNumberedRects(int i,int j, Graphics g){

		for (i=i+0; i<j; i++){
			g.setColor(Color.BLACK);
			g.drawRect(150*i+15*(i+1),625,50,50);
			g.setFont(ARIAL);
			g.drawString((""+(i+1)),30+166*i,660);
			g.setFont(COMIC);
		}	
	}	
	
	public static void finished(DrawingPanel panel, Scanner console, Graphics g){
		if (HEADERGO == 1){//TODO ALSO THIS
			if (HEADERCOLOR.equals("BLUE")){g.setColor(Color.BLUE);}
			else if (HEADERCOLOR.equals("GREEN")){g.setColor(Color.GREEN);}
			else if (HEADERCOLOR.equals("RED")){g.setColor(Color.RED);}
			else if (HEADERCOLOR.equals("PURPLE")){g.setColor(Color.MAGENTA);}
			else{g.setColor(Color.GRAY);}
		g.fillRect(0,0,1000,150);
		g.setFont(HEADERFONT);
		g.setColor(Color.BLACK);
		g.drawString(HEADERTITLE, 10, 145);
		if (HEADERMEDIA.equals("YES")){
			g.setFont(SMBFONT);
			g.setColor(Color.BLUE);
			g.fillRect(950, 20, 30, 30);
			g.setColor(Color.CYAN);
			g.drawString("f", 957, 45);
			g.fillRect(950, 60, 30, 30);
			g.setColor(Color.BLUE);
			g.drawString("t", 957, 85);
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(950, 100, 30, 30);
			g.setColor(Color.ORANGE);
			g.drawString("r", 957, 125);
		}
		}
		g.setFont(COMIC);
		if (LAYOUTGO == 1){
			//TODO THIS
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0,150,1000,439);
			
			if (LAYOUTCOLUMN.equals("LEFT")){g.fillRect(0,150,650,439); WHERESTHECOLUMN = -185;}
			else if (LAYOUTCOLUMN.equals("CENTER")){g.fillRect(87,150,650,439);}
			else if (LAYOUTCOLUMN.equals("RIGHT")){g.fillRect(175,150,650,439);WHERESTHECOLUMN = 185;}
			else {}
			
			if (LAYOUTFLOW.equals("CONNECTED")){
				g.setColor(Color.WHITE);
				g.fillRect(185+WHERESTHECOLUMN,160,630,420);
				g.setColor(Color.BLACK);
				g.fillRect(200+WHERESTHECOLUMN,175,600,390);
				g.setColor(Color.WHITE);
				if (LAYOUTORGAN.equals("BULLETS")){
					g.drawString("•", 205+WHERESTHECOLUMN, 190);
					g.drawString("•", 205+WHERESTHECOLUMN, 390);}
				else if (LAYOUTORGAN.equals("NUMBERS")){
					g.drawString("1", 205+WHERESTHECOLUMN, 190);
					g.drawString("2", 205+WHERESTHECOLUMN, 390);}
				else if (LAYOUTORGAN.equals("DASHES")){
					g.drawString("-", 205+WHERESTHECOLUMN, 190);
					g.drawString("-", 205+WHERESTHECOLUMN, 390);}	
				if (LAYOUTPICS.equals("POST_WIDTH")){
					g.setColor(Color.ORANGE);
					g.drawRect(625+WHERESTHECOLUMN, 175, 175, 195);
					g.drawRect(625+WHERESTHECOLUMN, 370, 175, 195);
					g.drawString("Image", 700+WHERESTHECOLUMN, 275);
					g.drawString("Image", 700+WHERESTHECOLUMN, 475);
				}else if (LAYOUTPICS.equals("IN_LAID")){
					g.setColor(Color.ORANGE);
					g.drawRect(675+WHERESTHECOLUMN, 190, 110, 155);
					g.drawRect(675+WHERESTHECOLUMN, 390, 110, 155);
					g.drawString("Image", 715+WHERESTHECOLUMN, 265);
					g.drawString("Image", 715+WHERESTHECOLUMN, 465);
				}else if (LAYOUTPICS.equals("DUAL_IN_LAID")){
					g.setColor(Color.ORANGE);
					g.drawRect(675+WHERESTHECOLUMN, 190, 110, 155);
					g.drawRect(675+WHERESTHECOLUMN, 390, 110, 155);
					g.drawRect(550+WHERESTHECOLUMN, 190, 110, 155);
					g.drawRect(550+WHERESTHECOLUMN, 390, 110, 155);
					g.drawString("Image", 685+WHERESTHECOLUMN, 265);
					g.drawString("Image", 685+WHERESTHECOLUMN, 465);
					g.drawString("Image", 565+WHERESTHECOLUMN, 265);
					g.drawString("Image", 565+WHERESTHECOLUMN, 465);
				}
			}
			else if (LAYOUTFLOW.equals("BLOCKS")){
				g.setColor(Color.WHITE);
				g.fillRect(185+WHERESTHECOLUMN,160,630,420);
				g.setColor(Color.BLACK);
				g.fillRect(200+WHERESTHECOLUMN,175,600,185);
				g.fillRect(200+WHERESTHECOLUMN,375,600,185);
				g.setColor(Color.WHITE);
				if (LAYOUTORGAN.equals("BULLETS")){
					g.drawString("•", 205+WHERESTHECOLUMN, 190);
					g.drawString("•", 515+WHERESTHECOLUMN, 190);
					g.drawString("•", 205+WHERESTHECOLUMN, 390);}
				else if (LAYOUTORGAN.equals("NUMBERS")){
					g.drawString("1", 205+WHERESTHECOLUMN, 190);
					g.drawString("2", 515+WHERESTHECOLUMN, 190);
					g.drawString("3", 205+WHERESTHECOLUMN, 390);}
				else if (LAYOUTORGAN.equals("DASHES")){
					g.drawString("-", 205+WHERESTHECOLUMN, 190);
					g.drawString("-", 515+WHERESTHECOLUMN, 190);
					g.drawString("-", 205+WHERESTHECOLUMN, 390);}
				if (LAYOUTPICS.equals("POST_WIDTH")){
					g.setColor(Color.ORANGE);
					g.drawRect(625+WHERESTHECOLUMN, 175, 175, 185);
					g.drawRect(625+WHERESTHECOLUMN, 375, 175, 185);
					g.drawString("Image", 700+WHERESTHECOLUMN, 275);
					g.drawString("Image", 700+WHERESTHECOLUMN, 475);
				}else if (LAYOUTPICS.equals("IN_LAID")){
					g.setColor(Color.ORANGE);
					g.drawRect(675+WHERESTHECOLUMN, 190, 110, 155);
					g.drawRect(675+WHERESTHECOLUMN, 390, 110, 155);
					g.drawString("Image", 715+WHERESTHECOLUMN, 265);
					g.drawString("Image", 715+WHERESTHECOLUMN, 465);
				}else if (LAYOUTPICS.equals("DUAL_IN_LAID")){
					g.setColor(Color.ORANGE);
					g.drawRect(675+WHERESTHECOLUMN, 190, 110, 155);
					g.drawRect(675+WHERESTHECOLUMN, 390, 110, 155);
					g.drawRect(550+WHERESTHECOLUMN, 190, 110, 155);
					g.drawRect(550+WHERESTHECOLUMN, 390, 110, 155);
					g.drawString("Image", 685+WHERESTHECOLUMN, 265);
					g.drawString("Image", 685+WHERESTHECOLUMN, 465);
					g.drawString("Image", 565+WHERESTHECOLUMN, 265);
					g.drawString("Image", 565+WHERESTHECOLUMN, 465);
				}
			}
			else if (LAYOUTFLOW.equals("SEP_BLOCKS")){
				g.setColor(Color.WHITE);
				g.fillRect(185+WHERESTHECOLUMN,160,630,420);
				g.setColor(Color.BLACK);
				g.fillRect(200+WHERESTHECOLUMN,175,290,185);
				g.fillRect(510+WHERESTHECOLUMN,175,290,185);
				g.fillRect(200+WHERESTHECOLUMN,375,290,185);
				g.fillRect(510+WHERESTHECOLUMN,375,290,185);
				g.setColor(Color.WHITE);
				if (LAYOUTORGAN.equals("BULLETS")){
					g.drawString("•", 205+WHERESTHECOLUMN, 190);
					g.drawString("•", 515+WHERESTHECOLUMN, 190);
					g.drawString("•", 205+WHERESTHECOLUMN, 390);
					g.drawString("•", 515+WHERESTHECOLUMN, 390);}
				else if (LAYOUTORGAN.equals("NUMBERS")){
					g.drawString("1", 205+WHERESTHECOLUMN, 190);
					g.drawString("2", 515+WHERESTHECOLUMN, 190);
					g.drawString("3", 205+WHERESTHECOLUMN, 390);
					g.drawString("4", 515+WHERESTHECOLUMN, 390);}
				else if (LAYOUTORGAN.equals("DASHES")){
					g.drawString("-", 205+WHERESTHECOLUMN, 190);
					g.drawString("-", 515+WHERESTHECOLUMN, 190);
					g.drawString("-", 205+WHERESTHECOLUMN, 390);
					g.drawString("-", 515+WHERESTHECOLUMN, 390);}	
				if (LAYOUTPICS.equals("POST_WIDTH")){
					g.setColor(Color.ORANGE);
					g.drawRect(625+WHERESTHECOLUMN, 175, 175, 185);
					g.drawRect(625+WHERESTHECOLUMN, 375, 175, 185);
					g.drawString("Image", 700+WHERESTHECOLUMN, 275);
					g.drawString("Image", 700+WHERESTHECOLUMN, 475);
				}else if (LAYOUTPICS.equals("IN_LAID")){
					g.setColor(Color.ORANGE);
					g.drawRect(675+WHERESTHECOLUMN, 190, 110, 155);
					g.drawRect(675+WHERESTHECOLUMN, 390, 110, 155);
					g.drawString("Image", 715+WHERESTHECOLUMN, 265);
					g.drawString("Image", 715+WHERESTHECOLUMN, 465);
				}else if (LAYOUTPICS.equals("DUAL_IN_LAID")){
					g.setColor(Color.ORANGE);
					g.drawRect(675+WHERESTHECOLUMN, 190, 110, 155);
					g.drawRect(675+WHERESTHECOLUMN, 390, 110, 155);
					g.drawRect(550+WHERESTHECOLUMN, 190, 110, 155);
					g.drawRect(550+WHERESTHECOLUMN, 390, 110, 155);
					g.drawString("Image", 685+WHERESTHECOLUMN, 265);
					g.drawString("Image", 685+WHERESTHECOLUMN, 465);
					g.drawString("Image", 565+WHERESTHECOLUMN, 265);
					g.drawString("Image", 565+WHERESTHECOLUMN, 465);
				}		
			}
			else {}
		}
		if (BACKCOLOR > 0){
			//g.setColor(Color.ORANGE);
			if (BACKCOLOR == 1){
				g.setColor(Color.BLUE);
			}else if (BACKCOLOR == 2){
				g.setColor(Color.GREEN);
			}else if (BACKCOLOR == 3){
				g.setColor(Color.RED);
			}else if (BACKCOLOR == 4){
				g.setColor(Color.MAGENTA);
			}
			
			if (WHERESTHECOLUMN==-185){
				g.fillRect(650,150,350,439);
			}else if (WHERESTHECOLUMN==0){
				g.fillRect(0,150,175,439);
				g.fillRect(825,150,175,439);
			}else if (WHERESTHECOLUMN==185){
				g.fillRect(0,150,350,439);}
			else {}	
		}
		
		if(BACKPICNUM >0){
		BufferedImage myImage = ExtraImageSpells.loadImage(BACKGROUNDPIC);
			if (WHERESTHECOLUMN==-185){
				g.drawImage(myImage, 650, 150, 350, 439, null);
			}else if (WHERESTHECOLUMN==0){
				g.drawImage(myImage, 0,150,175,439, null);
				g.drawImage(myImage, 825,150,175,439, null);
			}else if (WHERESTHECOLUMN==185){
				g.drawImage(myImage, 0,150,350,439, null);
			}else {}
		}
		FINISHGO++;
		panel.sleep(750);
		g.setColor(Color.GRAY);
		g.fillRect (0, 590, 1000, 110);
		
		
	}
}