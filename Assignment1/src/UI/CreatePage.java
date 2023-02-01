package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Model.Recipe;

import javax.swing.JTextArea;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Checkbox;
import java.awt.Choice;
import javax.swing.DropMode;
import UI.MainJFrame;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class CreatePage extends JPanel {
	private JTextField tfPicture;
	private JTextField tfCategory;
	private JTextField tfNoOfIngredients;
	private JTextField tfDifficulty;
	private JTextField tfNoOfServing;
	private JTextField tfRecipeTitle;
	private JTextField tfPhone;
	private JTextField tfEmail;
	private JTextField tfUsername;
	private JTextField tfLastName;
	private JTextField tfFirstName;
	private MainJFrame mainJFrame = new MainJFrame();
	
	/**
	 * Create the panel.
	 */
	public CreatePage(ArrayList<Recipe> recipes, ArrayList<String> usernames) {
		setBackground(Color.ORANGE);
		setLayout(null);
		
		JLabel lbtitle = new JLabel("Create Your Recipe ");
		lbtitle.setBounds(429, 22, 152, 55);
		lbtitle.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		add(lbtitle);
		
		JLabel lbRecipeDetail = new JLabel("Recipe Details:");
		lbRecipeDetail.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
		lbRecipeDetail.setBounds(32, 74, 96, 42);
		add(lbRecipeDetail);
		
		JLabel lbRecipeTitle = new JLabel("Recipe Title");
		lbRecipeTitle.setBounds(74, 126, 89, 15);
		add(lbRecipeTitle);
		
		JLabel lbNoOfServing = new JLabel("No. of Serving");
		lbNoOfServing.setBounds(74, 151, 113, 15);
		add(lbNoOfServing);
		
		JLabel lbGlutenFree = new JLabel("Is Gluten Free (yes/no)");
		lbGlutenFree.setBounds(74, 176, 145, 15);
		add(lbGlutenFree);
		
		JLabel lbDifficultyLevel = new JLabel("Difficulty Level (1 to 5)");
		lbDifficultyLevel.setBounds(74, 201, 158, 15);
		add(lbDifficultyLevel);
		
		JLabel lbNoOfIngredients = new JLabel("No. of Ingredients");
		lbNoOfIngredients.setBounds(74, 226, 127, 15);
		add(lbNoOfIngredients);
		
		JLabel lbCategory = new JLabel("Category");
		lbCategory.setBounds(74, 251, 75, 15);
		add(lbCategory);
		
		JLabel lbPicture = new JLabel("Recipe Picture");
		lbPicture.setBounds(74, 276, 113, 15);
		add(lbPicture);
		
		JLabel lbDescription = new JLabel("Description");
		lbDescription.setBounds(74, 347, 89, 15);
		add(lbDescription);
		
		tfPicture = new JTextField();
		tfPicture.setBounds(242, 273, 219, 21);
		add(tfPicture);
		tfPicture.setColumns(10);
		
		tfCategory = new JTextField();
		tfCategory.setBounds(242, 248, 219, 21);
		add(tfCategory);
		tfCategory.setColumns(10);
		
		tfNoOfIngredients = new JTextField();
		tfNoOfIngredients.setBounds(242, 223, 219, 21);
		add(tfNoOfIngredients);
		tfNoOfIngredients.setColumns(10);
		
		tfDifficulty = new JTextField();
		tfDifficulty.setBounds(242, 198, 219, 21);
		add(tfDifficulty);
		tfDifficulty.setColumns(10);
		
		tfNoOfServing = new JTextField();
		tfNoOfServing.setBounds(242, 148, 219, 21);
		add(tfNoOfServing);
		tfNoOfServing.setColumns(10);
		
		tfRecipeTitle = new JTextField();
		tfRecipeTitle.setBounds(242, 123, 219, 21);
		add(tfRecipeTitle);
		tfRecipeTitle.setColumns(10);
		
		JTextArea taDescription = new JTextArea();
		taDescription.setBounds(242, 307, 219, 92);
		add(taDescription);
		
		JLabel lbChefDetail = new JLabel("Chef Information:");
		lbChefDetail.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
		lbChefDetail.setBounds(520, 74, 113, 42);
		add(lbChefDetail);
		
		JLabel lbFirstName = new JLabel("Chef's First Name");
		lbFirstName.setForeground(new Color(0, 0, 0));
		lbFirstName.setBounds(569, 126, 113, 15);
		add(lbFirstName);
		
		JLabel lbLastName = new JLabel("Chef's Last Name");
		lbLastName.setBounds(569, 151, 113, 15);
		add(lbLastName);
		
		JLabel lbUsername = new JLabel("Username");
		lbUsername.setBounds(569, 176, 145, 15);
		add(lbUsername);
		
		JLabel lbEmail = new JLabel("E-mail");
		lbEmail.setBounds(569, 201, 158, 15);
		add(lbEmail);
		
		JLabel lbPhone = new JLabel("Phone Number");
		lbPhone.setBounds(569, 226, 127, 15);
		add(lbPhone);
		
		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(737, 223, 219, 21);
		add(tfPhone);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(737, 198, 219, 21);
		add(tfEmail);
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(737, 173, 219, 21);
		add(tfUsername);
		
		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		tfLastName.setBounds(737, 148, 219, 21);
		add(tfLastName);
		
		tfFirstName = new JTextField();
		tfFirstName.setColumns(10);
		tfFirstName.setBounds(737, 123, 219, 21);
		add(tfFirstName);
		
		Choice choiceYesorNo = new Choice();
		choiceYesorNo.setBounds(241, 173, 220, 21);
		add(choiceYesorNo);
		choiceYesorNo.add("Yes");
		choiceYesorNo.add("No");
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String recipeTitle = tfRecipeTitle.getText();
				String noOfServing = tfNoOfServing.getText();
				String isGlutenFree = choiceYesorNo.getSelectedItem();
				String difficulty = tfDifficulty.getText();
				String noOfIngredients = tfNoOfIngredients.getText();
				String category = tfNoOfServing.getText();
				String picture = tfPicture.getText();
				String description = taDescription.getText();
				String firstName = tfFirstName.getText();
				String lastName = tfLastName.getText();
				String username = tfUsername.getText();
				String email = tfEmail.getText();
				String phone = tfPhone.getText();
				
				if(mainJFrame.isEmptyOrNull(recipeTitle) || mainJFrame.isEmptyOrNull(noOfServing) || mainJFrame.isEmptyOrNull(difficulty) || 
				   mainJFrame.isEmptyOrNull(noOfIngredients) || mainJFrame.isEmptyOrNull(category) || mainJFrame.isEmptyOrNull(picture) || 
				   mainJFrame.isEmptyOrNull(description) || mainJFrame.isEmptyOrNull(firstName) || mainJFrame.isEmptyOrNull(lastName) || 
				   mainJFrame.isEmptyOrNull(username) || mainJFrame.isEmptyOrNull(email) | mainJFrame.isEmptyOrNull(phone)) {
					JOptionPane.showMessageDialog(null, "Please fill out all the content!");
					return;
				}else if (!mainJFrame.isInteger(noOfIngredients)) {
					JOptionPane.showMessageDialog(null, "No. of Ingredient should be an integer!");
					return;
				}else if (!mainJFrame.isInteger(noOfServing)) {
					JOptionPane.showMessageDialog(null, "No. of Serving should be an integer!");
					return;
				}else if (!mainJFrame.isFloat(difficulty)) {
					JOptionPane.showMessageDialog(null, "The Difficulty Level should be a number!");
					return;
				}else if (mainJFrame.checkSpecialSymbol(firstName) || mainJFrame.checkSpecialSymbol(lastName) ||
						  mainJFrame.hasDigit(firstName) || mainJFrame.hasDigit(lastName)) {
					JOptionPane.showMessageDialog(null, "Chef's name should not contain any special symbols or numbers!");
					return;
				}else if (usernames.contains(username)) {
					JOptionPane.showMessageDialog(null, "The Username should be unique!");
					return;
				}else if (!mainJFrame.isDigit(phone)) {
					JOptionPane.showMessageDialog(null, "Please enter an valid phone number!");
					return;
				}else if (!email.contains("@") || !email.contains(".com")) {
					JOptionPane.showMessageDialog(null, "The email address should contain \"@\" and \".com\"!");
					return;
				}else if (Float.parseFloat(difficulty) < 1 || Float.parseFloat(difficulty) > 5) {
					JOptionPane.showMessageDialog(null, "The Difficulty Level should be between 1 to 5!");
					return;
				}
				
				Recipe recipe = new Recipe();
				recipe.setCategory(category);
				recipe.setDescription(description);
				recipe.setDifficulty(Float.parseFloat(difficulty));
				if(isGlutenFree.equals("Yes")) {
					recipe.setIsGlutenFree(true);
				}else {
					recipe.setIsGlutenFree(false);
				}
				recipe.setRecipePicture(new File(tfPicture.getText()));
				recipe.setNo_of_Ingredients(Integer.valueOf(noOfIngredients));
				recipe.setNo_of_Serving(Integer.valueOf(noOfServing));
				recipe.setTitle(recipeTitle);
				recipe.setChef(firstName, lastName, username, email, phone);
				recipes.add(recipe);
				usernames.add(username);
				JOptionPane.showMessageDialog(null, "You've successfully created a recipe");
			}
		});
		btnCreate.setFont(new Font("Source Sans Pro", Font.PLAIN, 16));
		btnCreate.setBounds(699, 320, 93, 42);
		add(btnCreate);
		
		

	}
}
