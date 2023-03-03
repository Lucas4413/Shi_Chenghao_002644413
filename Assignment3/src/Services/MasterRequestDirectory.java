package Services;

import java.util.ArrayList;

import Customer.Customer;
import Library.Book;
import Library.Librarian;

public class MasterRequestDirectory {
	private ArrayList<Request> orders;
	
	public MasterRequestDirectory() {
		this.orders = new ArrayList<Request>();
	}

	public ArrayList<Request> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Request> orders) {
		this.orders = orders;
	}
	
	public Request createOrder(Customer customer, Book book, String start, String end) {
		Request ord = new Request(customer, book,start,end);
		this.orders.add(ord);
		return ord;
	}
	
	public Request requestOrder(Customer customer) {
		Request order = new Request();
		order.setCustomer(customer);
		this.orders.add(order);
		return order;
	}
	public Request findById(String id) {
		for (Request o:this.orders) {
			if(o.getOrderId().equals(id)) {
				return o;
			}
		}
		return null;
	}
}
