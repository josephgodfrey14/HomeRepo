/*
 * Name: Joseph Godfrey
 * Date: 23/Apr/2015
 * Course: CSC 212
 * Program: Lab GUI
 * 
 * Purpose: A GUI to add two integers and display the result.
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MegaCalcGUI extends MouseAdapter implements ActionListener {

	// on-screen components stored as fields
	private JFrame frame;
	private JTextField operand1Field;
	private JTextField operand2Field;
	private JButton plusButton;
	private JButton clearButton;
	private JLabel resultLabel;

	public MegaCalcGUI() {
		// set up components
		frame = new JFrame();
		operand1Field = new JTextField(4);
		operand2Field = new JTextField(4);
		plusButton = new JButton("+");
		clearButton = new JButton("Clear");
		resultLabel = new JLabel();

		// layout
		JPanel north = new JPanel(new FlowLayout());
		north.add(operand1Field);
		north.add(plusButton);
		north.add(operand2Field);

		// overall frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(400, 300));
		frame.setLayout(new BorderLayout());
		frame.setTitle("MegaCalc");

		frame.add(north, BorderLayout.NORTH);
		frame.add(clearButton, BorderLayout.SOUTH);
		frame.add(resultLabel, BorderLayout.CENTER);

		frame.setVisible(true);

		// sets up listeners for buttons
		plusButton.addActionListener(this);
		clearButton.addActionListener(this);

		plusButton.addMouseListener(this);
		clearButton.addMouseListener(this);

	}

	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == plusButton) {
			int addNum = (Integer.parseInt(operand1Field.getText()) + Integer
					.parseInt(operand2Field.getText()));
			resultLabel.setText("Sum: " + addNum);
		} else {
			operand1Field.setText("");
			operand2Field.setText("");
		}
	}

	public void mouseEntered(MouseEvent event) {
		JButton sourceButton = (JButton) event.getSource();
		sourceButton.setForeground(Color.RED);
	}

	public void mouseExited(MouseEvent event) {
		JButton sourceButton = (JButton) event.getSource();
		sourceButton.setForeground(Color.BLACK);
	}

	public static void main(String args[]) {
		MegaCalcGUI gui = new MegaCalcGUI();
	}
}