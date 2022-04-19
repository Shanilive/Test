package TestCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import Pages.CreateAccountPage;
import Pages.HomePage;
import Pages.SignInPage;
import Utility.ReadExcel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestUserCanCreateAccount {
	
	WebDriver driver;
	HomePage  objHomePage;
	SignInPage objSignInPage;
	CreateAccountPage objCreateAccount;
	
	@BeforeTest
	public void setup() throws FileNotFoundException,IOException,InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException{
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("ignore-certificate-errors");
		
		driver = new ChromeDriver();
		driver.get(ReadExcel.readExcel(1,0, ".\\Data\\Data.xlsx", "Sheet1"));
	}
	
    @Test
    public void CreateUserAccount() throws FileNotFoundException,IOException,InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
    	
    	objHomePage = new HomePage(driver);
    	
    	objHomePage.clickSiginInButton();
    	
    	//validate title
    	
    	objSignInPage = new SignInPage(driver);
    	String loginPageTitle = objSignInPage.validateTitle();
		Assert.assertTrue(loginPageTitle.toLowerCase().contains("authentication"));
		
		//add email_address
		objSignInPage.setEmail(ReadExcel.readExcel(1, 1, ".\\Data\\Data.xlsx", "Sheet1"));
		
		// Click on Create_Button
		objSignInPage.clickCreateButton();
		
		//fill_User_Register_Form
		objCreateAccount = new CreateAccountPage(driver);
		
		objCreateAccount.setFirstName(ReadExcel.readExcel(1, 2, ".\\Data\\Data.xlsx", "Sheet1"));
		
    }
}
