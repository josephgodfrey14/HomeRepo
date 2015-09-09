/* TVtoGO - a simple graphical shell for 'downloading' movies and tv-episodes.
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class TVtoGO implements ActionListener,
		ListSelectionListener {

	public static void main(String[] args) {
		// call the constructor - runs the application
		TVtoGO gui = new TVtoGO();
	}
	
	// frame to hold GUI
	private JFrame frame;
	
	// variable holding a Content object
	private Content videoContent;

	// variables for search field and area for displaying details
	private JTextField search; 
	private JTextArea detail;
	
	// a scrollable list to display a set of VideoItems in the Content object
	private JList<VideoItem> listItems;

	// buttons
	private JButton btnDownload;
	private JButton btnSearch;
	private JButton exit;
	private JButton btnRank;
	private JLabel labelTopRanked;

	/* Constructor */
	public TVtoGO() {
		// initialize instance variables
		search = new JTextField("", 20); 
		detail = new JTextArea(20, 5);
		btnDownload = new JButton("Download");
		btnSearch = new JButton("Search");
		exit = new JButton("Exit");
		btnRank = new JButton("Rank");
		
		// Create a Content object
		videoContent = new Content("CSC212 Sample Library");

		// set a few properties of the window
		frame = new JFrame("TV to GO");
		frame.setSize(700, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(10, 10));

		JLabel label = new JLabel("    Movies and TV-series episodes");
		labelTopRanked = new JLabel("#1 item: " + videoContent.topRanked().getFullTitle()) ;
		label.setFont(new Font("Times", Font.BOLD, 16));
		frame.add(label, BorderLayout.NORTH);
		
		// create a JPanel to put in the center, add subpanels
		JPanel centerPanel = new JPanel(new GridLayout(1, 2, 10, 5));
		centerPanel.add(constructLeftPanel());
		centerPanel.add(constructRightPanel());

		// Add the centerPanel to the window
		frame.add(centerPanel, BorderLayout.CENTER);

		// set the selection in the list to the first item
		listItems.setSelectedIndex(0);

		// Register to listen to button events
		btnDownload.addActionListener(this);
		btnSearch.addActionListener(this);
		search.addActionListener(this);
		exit.addActionListener(this);
		btnRank.addActionListener(this);

		frame.setVisible(true);
	}

	/*
	 * Constructs and returns the left-side
	 * panel with search field and button, the list of items for selection and
	 * the Exit button.
	 */
	public JPanel constructLeftPanel() {
		JPanel panel = new JPanel(new FlowLayout());

		// create the search text field
		search.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
		search.setFont(new Font("Times", Font.ITALIC, 13));

		// create a list, fill it with array of items from vContent
		listItems = new JList<VideoItem>(videoContent.getItems());
		listItems.addListSelectionListener(this);
		// create a scroll pane for the list
		JScrollPane scrlPane = new JScrollPane(listItems);
		
		scrlPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrlPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		// finally, add the components to the panel
		panel.add(search);
		panel.add(btnSearch);
		panel.add(scrlPane);
		panel.add(labelTopRanked);
		panel.add(exit);

		// .. and return the panel
		return panel;
	}

	/*
	 * Constructs and returns the panel for displaying the details of the
	 * selected item and the Download button.
	 */
	public JPanel constructRightPanel() {
		JPanel panel = new JPanel(new FlowLayout());
		// create the detail text area, uneditable
		detail = new JTextArea(8, 20);
		detail.setBackground(frame.getBackground());
		detail.setEditable(false);
		detail.setFont(new Font("Times", Font.ITALIC, 13));
		detail.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLoweredBevelBorder(), "Details:"));
		// add components to the panel
		panel.add(detail);
		panel.add(btnDownload);
		panel.add(btnRank);

		return panel;
	}

	/*
	 * gets called when a selection in the listbox changes.
	 * Updates the detail text area with the information from the selected item
	 */
	public void valueChanged(ListSelectionEvent e) {
		String detailText = ((VideoItem) listItems.getSelectedValue())
				.getItemDetails();
		detail.setText(detailText);

	}

	/*
	 * method gets called when a button is pressed. Performs an
	 * appropriate action.
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnDownload) { // download button pressed
			// get the selected item and call method download on it
			VideoItem videoSelected = (VideoItem) listItems.getSelectedValue();	
		
			if (videoSelected.isAvailableForDownload()){
				videoSelected.download();
				JOptionPane.showMessageDialog(null,
						"Downloading  " + videoSelected.getFullTitle());
				// update the detail data so the new download count can be displayed
				detail.setText(videoSelected.getItemDetails());
			} else {
				JOptionPane.showMessageDialog(null, videoSelected.getFullTitle()
						+ " has expired and is not available for download");
			}
			
		} else if (e.getSource() == search
				|| e.getSource() == btnSearch) {
			// first, get the content of the search text field
			String searchPhrase = search.getText();
			VideoItem viFound = null;
			// check that search phrase isn't empty
			if (searchPhrase != null && !searchPhrase.trim().isEmpty()) {
				// search the vContent for an item with searchPhrase
				viFound = videoContent.findVideoItem(searchPhrase);
				if (viFound != null)
					listItems.setSelectedValue(viFound, true);
				else
					JOptionPane.showMessageDialog(null,
							"No title matched search phrase \"" + searchPhrase
									+ "\"");
			}

		} else if (e.getSource() == btnRank) {
			VideoItem viSelected = (VideoItem) listItems.getSelectedValue();
			String userInput = JOptionPane.showInputDialog(null, "Please provide a ranking for \""
					+ viSelected.getTitle() + "\"\n on a scale from 0 to 10");
			int ranking = Integer.parseInt(userInput);
			viSelected.processAnotherRanking(ranking);
			// update the detail data so the updated ranking can be displayed
			detail.setText(viSelected.getItemDetails());
			System.out.println(videoContent.topRanked().getFullTitle());
			labelTopRanked.setText("#1 item: " + videoContent.topRanked().getFullTitle()) ;
			
			
		} else if (e.getSource() == this.exit)
			System.exit(0);

		this.listItems.repaint();

	}

	
}
