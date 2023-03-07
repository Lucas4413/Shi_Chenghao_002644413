package Services;

import java.nio.file.SecureDirectoryStream;
import java.util.Date;

import Business.Account;
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
	private static int count = 0;
	private Account account;
	
	public Request(String duration, float price, Book book, Magzine magzine, Account account) {
		this.count++;
		this.ID = this.count+"";
		this.status = "applying";
		this.duration = duration;
		this.price = price;
		this.book = book;
		this.magzine = magzine;
		this.account = account;
	}
	
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Request.count = count;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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

	
}
