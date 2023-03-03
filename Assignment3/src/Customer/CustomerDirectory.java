package Customer;

import java.util.ArrayList;

import Library.Librarian;

public class CustomerDirectory {
	private ArrayList<Customer> customers;
	
	public CustomerDirectory() {
		this.customers = new ArrayList<Customer>();
		
	}
	
	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public Customer findById(String id) {
		for (Customer c:this.customers) {
			if(c.getPersonID().equals(id)) {
				return c;
			}
		}
		return null;
	}

	public void createCustomer(String id, String name,String age) {
		Customer customer = new Customer();
		customer.setAge(age);
		customer.setName(name);
		customer.setPersonID(id);
		this.customers.add(customer);
	}
}

