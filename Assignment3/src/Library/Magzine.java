package Library;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Magzine extends Material{
	private String company;
	private String issueType;
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getIssueType() {
		return issueType;
	}
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	
	public String dateToString(Date registeredDate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		return simpleDateFormat.format(registeredDate);
	}
}
