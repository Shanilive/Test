package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
WebDriver driver;
	
	By login_PageTitle = By.xpath("//div[@class='content']/h3");
	By button_Register = By.xpath("//div[@class='content']/a");
	By email = By.id("email");
	By password = By.id("password");
	By button_login = By.className("submit");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle() {
		return driver.findElement(login_PageTitle).getText();
		
	}

	public void clickRegisterButton() {
		driver.findElement(button_Register).click();
	}

}
