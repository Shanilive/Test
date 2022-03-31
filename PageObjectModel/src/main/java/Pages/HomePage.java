package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage{
	
	WebDriver driver;
	
	By homePageUserName = By.xpath("//tr[@class='heading3']/td");
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	//Get the username from home page
	
	public String getHomePageUserID() {
		WebDriverWait wait = new WebDriverWait(driver , 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(homePageUserName));
		return driver.findElement(homePageUserName).getText();
	}
	
	
	
}

