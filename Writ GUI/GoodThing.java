//Name: Joseph Godfrey
//Date: 20/Apr/2015

import javax.swing.*;
import java.awt.*;

public class GoodThing {

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(300, 200));
		frame.setLayout(new BorderLayout());
		frame.setTitle("Good thing I studied!");

		JPanel gridPanel = new JPanel(new GridLayout(1, 3));
		gridPanel.add(new JButton("Button1"));
		gridPanel.add(new JButton("Button2"));
		gridPanel.add(new JButton("Button3"));

		JPanel textFieldPanel = new JPanel(new FlowLayout());
		textFieldPanel.add(new JLabel("Type stuff:"));
		textFieldPanel.add(new JTextField(10));

		frame.add(textFieldPanel, BorderLayout.SOUTH);
		frame.add(gridPanel, BorderLayout.NORTH);
		frame.add(new JButton("A REALLY big button!"), BorderLayout.CENTER);
		frame.setVisible(true);

	}

}
