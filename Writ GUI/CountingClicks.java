//Name: Joseph Godfrey
//Date: 24/Apr/2015

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class CountingClicks implements ActionListener {

	private JButton clickHere;
	private JLabel numClicks;
	private int clickCount;
	private JLabel displayClick;

	public static void main(String args[]) {
		CountingClicks gui = new CountingClicks();
	}

	public CountingClicks() {
		JFrame frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(300, 75));
		frame.setLayout(new FlowLayout());
		frame.setTitle("Counting Clicks");

		clickHere = new JButton("Click here");

		numClicks = new JLabel("Number clicks: ");
		displayClick = new JLabel("" + clickCount);

		frame.add(clickHere);
		frame.add(numClicks);
		frame.add(displayClick);

		frame.setVisible(true);

		clickHere.addActionListener(this);

	}

	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == clickHere) {
			clickCount++;
			displayClick.setText("" + clickCount);
		}
	}

}
