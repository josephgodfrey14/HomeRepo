//Name: Joseph Godfrey
//Date: 20/Apr/2015

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WhereMouse extends MouseAdapter {

	private JLabel clickLabel;
	private int width;
	private int height;
	private JFrame frame;

	public static void main(String args[]) {
		WhereMouse gui = new WhereMouse();
	}

	public WhereMouse() {

		frame = new JFrame();
		frame.addMouseListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(400, 300));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLayout(null);
		frame.setTitle("Where's the mouse?");

		width = frame.getWidth();
		height = frame.getHeight();

		clickLabel = new JLabel("Click the mouse in the panel.");

		clickLabel.setBounds(5, 245, 400, 20);
		frame.add(clickLabel);

		frame.setVisible(true);

		frame.addMouseListener(this);

	}

	public void mousePressed(MouseEvent event) {

		if (event.getX() == frame.getWidth() / 2
				|| event.getY() == frame.getHeight() / 2) {
			// TODO dividing line
			// JOptionPane.showMessageDialog(frame, "dividing line");
			clickLabel.setText("The last click was on the dividing line!");
		} else if (event.getX() < frame.getWidth() / 2
				&& event.getY() < frame.getHeight() / 2) {
			// TODO upper left
			// JOptionPane.showMessageDialog(frame, "upper left");
			clickLabel.setText("The last click was in the upper-left quarter");
		} else if (event.getX() > frame.getWidth() / 2
				&& event.getY() < frame.getHeight() / 2) {
			// TODO upper right
			// JOptionPane.showMessageDialog(frame, "upper right");
			clickLabel.setText("The last click was in the upper-right quarter");
		} else if (event.getX() < frame.getWidth() / 2
				&& event.getY() > frame.getHeight() / 2) {
			// TODO lower left
			// JOptionPane.showMessageDialog(frame, "lower left");
			clickLabel.setText("The last click was in the lower-left quarter");
		} else if (event.getX() > frame.getWidth() / 2
				&& event.getY() > frame.getHeight() / 2) {
			// TODO lower right
			// JOptionPane.showMessageDialog(frame, "lower right");
			clickLabel.setText("The last click was in the lower-right quarter");
		} else {
			clickLabel.setText("Click the mouse in the panel.");
		}
	}
}
