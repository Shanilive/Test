package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	
	By Home_Page_Title = By.xpath("//div[@class='content']/h4");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	

	public String getPageTitle() {
		return driver.findElement(Home_Page_Title).getText();
		
	}


}
