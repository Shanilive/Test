package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	
	By Button_SignIn = By.xpath("//div[@class='header_user_info']/a");
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSiginInButton() {
		driver.findElement(Button_SignIn).click();
	}
}
