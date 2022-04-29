package TestClass;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegistrationPage;
import Utility.ReadExcel;
import bsh.ParseException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestUserLogin {
	
      WebDriver driver ;
	
	LoginPage objLoginPage;
	RegistrationPage objRegPage;
	HomePage objHomePage;
	
	@BeforeTest
	public void setup() throws FileNotFoundException,IOException,InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		
		WebDriverManager.chromedriver().setup();
        ChromeOptions optons = new ChromeOptions();

        optons.addArguments("ignore-certificate-errors");

         driver = new ChromeDriver();
        driver.get(ReadExcel.readExcel(1,0, ".\\Data\\Book1.xlsx","Sheet1"));		
		
	}
	
	@Test()
	public void test_Login() throws FileNotFoundException,IOException,ParseException,  org.apache.poi.openxml4j.exceptions.InvalidFormatException{
	
		objLoginPage = new LoginPage(driver);
		
		objLoginPage.setEmail(ReadExcel.readExcel(4,5, ".\\Data\\Book1.xlsx","Sheet1"));
		
		objLoginPage.setPassword(ReadExcel.readExcel(4, 6,".\\Data\\Book1.xlsx","Sheet1"));
		
		objLoginPage.clickLoginButton();
		
		// validate home page
		objHomePage = new HomePage(driver);
		String loginUserName = objHomePage.getPageTitle();
		Assert.assertTrue(loginUserName.toLowerCase().contains(ReadExcel.readExcel(4, 8,".\\Data\\Book1.xlsx","Sheet1")));
		
	}
	
	@AfterTest
	  public void tearDown() {
		    driver.close();
			driver.quit();
	  }
	  

}
