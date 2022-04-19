package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
	
	WebDriver driver;
	
	By pageTitle = By.xpath("//div[@id='center_column']/h1");
	By emailAddress = By.id("email_create");
	By Button_Create = By.id("SubmitCreate");
	
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
    public String validateTitle() {
    	
    	return driver.findElement(pageTitle).getText();
    	
    }
    
    public void setEmail(String strEmail) {
    	driver.findElement(emailAddress).sendKeys(strEmail);
    }
    
    public void clickCreateButton() {
    	driver.findElement(Button_Create).click();
    }
}
