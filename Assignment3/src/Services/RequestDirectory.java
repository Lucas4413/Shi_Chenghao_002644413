package Services;

import java.util.ArrayList;

import Business.Account;
import Customer.Customer;
import Library.Book;
import Library.Magzine;

public class RequestDirectory {
	private ArrayList<Request> orders;
	
	public RequestDirectory() {
		this.orders = new ArrayList<Request>();
	}

	public ArrayList<Request> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Request> orders) {
		this.orders = orders;
	}
	
	public Request createOrder(String duration, float price, Book book, Magzine magzine, Account account) {
		Request ord = new Request(duration, price, book, magzine, account);
		this.orders.add(ord);
		return ord;
	}

	public Request findById(String id) {
		for (Request o:this.orders) {
			if(o.getID().equals(id)) {
				return o;
			}
		}
		return null;
	}
}
