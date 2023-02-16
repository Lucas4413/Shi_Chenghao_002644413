package Model;

public class Business {
	private ApplicantsDirectory applicantsDirectory;
	private InsurancePlans insurancePlans;
	
	public Business() {
		this.applicantsDirectory = new ApplicantsDirectory();
		this.insurancePlans = new InsurancePlans();
	}
	
	public ApplicantsDirectory getApplicantsDirectory() {
		return applicantsDirectory;
	}
	public void setApplicantsDirectory(ApplicantsDirectory applicantsDirectory) {
		this.applicantsDirectory = applicantsDirectory;
	}
	public InsurancePlans getInsurancePlans() {
		return insurancePlans;
	}
	public void setInsurancePlans(InsurancePlans insurancePlans) {
		this.insurancePlans = insurancePlans;
	}
}
