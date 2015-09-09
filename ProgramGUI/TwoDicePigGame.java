/*
 * Name: Joseph Godfrey
 * Date: 28/APR/2015
 * Course: CSC212
 * Program: ProgramGUI
 * 
 * Description:  Should play two dice pig in which the player duels a computer
 * but i couldn't figure out how to use the other classes or the timer so it's
 * super buggy.
 * 
 *
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.Timer;

public class TwoDicePigGame implements ActionListener {

	// main method

	// Score to win the game
	public static final int GOAL_SCORE = 100;

	// constants
	private final int FRAME_HEIGHT = 325;
	private final int FRAME_WIDTH = 250;
	private final int FRAME_LOCATION_X = 100;
	private final int FRAME_LOCATION_Y = 100;
	private final ImageIcon[] DIE_IMAGES = { null,
			new ImageIcon("Images/die1.jpg"), new ImageIcon("Images/die2.jpg"),
			new ImageIcon("Images/die3.jpg"), new ImageIcon("Images/die4.jpg"),
			new ImageIcon("Images/die5.jpg"), new ImageIcon("Images/die6.jpg") };
	private final ImageIcon HOLD_IMAGE = new ImageIcon("Images/hold.jpg");
	private final ImageIcon ROLL_IMAGE = new ImageIcon("Images/roll.jpg");

	private final int DELAY = 1000;

	// data fields
	private JLabel title;//"Two Dice Pig" 32pt font bold & italic in serif
	private String name;//human's name
	private JLabel playerScoreLabel;//human's score
	private JLabel compyScoreLabel;//computer's score
	private JLabel currentPlayer;//label for current player (human/compy)
	private JLabel turnTotalLabel;//label for the turn point count
	private JButton roll;//roll button
	private JButton hold;//hold button
	private JLabel leftImage;//left die
	private JLabel rightImage;//right die
	private int playerScore;//human's score
	private int compyScore;//computer's score
	private int turnTotal;//accumulated points for the turn
	private boolean playerTurn;//true/false for message dialog whose turn it is
	private boolean win;
	private HumanPlayer you;
	private ComputerPlayer bigBro;
	private Timer timer;
	
	
	// constructor
	public TwoDicePigGame(){
		playerTurn=true;
		name = JOptionPane.showInputDialog("Welcome to Two Dice Pig!\nEnter your name:");
		//System.out.println(name);
		if (name==null||name.equals("")){
			name="Trogdor the Burninator";
		}
		//HumanPlayer you = new HumanPlayer(name);
		//ComputerPlayer bigBro = new ComputerPlayer();
		//bigBro.playerScore=compyScore;
		//bigBro.turnTotal=turnTotal;
				
		JFrame frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		frame.setTitle("Pig Game");
		frame.setLayout(new BorderLayout());
		

		playerScore = 0;
		compyScore=0;
		turnTotal=0;
		
		JPanel header = new JPanel(new BorderLayout());
		header.add(title(), BorderLayout.NORTH);
		header.add(scoreLabels(), BorderLayout.CENTER);
		frame.add(header, BorderLayout.NORTH);
		
		JPanel images = new JPanel();
		images.setLayout(new GridLayout(1, 2));
		leftImage = new JLabel("", ROLL_IMAGE, JLabel.CENTER);
		rightImage = new JLabel("", ROLL_IMAGE, JLabel.CENTER);
		images.add(leftImage);
		images.add(rightImage);
		images.setBackground(Color.BLACK);
		
		frame.add(images, BorderLayout.CENTER);
		frame.add(holdRoll(), BorderLayout.SOUTH);
		
		
		frame.setVisible(true);
		JOptionPane.showMessageDialog(null, "See if you can get to 100 before I do.\n\n"
				+ "Roll until you hold or roll a 1.\nIf you roll a 1 before you hold,\n"
				+ "you lose the points for that turn.\nIf you roll a snake eyes before "
				+ "you hold,\nyou lose all of your points.\n\nYou can roll first.");
		
		
		roll.addActionListener(this);
		hold.addActionListener(this);
		
		timer = new Timer(DELAY, this);
		
		
		
	}

	public static void main(String[] args) {//launches the GUI
		TwoDicePigGame GUI = new TwoDicePigGame();//launch this class
	}
	
	public JPanel scoreLabels(){//returns a label with the scores
		
		JPanel scoreLabels = new JPanel(new GridLayout(0,1, 0, 10));
		playerScoreLabel=new JLabel(name + "'s Score:  "+playerScore);
		playerScoreLabel.setHorizontalAlignment(JLabel.CENTER);
		compyScoreLabel=new JLabel("Computer Score:  "+compyScore);
		compyScoreLabel.setHorizontalAlignment(JLabel.CENTER);
		currentPlayer = new JLabel("Current Player:  "+name);
		currentPlayer.setHorizontalAlignment(JLabel.CENTER);
		turnTotalLabel = new JLabel("Turn Total:  "+turnTotal);
		turnTotalLabel.setHorizontalAlignment(JLabel.CENTER);
		
		scoreLabels.add(playerScoreLabel);
		scoreLabels.add(compyScoreLabel);
		scoreLabels.add(currentPlayer);
		scoreLabels.add(turnTotalLabel);
		return scoreLabels;
	}
	
	public void setImages(ImageIcon image1, ImageIcon image2){//sets images
		leftImage.setIcon(image1);
		rightImage.setIcon(image2);
	}	
	
	
	public JPanel holdRoll(){//inititalizes hold/roll buttons
		JPanel holdRoll = new JPanel();
		holdRoll.setLayout(new FlowLayout());
		roll = new JButton("Roll");
		hold = new JButton("Hold");
		hold.setEnabled(false);	
		holdRoll.add(roll);
		holdRoll.add(hold);
		return holdRoll;
	}
	public JPanel title(){//two dice pig title label
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		title = new JLabel("Two Dice Pig", JLabel.CENTER);
		title.setFont(new Font("Serif",Font.BOLD+Font.ITALIC, 32));
		
		titlePanel.add(title);
		return titlePanel;
	}
	public void actionPerformed(ActionEvent event){//events
		Object source = event.getSource();
		if (source == roll) {
			setImages(ROLL_IMAGE, ROLL_IMAGE);
			timer.start();
			hold.setEnabled(true);	
			roll();
		} else if (source == hold){  //hold
			setImages(HOLD_IMAGE, HOLD_IMAGE);
			timer.start();
			hold();
			//changeTurn(); - this bugged it out
		}else{//timer dings
			if (playerTurn){
				//setImages(ROLL_IMAGE, ROLL_IMAGE);
				//roll();
			}else{//TODO timer
				//setImages(ROLL_IMAGE, ROLL_IMAGE);
				//compAI();
				
				
			}
		}
	}
	public void changeTurn(){//changes player turn
		if(playerTurn){
			JOptionPane.showMessageDialog(null, "It's my turn");
			hold.setEnabled(false);
			roll.setEnabled(false);	
		}else{
			JOptionPane.showMessageDialog(null, "It's your turn");
			hold.setEnabled(false);
			roll.setEnabled(true);
		}
		playerTurn=!playerTurn;
	}
	
	public void roll(){//set images to roll, then dice
		setImages(ROLL_IMAGE, ROLL_IMAGE);
		timer.start();
		Dice dice = new Dice();
		int[] diceRoll = dice.getRoll();
		
		setImages(DIE_IMAGES[diceRoll[0]+1],DIE_IMAGES[diceRoll[1]+1]);
		
		
		if (dice.getSum()>0){
			turnTotal=turnTotal+dice.getSum();
			
		}else if ((dice.getSum()<0)){//-1 AKA snake eyes
			if(playerTurn){
				playerScore=0;
				playerScoreLabel.setText(name + "'s Score: "+playerScore);
			}else{
				//bigBro.playerScore=compyScore;
				//bigBro.turnTotal=turnTotal;
				compyScore=0;
				compyScoreLabel.setText("Computer Score: "+compyScore);
			}
			turnTotal=0;
			hold();
			//System.out.print("#SNAKE# ");
		}else{//0 single one
			turnTotal=0;
			hold();
		}
		turnTotalLabel.setText("Turn Total:  "+turnTotal);
		//System.out.println("turn "+turnTotal); //+" Score "+playerScore);
		
		/* test ^this^
		boolean go = true;
		while(go){
			System.out.println((diceRoll[0]+1)+ " " + (diceRoll[1]+1));
			System.out.println(dice.getSum());
			if (dice.getSum()<=0){
				go=!go;
				System.out.println("------------------");
			}			
		}*/
	}
	public void hold(){//player holds
		roll.setEnabled(false);	
		hold.setEnabled(false);
		if(playerTurn){
			playerScoreLabel.setText(name + "'s Score:  "+(playerScore+turnTotal));
			playerScore=(playerScore+turnTotal);
		}else{
			compyScoreLabel.setText("Computer Score:  "+(compyScore+turnTotal));
			compyScore=(compyScore+turnTotal);
		}
		turnTotal=0;
		turnTotalLabel.setText("Turn Total:  "+turnTotal);
		changeTurn();
		if(playerTurn==false){
			compAI();
			timer.start();
		}
		setImages(HOLD_IMAGE, HOLD_IMAGE);
	}
	public void compAI(){//computer player
		//ComputerPlayer compyA1 = new ComputerPlayer();
		//compyA1.playerScore=compyScore;
		//compyA1.turnTotal=turnTotal;
		
		
		boolean runStuff = true;	
		while(runStuff){
			System.out.println((turnTotal<20)+""+(compyScore<=100)+""+(!(100-playerScore<=20)));
			roll();
			runStuff=(turnTotal<20&&compyScore<=100&&(!(100-playerScore<=20)));
			
		}
		
		if(playerTurn==false){
			hold();
		}
		
		/*
		if(compyA1.isRolling(playerScore)){
			roll();
			
			//System.out.println("COMPY ROLL");
		}*/
		
		
		
		victory();//won yet?
	}
	public void victory(){//has anyone won?
		if(playerScore>=GOAL_SCORE){
			JOptionPane.showMessageDialog(null, "YOU WIN! (Must be an errorororrrrrrr)");
			hold.setEnabled(false);
			roll.setEnabled(false);
		}else if(compyScore>=GOAL_SCORE){
			JOptionPane.showMessageDialog(null, "COMPUTERS ARE FAR SUPERIOR.");
			hold.setEnabled(false);
			roll.setEnabled(false);		
		}
		if (timer.isRunning()){
			timer.stop();
		}
		
	}
	
	
		
	
		
	
}