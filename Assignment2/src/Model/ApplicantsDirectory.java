package Model;

import java.util.ArrayList;

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
	
	public void createApplicant(String id, String fn, String ln, String date) {
		Applicant applicant = new Applicant();
		applicant.setDate(date);
		applicant.setFirstName(fn);
		applicant.setLastName(ln);
		applicant.setID(id);
		this.applicants.add(applicant);
	}
}
