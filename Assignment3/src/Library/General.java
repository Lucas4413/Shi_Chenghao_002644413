package Library;

import java.util.ArrayList;
import java.util.Date;

public class General {
	private ArrayList<Magzine> magzines;
	
	public General() {
		this.magzines = new ArrayList<Magzine>();
	}

	public ArrayList<Magzine> getMagzines() {
		return magzines;
	}

	public void setMagzines(ArrayList<Magzine> magzines) {
		this.magzines = magzines;
	}
	
	public void createMagzine(String name, Float price, Date registerdDate, String company, String issueType) {
		Magzine mag = new Magzine();
		mag.setSerialNumber();
		mag.setName(name);
		mag.setPrice(price);
		mag.setRegisteredDate(registerdDate);
		mag.setCompany(company);
		mag.setIssueType(issueType);
		mag.setIsAvailable(true);
		this.magzines.add(mag);
	}
	
	public Magzine searchById(String id) {
		for (Magzine m:this.magzines) {
			if(m.getSerialNumber().equals(id)) {
				return m;
			}
		}
		return null;
	}
}
