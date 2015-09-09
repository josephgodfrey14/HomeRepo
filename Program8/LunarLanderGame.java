import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LunarLanderGame implements ActionListener {

	public static void main(String args[]){
		LunarLanderGame gui = new LunarLanderGame();
	}
	
	private JFrame frame;
	private LunarLander myLander;   // lander to query
	private JPanel myInfo;  // info panel
	private LunarPicture myPicture; // picture panel
	private Timer myTimer;          // timer
	private JButton resetButton;
	private JButton thrustButton;
	private JTextField myFuel;
	private JTextField myVelocity;
	private JTextField myAltitude;
	
	public LunarLanderGame(){
		myLander = new LunarLander();
		myLander.reset();
		myInfo = new JPanel();
		setupInfoPanel();
		myPicture = new LunarPicture(myLander);

		JPanel buttons = new JPanel();
		resetButton = new JButton("Reset");
		resetButton.addActionListener(this);
		buttons.add(resetButton);
		thrustButton = new JButton("Thrust");
		thrustButton.addActionListener(this);
		buttons.add(thrustButton);
		
		frame = new JFrame("Lunar Lander Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,500);
		frame.setLayout(new BorderLayout());
		frame.add(buttons, BorderLayout.NORTH);
		frame.add(myPicture, BorderLayout.CENTER);
		frame.add(myInfo, BorderLayout.SOUTH);		
		frame.setVisible(true);
		
		// create a timer and start it
		myTimer = new Timer(1000, this);
		myTimer.start();
		
	}
	
	public void actionPerformed(ActionEvent event){
		Object source = event.getSource();
		if (source == resetButton){
			myLander.reset();
			myTimer.restart();
			updateInfoPanel();
			myPicture.update();
		} else if (source == thrustButton){
			myLander.thrust();
		} else {				// timer caused event
			myLander.tick();
			updateInfoPanel();
			myPicture.update();
			if (myLander.getAltitude() <= 0){
				myTimer.stop();
			}
		}
	}
	
	private void setupInfoPanel(){
		myInfo.setLayout(new GridLayout(3, 1));
			
		// create fuel subpanel
		JPanel fuelPanel = new JPanel();
		myFuel = new JTextField(5);
		myFuel.setEditable(false);
		fuelPanel.add(new JLabel("Fuel"));
		fuelPanel.add(myFuel);
		myInfo.add(fuelPanel);
		
		// create velocity subpanel
		JPanel velocityPanel = new JPanel();
		myVelocity = new JTextField(10);
		myVelocity.setEditable(false);
		velocityPanel.add(new JLabel("Velocity"));
		velocityPanel.add(myVelocity);
		myInfo.add(velocityPanel);
		
		// create altitude subpanel
		JPanel altitudePanel = new JPanel();
		myAltitude = new JTextField(7);
		myAltitude.setEditable(false);
		altitudePanel.add(new JLabel("Altitude"));
		altitudePanel.add(myAltitude);
		myInfo.add(altitudePanel);

		updateInfoPanel();
	}
	
	private void updateInfoPanel()
	// post: updates text fields
	{
		myFuel.setText(myLander.getFuel() + " units");
		myVelocity.setText(myLander.getVelocity() + " meters/second");
		myAltitude.setText(myLander.getAltitude() + " meters");
	}
	
}
