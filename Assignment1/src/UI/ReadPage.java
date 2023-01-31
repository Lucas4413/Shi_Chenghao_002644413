package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;

import Model.Chef;
import Model.Recipe;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.Checkbox;
import java.awt.event.ActionListener;
import java.lang.annotation.Target;
import java.awt.event.ActionEvent;

public class ReadPage extends JPanel {
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

	/**
	 * Create the panel.
	 */
	public ReadPage(ArrayList<Recipe> recipes, ArrayList<String> usernames) {
		setLayout(null);
		
		//display the first recipe in the arraylist
		Recipe recipe = recipes.get(0);
		Chef chef = recipe.getChef();
		
		JLabel lblReadYourRecipe = new JLabel("Read Your Recipe ");
		lblReadYourRecipe.setFont(new Font("Source Sans Pro", Font.PLAIN, 18));
		lblReadYourRecipe.setBounds(429, 25, 152, 55);
		add(lblReadYourRecipe);
		
		JLabel lbRecipeDetail = new JLabel("Recipe Details:");
		lbRecipeDetail.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
		lbRecipeDetail.setBounds(32, 77, 96, 42);
		add(lbRecipeDetail);
		
		JLabel lbRecipeTitle = new JLabel("Recipe Title");
		lbRecipeTitle.setBounds(74, 129, 89, 15);
		add(lbRecipeTitle);
		
		JLabel lbNoOfServing = new JLabel("No. of Serving");
		lbNoOfServing.setBounds(74, 154, 113, 15);
		add(lbNoOfServing);
		
		JLabel lbGlutenFree = new JLabel("Is Gluten Free (yes/no)");
		lbGlutenFree.setBounds(74, 179, 145, 15);
		add(lbGlutenFree);
		
		JLabel lbDifficultyLevel = new JLabel("Difficulty Level (1 to 5)");
		lbDifficultyLevel.setBounds(74, 204, 158, 15);
		add(lbDifficultyLevel);
		
		JLabel lbNoOfIngredients = new JLabel("No. of Ingredients");
		lbNoOfIngredients.setBounds(74, 229, 127, 15);
		add(lbNoOfIngredients);
		
		JLabel lbCategory = new JLabel("Category");
		lbCategory.setBounds(74, 254, 75, 15);
		add(lbCategory);
		
		JLabel lbPicture = new JLabel("Recipe Picture");
		lbPicture.setBounds(74, 279, 113, 15);
		add(lbPicture);
		
		JLabel lbDescription = new JLabel("Description");
		lbDescription.setBounds(74, 350, 89, 15);
		add(lbDescription);
		
		tfPicture = new JTextField();
		tfPicture.setColumns(10);
		tfPicture.setBounds(242, 276, 219, 21);
		add(tfPicture);
		
		tfCategory = new JTextField();
		tfCategory.setColumns(10);
		tfCategory.setBounds(242, 251, 219, 21);
		add(tfCategory);
		
		tfNoOfIngredients = new JTextField();
		tfNoOfIngredients.setColumns(10);
		tfNoOfIngredients.setBounds(242, 226, 219, 21);
		add(tfNoOfIngredients);
		
		tfDifficulty = new JTextField();
		tfDifficulty.setColumns(10);
		tfDifficulty.setBounds(242, 201, 219, 21);
		add(tfDifficulty);
		
		tfNoOfServing = new JTextField();
		tfNoOfServing.setColumns(10);
		tfNoOfServing.setBounds(242, 151, 219, 21);
		add(tfNoOfServing);
		
		tfRecipeTitle = new JTextField();
		tfRecipeTitle.setColumns(10);
		tfRecipeTitle.setBounds(242, 126, 219, 21);
		add(tfRecipeTitle);
		
		JTextArea taDescription = new JTextArea();
		taDescription.setBounds(242, 310, 219, 92);
		add(taDescription);
		
		JLabel lbChefDetail = new JLabel("Chef Information:");
		lbChefDetail.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
		lbChefDetail.setBounds(520, 77, 113, 42);
		add(lbChefDetail);
		
		JLabel lbFirstName = new JLabel("Chef's First Name");
		lbFirstName.setBounds(569, 129, 113, 15);
		add(lbFirstName);
		
		JLabel lbLastName = new JLabel("Chef's Last Name");
		lbLastName.setBounds(569, 154, 113, 15);
		add(lbLastName);
		
		JLabel lbUsername = new JLabel("Username");
		lbUsername.setBounds(569, 179, 145, 15);
		add(lbUsername);
		
		JLabel lbEmail = new JLabel("E-mail");
		lbEmail.setBounds(569, 204, 158, 15);
		add(lbEmail);
		
		JLabel lbPhone = new JLabel("Phone Number");
		lbPhone.setBounds(569, 229, 127, 15);
		add(lbPhone);
		
		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(737, 226, 219, 21);
		add(tfPhone);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(737, 201, 219, 21);
		add(tfEmail);
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(737, 176, 219, 21);
		add(tfUsername);
		
		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		tfLastName.setBounds(737, 151, 219, 21);
		add(tfLastName);
		
		tfFirstName = new JTextField();
		tfFirstName.setColumns(10);
		tfFirstName.setBounds(737, 126, 219, 21);
		add(tfFirstName);
		
		Choice choice = new Choice();
		choice.setFont(new Font("Source Sans Pro", Font.PLAIN, 16));
		choice.setBounds(569, 310, 158, 42);
		add(choice);
		
		Choice choiceYesorNo = new Choice();
		choiceYesorNo.setBounds(242, 176, 220, 21);
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
				tfPicture.setText(showedRecipe.getRecipePicture().getPath());
				tfFirstName.setText(showedChef.getFirstName());
				tfLastName.setText(showedChef.getLastName());
				tfUsername.setText(showedChef.getUserName());
				tfEmail.setText(showedChef.getEmail());
				tfPhone.setText(showedChef.getPhoneNumber());
			}
		});
		btnShow.setFont(new Font("Source Sans Pro", Font.PLAIN, 16));
		btnShow.setBounds(762, 299, 93, 42);
		add(btnShow);
		for (String u:usernames) {
			choice.add(u);
		}
		
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
		tfPicture.setText(recipe.getRecipePicture().getPath());
		tfFirstName.setText(chef.getFirstName());
		tfLastName.setText(chef.getLastName());
		tfUsername.setText(chef.getUserName());
		tfEmail.setText(chef.getEmail());
		tfPhone.setText(chef.getPhoneNumber());
		
	}
}
