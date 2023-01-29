package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class UpdatePage extends JPanel {

	/**
	 * Create the panel.
	 */
	public UpdatePage() {
		setLayout(null);
		
		JLabel lbtitle = new JLabel("Update Your Recipe ");
		lbtitle.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		lbtitle.setBounds(154, 10, 152, 55);
		add(lbtitle);

	}

}
