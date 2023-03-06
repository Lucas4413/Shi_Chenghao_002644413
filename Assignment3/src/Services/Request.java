package Services;

import java.nio.file.SecureDirectoryStream;
import java.util.Date;

import Customer.Customer;
import Library.Book;
import Library.Magzine;


public class Request {
	private String ID;
	private String status;
	private String duration;
	private float price;
	private Book book;
	private Magzine magzine;
	private String branchName;
	private static int count = 0;
	
	public Request(String duration, float price, Book book, Magzine magzine, String bName) {
		this.count++;
		this.ID = this.count+"";
		this.status = "applying";
		this.duration = duration;
		this.price = price;
		this.book = book;
		this.magzine = magzine;
		this.branchName = bName;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Magzine getMagzine() {
		return magzine;
	}
	public void setMagzine(Magzine magzine) {
		this.magzine = magzine;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
}
