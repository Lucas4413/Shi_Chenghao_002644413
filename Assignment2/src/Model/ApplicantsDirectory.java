package Model;

import java.util.ArrayList;
import java.util.Date;

public class ApplicantsDirectory {
	private ArrayList<Applicant> applicants;

	public ApplicantsDirectory() {
		this.applicants = new ArrayList<Applicant>();
	}
	
	public ArrayList<Applicant> getApplicants() {
		return applicants;
	}

	public void setApplicants(ArrayList<Applicant> applicants) {
		this.applicants = applicants;
	}
	
	public void createApplicant(String id, String fn, String ln, String fullName, Date date, Pet pet) {
		Applicant applicant = new Applicant();
		applicant.setDate(date);
		applicant.setFirstName(fn);
		applicant.setLastName(ln);
		applicant.setFullName(fullName);
		applicant.setID(id);
		applicant.setPet(pet);
		this.applicants.add(applicant);
	}
	
	public Boolean isEmptyOrNull(String s) {
		if(s==null || s.length()==0) {
			return true;
		}
		return false;
	}
	
	public Boolean isInteger(String s) {
		try {
			Integer.valueOf(s);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public Applicant searchById(String s) {
		for(Applicant a:this.applicants) {
			if(a.getID().equals(s)) {
				return a;
			}
		}
		return null;
	}
	
	public void deleteApplicant(String id) {
		this.applicants.remove(this.searchById(id));
	}
	
	public void updateApplicant(Applicant applicant, String id, String fn, String ln, String fullName, Date date, String pName, 
			int pAge, String pGender, String pType, String pBreed) {
		applicant.setDate(date);
		applicant.setFirstName(fn);
		applicant.setLastName(ln);
		applicant.setFullName(fullName);
		applicant.setID(id);
		applicant.getPet().update(pName, pAge, pGender, pType, pBreed);
	}
	
	public void searchByName(ArrayList<Applicant> apps, String s){
		apps.removeAll(apps);
		for(Applicant a:this.applicants) {
			if(a.getFullName().contains(s)) {
				apps.add(a);
			}
		}
	}
}
