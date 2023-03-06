package Customer;

import java.util.ArrayList;

import Personnel.Person;
import Services.RequestDirectory;
import Services.Request;

public class Customer extends Person{
	private int requestsInTotal;
	private RequestDirectory requestDirectory;
	
	public Customer() {
		super();
		this.requestDirectory = new RequestDirectory();
	}

	public int getOrdersTotal() {
		return requestsInTotal;
	}

	public void setOrdersTotal(int ordersTotal) {
		this.requestsInTotal = ordersTotal;
	}

	public RequestDirectory getCustomerOrderList() {
		return requestDirectory;
	}

	public void setCustomerOrderList(RequestDirectory requestDirectory) {
		this.requestDirectory = requestDirectory;
	}
	
}
