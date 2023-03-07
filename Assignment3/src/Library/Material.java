package Library;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Material {
	private String name;
	private Date registeredDate;
	private Boolean isAvailable;
	private String serialNumber;
	private static int count=0;
	private float price;
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Material.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber() {
		this.count++;
		this.serialNumber = this.count + "";
	}
}
