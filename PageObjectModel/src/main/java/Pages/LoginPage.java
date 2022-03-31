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
		this .driver = driver;
	}
	
	
	public void setUserName(String UserName)
	{
		
		driver.findElement(userName).sendKeys(UserName);
	}
	
	 public void setPassword(String setpassword) {
		 
		 driver.findElement(password).sendKeys(setpassword);
		
	}
	  
	 public void clickLoginButton() {
		 
		 driver.findElement(loginButton).click();
	 }
	 
	 public String getLoginTitle() {
		 
		 return driver.findElement(titleText).getText();
	 }
	 
	 public void loginToGuru99(String Username,String setpassword)
	 {
		 this.setUserName(Username);
		 this.setPassword(setpassword);
	 }
	 
}