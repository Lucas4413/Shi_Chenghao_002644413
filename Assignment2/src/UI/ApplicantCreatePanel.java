package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class ApplicantCreatePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ApplicantCreatePanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Your Application");
		lblNewLabel.setBounds(297, 27, 178, 15);
		add(lblNewLabel);

	}
}
