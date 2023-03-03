package Customer;

import java.util.ArrayList;

import Personnel.Person;
import Services.Request;

public class Customer extends Person{
	private int requestsInTotal;
	private ArrayList<Request> customerRequestList;
	
	public Customer() {
		super();
		this.customerRequestList = new ArrayList<Request>();
	}

	public int getOrdersTotal() {
		return requestsInTotal;
	}

	public void setOrdersTotal(int ordersTotal) {
		this.requestsInTotal = ordersTotal;
	}

	public ArrayList<Request> getCustomerOrderList() {
		return customerRequestList;
	}

	public void setCustomerOrderList(ArrayList<Request> customerOrderList) {
		this.customerRequestList = customerOrderList;
	}
	
	public void addOrder(Request order) {
		this.customerRequestList.add(order);
	}
}
