package TestClasses;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Utility.JSONReader;
import bsh.ParseException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UserLogin {
	
	WebDriver driver ;
	LoginPage objLoginPage;
	
	@BeforeTest
	public void setup() throws FileNotFoundException,IOException,ParseException, org.json.simple.parser.ParseException{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(JSONReader.ReadJSONFile("URL","./Data/data.json"));
	}
	
	@Test()
	public void test_Login() throws FileNotFoundException,IOException,ParseException, org.json.simple.parser.ParseException {
		
		objLoginPage = new LoginPage(driver);
		
		
		//add user email
		objLoginPage.setEmail(JSONReader.ReadJSONFile("Email","./Data/data.json"));
		
		// add password 
		objLoginPage.setPassword(JSONReader.ReadJSONFile("Password", "./Data/data.json"));
		
		//Click login button
		objLoginPage.clickLoginButton();
		
		//validate page
		String loginUserName = objLoginPage.getloginUserName();
		Assert.assertTrue(loginUserName.toLowerCase().contains(JSONReader.ReadJSONFile("userConfirmationText", "./Data/data.json")));
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.close();
		driver.quit();
	}
	
}
