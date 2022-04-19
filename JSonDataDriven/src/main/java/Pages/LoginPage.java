package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	By RegirsterButton = By.xpath("//div[@class='content']/a");
	By loginPageTitle = By.xpath("//div[@class='content']/h3");
	By email = By.id("email");
	By password = By.id("password");
	By Login_Button = By.name("submit");
	By loginUserName = By.xpath("//div[@class='content']/h4");

	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//Get login page title
	public String getLoginTitle() {
		
		return driver.findElement(loginPageTitle).getText();
	}
	
	
	

	// Navigate to Register page by clicking on register button
	public void clickRegisterButton() {
		driver.findElement(RegirsterButton).click();
	}

	
	public void setEmail(String strEmail) {
		driver.findElement(email).sendKeys(strEmail);
	}
	
	public void setPassword(String strPassword) {
		driver.findElement(password).sendKeys(strPassword);
	}
	
	public void clickLoginButton() {
		driver.findElement(Login_Button).click();
	}
	
	// get LandingPage title
	public String getloginUserName() {
		return driver.findElement(loginUserName).getText();
	}
}
