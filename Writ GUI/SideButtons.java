//Name: Joseph Godfrey
//Date: 20/Apr/2015

import javax.swing.*;

import java.awt.*;

public class SideButtons {

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(300, 200));
		frame.setLayout(new BorderLayout());
		frame.setTitle("Side Buttons!");

		JPanel gridPanel = new JPanel(new GridLayout(2, 1));
		gridPanel.add(new JButton("Top"));
		gridPanel.add(new JButton("Bottom"));

		JPanel textAreaPanel = new JPanel(new FlowLayout());
		textAreaPanel.add(new JTextArea());

		frame.add(textAreaPanel, BorderLayout.CENTER);
		frame.add(gridPanel, BorderLayout.WEST);
		frame.add(new JButton("Right"), BorderLayout.EAST);
		frame.setVisible(true);

	}

}
