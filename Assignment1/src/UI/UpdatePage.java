package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import Model.Chef;
import Model.Recipe;

import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Choice;
import java.awt.Checkbox;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

import UI.MainJFrame;
import java.awt.Color;

public class UpdatePage extends JPanel {
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
	public UpdatePage(ArrayList<Recipe> recipes, ArrayList<String> usernames) {
		setBackground(Color.PINK);
		setLayout(null);
		
		//display the first recipe in the arraylist
		Recipe recipe = recipes.get(0);
		Chef chef = recipe.getChef();
		
		JLabel lbtitle = new JLabel("Update Your Recipe ");
		lbtitle.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		lbtitle.setBounds(429, 29, 152, 55);
		add(lbtitle);
		
		JLabel lbRecipeDetail = new JLabel("Recipe Details:");
		lbRecipeDetail.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
		lbRecipeDetail.setBounds(32, 81, 96, 42);
		add(lbRecipeDetail);
		
		JLabel lbRecipeTitle = new JLabel("Recipe Title");
		lbRecipeTitle.setBounds(74, 133, 89, 15);
		add(lbRecipeTitle);
		
		JLabel lbNoOfServing = new JLabel("No. of Serving");
		lbNoOfServing.setBounds(74, 158, 113, 15);
		add(lbNoOfServing);
		
		JLabel lbGlutenFree = new JLabel("Is Gluten Free (yes/no)");
		lbGlutenFree.setBounds(74, 183, 145, 15);
		add(lbGlutenFree);
		
		JLabel lbDifficultyLevel = new JLabel("Difficulty Level (1 to 5)");
		lbDifficultyLevel.setBounds(74, 208, 158, 15);
		add(lbDifficultyLevel);
		
		JLabel lbNoOfIngredients = new JLabel("No. of Ingredients");
		lbNoOfIngredients.setBounds(74, 233, 127, 15);
		add(lbNoOfIngredients);
		
		JLabel lbCategory = new JLabel("Category");
		lbCategory.setBounds(74, 258, 75, 15);
		add(lbCategory);
		
		tfCategory = new JTextField();
		tfCategory.setColumns(10);
		tfCategory.setBounds(242, 255, 219, 21);
		add(tfCategory);
		
		tfNoOfIngredients = new JTextField();
		tfNoOfIngredients.setColumns(10);
		tfNoOfIngredients.setBounds(242, 230, 219, 21);
		add(tfNoOfIngredients);
		
		tfDifficulty = new JTextField();
		tfDifficulty.setColumns(10);
		tfDifficulty.setBounds(242, 205, 219, 21);
		add(tfDifficulty);
		
		tfNoOfServing = new JTextField();
		tfNoOfServing.setColumns(10);
		tfNoOfServing.setBounds(242, 155, 219, 21);
		add(tfNoOfServing);
		
		tfRecipeTitle = new JTextField();
		tfRecipeTitle.setColumns(10);
		tfRecipeTitle.setBounds(242, 130, 219, 21);
		add(tfRecipeTitle);
		
		JLabel lbChefDetail = new JLabel("Chef Information:");
		lbChefDetail.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
		lbChefDetail.setBounds(520, 81, 113, 42);
		add(lbChefDetail);
		
		JLabel lbFirstName = new JLabel("Chef's First Name");
		lbFirstName.setBounds(569, 133, 113, 15);
		add(lbFirstName);
		
		JLabel lbLastName = new JLabel("Chef's Last Name");
		lbLastName.setBounds(569, 158, 113, 15);
		add(lbLastName);
		
		JLabel lbUsername = new JLabel("Username");
		lbUsername.setBounds(569, 183, 145, 15);
		add(lbUsername);
		
		JLabel lbEmail = new JLabel("E-mail");
		lbEmail.setBounds(569, 208, 158, 15);
		add(lbEmail);
		
		JLabel lbPhone = new JLabel("Phone Number");
		lbPhone.setBounds(569, 233, 127, 15);
		add(lbPhone);
		
		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(737, 230, 219, 21);
		add(tfPhone);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(737, 205, 219, 21);
		add(tfEmail);
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(737, 180, 219, 21);
		add(tfUsername);
		
		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		tfLastName.setBounds(737, 155, 219, 21);
		add(tfLastName);
		
		tfFirstName = new JTextField();
		tfFirstName.setColumns(10);
		tfFirstName.setBounds(737, 130, 219, 21);
		add(tfFirstName);
		
		JLabel lbPicture = new JLabel("Recipe Picture");
		lbPicture.setBounds(74, 343, 113, 15);
		add(lbPicture);
		
		JLabel lbImg = new JLabel("Recipe Image Here");
		lbImg.setBackground(Color.WHITE);
		lbImg.setBounds(242, 283, 148, 157);
		add(lbImg);
		
		JLabel lbFilePath = new JLabel("File Path");
		lbFilePath.setBounds(400, 343, 75, 15);
		add(lbFilePath);
		
		JButton btnShowImg = new JButton("Browser");
		btnShowImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooseRecipeImage = new JFileChooser();
				
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
				chooseRecipeImage.addChoosableFileFilter(fnef);
				
				int showOptionDialog = chooseRecipeImage.showOpenDialog(null);
				if (showOptionDialog == JFileChooser.APPROVE_OPTION) {
					File selectedImageFile = chooseRecipeImage.getSelectedFile();
					String imagePath = selectedImageFile.getAbsolutePath();
					String prefix = imagePath.substring(imagePath.lastIndexOf(".")+1);
					if (!prefix.equals("png")&&!prefix.equals("jpg")&&!prefix.equals("jpeg")) {
						JOptionPane.showMessageDialog(null, "Please select a image file !");
						return;
					};
					
					lbFilePath.setText(imagePath);
					
					Image image =new ImageIcon(imagePath).getImage().getScaledInstance(lbImg.getWidth(), lbImg.getHeight(), Image.SCALE_SMOOTH);
					
					lbImg.setIcon(new ImageIcon(image));
				}
			}
		});
		btnShowImg.setBounds(400, 373, 93, 23);
		add(btnShowImg);
		
		JTextArea taDescription = new JTextArea();
		taDescription.setBounds(242, 450, 219, 63);
		add(taDescription);
		
		JLabel lbDescription = new JLabel("Description");
		lbDescription.setBounds(74, 472, 89, 15);
		add(lbDescription);
		
		Choice choice = new Choice();
		choice.setFont(new Font("Source Sans Pro", Font.PLAIN, 16));
		choice.setBounds(569, 318, 158, 27);
		add(choice);
		for (String u:usernames) {
			choice.add(u);
		}
		
		Choice choiceYesorNo = new Choice();
		choiceYesorNo.setBounds(241, 180, 220, 21);
		add(choiceYesorNo);
		choiceYesorNo.add("Yes");
		choiceYesorNo.add("No");
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String target = choice.getSelectedItem();
				Recipe showedRecipe = recipes.get(usernames.indexOf(target));
				Chef showedChef = showedRecipe.getChef();
				if(showedRecipe.getIsGlutenFree()) {
					choiceYesorNo.select("Yes");
				}else {
					choiceYesorNo.select("No");
				}
				tfRecipeTitle.setText(showedRecipe.getTitle());
				tfNoOfServing.setText(""+showedRecipe.getNo_of_Serving());
				tfDifficulty.setText(""+showedRecipe.getDifficulty());
				tfNoOfIngredients.setText(""+showedRecipe.getNo_of_Ingredients());
				tfCategory.setText(showedRecipe.getCategory());
				taDescription.setText(showedRecipe.getDescription());
				lbFilePath.setText(showedRecipe.getRecipePicture().getAbsolutePath());
				Image image =new ImageIcon(showedRecipe.getRecipePicture().getAbsolutePath()).getImage().getScaledInstance(lbImg.getWidth(), lbImg.getHeight(), Image.SCALE_SMOOTH);
				lbImg.setIcon(new ImageIcon(image));
				tfFirstName.setText(showedChef.getFirstName());
				tfLastName.setText(showedChef.getLastName());
				tfUsername.setText(showedChef.getUserName());
				tfEmail.setText(showedChef.getEmail());
				tfPhone.setText(showedChef.getPhoneNumber());
			}
		});
		btnShow.setFont(new Font("Source Sans Pro", Font.PLAIN, 16));
		btnShow.setBounds(762, 284, 93, 42);
		add(btnShow);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String recipeTitle = tfRecipeTitle.getText();
				String noOfServing = tfNoOfServing.getText();
				String isGlutenFree = choiceYesorNo.getSelectedItem();
				String difficulty = tfDifficulty.getText();
				String noOfIngredients = tfNoOfIngredients.getText();
				String category = tfNoOfServing.getText();
				String picture = lbFilePath.getText();
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
				}else if (!mainJFrame.isInteger(noOfIngredients) || noOfIngredients.contains("-") || noOfIngredients.equals("0")) {
					JOptionPane.showMessageDialog(null, "No. of Ingredient should be an positive integer!");
					return;
				}else if (!mainJFrame.isInteger(noOfServing) || noOfServing.contains("-") || noOfServing.equals("0")) {
					JOptionPane.showMessageDialog(null, "No. of Serving should be an positive integer!");
					return;
				}else if (!mainJFrame.isFloat(difficulty)) {
					JOptionPane.showMessageDialog(null, "The Difficulty Level should be a number!");
					return;
				}else if (mainJFrame.checkSpecialSymbol(firstName) || mainJFrame.checkSpecialSymbol(lastName) ||
						  mainJFrame.hasDigit(firstName) || mainJFrame.hasDigit(lastName)) {
					JOptionPane.showMessageDialog(null, "Chef's name should not contain any special symbols or numbers!");
					return;
				}else if (!mainJFrame.isDigit(phone)) {
					JOptionPane.showMessageDialog(null, "Please enter an valid phone number!");
					return;
				}else if (!mainJFrame.checkEmail(email)) {
					JOptionPane.showMessageDialog(null, "Please enter a valid email address!");
					return;
				}else if (Float.parseFloat(difficulty) < 1 || Float.parseFloat(difficulty) > 5) {
					JOptionPane.showMessageDialog(null, "The Difficulty Level should be between 1 to 5!");
					return;
				}
				
				int idx = usernames.indexOf(choice.getSelectedItem());
				
				Recipe recipe = new Recipe();
				recipe.setCategory(category);
				recipe.setDescription(description);
				recipe.setDifficulty(Float.parseFloat(difficulty));
				if(isGlutenFree.equals("Yes")) {
					recipe.setIsGlutenFree(true);
				}else {
					recipe.setIsGlutenFree(false);
				}
				recipe.setRecipePicture(new File(lbFilePath.getText()));
				recipe.setNo_of_Ingredients(Integer.valueOf(noOfIngredients));
				recipe.setNo_of_Serving(Integer.valueOf(noOfServing));
				recipe.setTitle(recipeTitle);
				recipe.setChef(firstName, lastName, username, email, phone);
				recipes.set(idx, recipe);
				usernames.set(idx, username);
				JOptionPane.showMessageDialog(null, "You've successfully updated a recipe");
			}
		});
		btnUpdate_1.setFont(new Font("Source Sans Pro", Font.PLAIN, 16));
		btnUpdate_1.setBounds(762, 338, 93, 42);
		add(btnUpdate_1);
		
		if(recipe.getIsGlutenFree()) {
			choiceYesorNo.select("Yes");
		}else {
			choiceYesorNo.select("No");
		}
		tfRecipeTitle.setText(recipe.getTitle());
		tfNoOfServing.setText(""+recipe.getNo_of_Serving());
		tfDifficulty.setText(""+recipe.getDifficulty());
		tfNoOfIngredients.setText(""+recipe.getNo_of_Ingredients());
		tfCategory.setText(recipe.getCategory());
		taDescription.setText(recipe.getDescription());
		lbFilePath.setText(recipe.getRecipePicture().getAbsolutePath());
		Image image =new ImageIcon(recipe.getRecipePicture().getAbsolutePath()).getImage().getScaledInstance(lbImg.getWidth(), lbImg.getHeight(), Image.SCALE_SMOOTH);
		lbImg.setIcon(new ImageIcon(image));
		tfFirstName.setText(chef.getFirstName());
		tfLastName.setText(chef.getLastName());
		tfUsername.setText(chef.getUserName());
		tfEmail.setText(chef.getEmail());
		tfPhone.setText(chef.getPhoneNumber());

	}
}
