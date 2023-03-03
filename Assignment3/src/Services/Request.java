package Services;

import java.util.Date;

import Customer.Customer;
import Library.Book;
import Library.Librarian;

public class Request {
	Customer customer;
	private static int count = 0;
	String requestId;
	String status;
	float price;
	Book book;
	String startDate;
	String endDate;
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
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

	public Request() {
		this.customer = new Customer();
		this.status = "Created";
		this.count++;
		
		this.requestId = "REQUEST"+this.count;
	}
	
	public Request(Customer customer, Book book, String s, String e) {
		this.customer = customer;
		this.book = book;
		this.status = "Created";
		this.count++;
		this.price = book.getPrice();
		this.requestId = "REQUEST"+this.count;
		this.startDate = s;
		this.endDate = e;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Request.count = count;
	}

	public String getOrderId() {
		return requestId;
	}

	public void setOrderId(String orderId) {
		this.requestId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return this.requestId;
	}
}
