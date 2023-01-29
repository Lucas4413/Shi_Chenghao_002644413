package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class ReadPage extends JPanel {

	/**
	 * Create the panel.
	 */
	public ReadPage() {
		setLayout(null);
		
		JLabel lbtitle = new JLabel("Read Your Recipe ");
		lbtitle.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		lbtitle.setBounds(162, 10, 152, 55);
		add(lbtitle);

	}

}
