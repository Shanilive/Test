package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	
	By userName = By.name("uid");
	By password = By.name("password");
	By loginButton = By.name("btnLogin");
	By titleText = By.className("barone");
	
	
	public LoginPage(WebDriver driver) {
		this.driver =driver;
	}
	
	public void navigateLoginPage() {
		driver.get("https://demo.guru99.com/V4/");
	}
	
	public void setUserName(String strUserName) {
		driver.findElement(userName).sendKeys(strUserName);
	}

	public void setPassword(String strPassword) {
		driver.findElement(password).sendKeys(strPassword);
	}
	
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public String getLoginPageTitle() {
		 
		 return driver.findElement(titleText).getText();
	 }
	
	public void login(String userName, String password) {
		this.setUserName(userName);
		this.setPassword(password);
		this.clickLoginButton();
	}
	
}
