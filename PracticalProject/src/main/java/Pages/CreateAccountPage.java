package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CreateAccountPage {
	
	WebDriver driver;
	
	By setTitle = By.id("uniform-id_gender2");
	By firstName = By.id("customer_firstname");
	By lastName = By.id("customer_lastname");
	By password = By.id("passwd");
	
	public CreateAccountPage(WebDriver driver) {
	this.driver = driver;
	}
	
	public void setFirstName(String strFirstName) {
		driver.findElement(firstName).sendKeys(strFirstName);
	}
	
	
	
}
