package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	
	By Home_Page_Title = By.xpath("//div[@class='content']/h4");
	
	 // this page verified after login into the system by using registered US and PW
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	

	public String getPageTitle() {
		return driver.findElement(Home_Page_Title).getText();
		
	}


}
