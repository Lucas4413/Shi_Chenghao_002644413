package Library;

import java.util.ArrayList;

import Personnel.Person;
import Services.Request;

public class Librarian extends Person{
	private int requestCount;
	
	private ArrayList<Request> agentRequestList;
	
	public Librarian() {
		super();
		this.agentRequestList = new ArrayList<Request>();
		
	}

	public int getOrderCount() {
		return requestCount;
	}

	public void setOrderCount(int orderCount) {
		this.requestCount = orderCount;
	}

	public ArrayList<Request> getAgentOrderList() {
		return agentRequestList;
	}

	public void setAgentOrderList(ArrayList<Request> agentOrderList) {
		this.agentRequestList = agentOrderList;
	}
	
	
}
