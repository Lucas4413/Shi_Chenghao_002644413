package Model;

import java.io.File;

public class Recipe {
	private String title;
	private int NO_of_Serving;
	private Boolean isGlutenFree;
	private float difficulty;
	private int No_of_Ingredients;
	private String category;
	private String description;
	private File recipePicture;
	private Chef chef = new Chef();
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNO_of_Serving() {
		return NO_of_Serving;
	}
	public void setNO_of_Serving(int nO_of_Serving) {
		NO_of_Serving = nO_of_Serving;
	}
	public Boolean getIsGlutenFree() {
		return isGlutenFree;
	}
	public void setIsGlutenFree(Boolean isGlutenFree) {
		this.isGlutenFree = isGlutenFree;
	}
	public float getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(float difficulty) {
		this.difficulty = difficulty;
	}
	public int getNo_of_Ingredients() {
		return No_of_Ingredients;
	}
	public void setNo_of_Ingredients(int no_of_Ingredients) {
		No_of_Ingredients = no_of_Ingredients;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public File getRecipePicture() {
		return recipePicture;
	}
	public void setRecipePicture(File recipePicture) {
		this.recipePicture = recipePicture;
	}
	public Chef getChef() {
		return chef;
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
}
