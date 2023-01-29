package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class CreatePage extends JPanel {

	/**
	 * Create the panel.
	 */
	public CreatePage() {
		setLayout(null);
		
		JLabel lbtitle = new JLabel("Create Your Recipe ");
		lbtitle.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		lbtitle.setBounds(153, 10, 152, 55);
		add(lbtitle);

	}
}
