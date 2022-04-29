package TestClass;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import Pages.LoginPage;
import Pages.RegistrationPage;
import Utility.ReadExcel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestUserRegisration {
	
	WebDriver driver ;
	
	LoginPage objLoginPage;
	RegistrationPage objRegPage;
	
	
	
	@BeforeTest
	public void setup() throws FileNotFoundException,IOException,InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		
		WebDriverManager.chromedriver().setup();
        ChromeOptions optons = new ChromeOptions();

        optons.addArguments("ignore-certificate-errors");

         driver = new ChromeDriver();
        driver.get(ReadExcel.readExcel(1,0, ".\\Data\\Book1.xlsx","Sheet1"));		
		
	}
	
	
	@Test(priority=0)
	public void test_Page_Title_Appear_Correctly() throws FileNotFoundException,IOException,InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException{
		
		objLoginPage = new LoginPage(driver);
		
		 objLoginPage.getPageTitle();
		 
		 //Navigate into Registration page
		 objLoginPage.clickRegisterButton();
		 
		 //Get registrationPage title
		 objRegPage = new RegistrationPage(driver);
		 objRegPage.getRegistrationPageTitle();
		 
		objRegPage.setUserTitle(ReadExcel.readExcel(1, 1, ".\\Data\\Book1.xlsx","Sheet1"));
		objRegPage.setUserFirstName(ReadExcel.readExcel(1, 2, ".\\Data\\Book1.xlsx","Sheet1"));
		objRegPage.setUserSurName(ReadExcel.readExcel(1, 3, ".\\Data\\Book1.xlsx","Sheet1"));
		objRegPage.setPhone(ReadExcel.readExcel(1, 4, ".\\Data\\Book1.xlsx","Sheet1"));
		objRegPage.setBirthYear(ReadExcel.readExcel(1, 5, ".\\Data\\Book1.xlsx","Sheet1"));
		objRegPage.setBirthMonth(ReadExcel.readExcel(1, 6, ".\\Data\\Book1.xlsx","Sheet1"));
		objRegPage.setBirthDate(ReadExcel.readExcel(1, 7, ".\\Data\\Book1.xlsx","Sheet1"));
		objRegPage.setLicenceType(ReadExcel.readExcel(1, 8, ".\\Data\\Book1.xlsx","Sheet1"));
		objRegPage.setLicencePeriod(ReadExcel.readExcel(1, 9, ".\\Data\\Book1.xlsx","Sheet1"));
		objRegPage.setOccupation(ReadExcel.readExcel(4, 0, ".\\Data\\Book1.xlsx","Sheet1"));
		objRegPage.setStreetAddress(ReadExcel.readExcel(4, 1, ".\\Data\\Book1.xlsx","Sheet1"));
		objRegPage.setCityAddress(ReadExcel.readExcel(4, 2, ".\\Data\\Book1.xlsx","Sheet1"));
		objRegPage.setCountryAddress(ReadExcel.readExcel(4, 3, ".\\Data\\Book1.xlsx","Sheet1"));
		objRegPage.setPostCode(ReadExcel.readExcel(4, 4, ".\\Data\\Book1.xlsx","Sheet1"));
		objRegPage.setEmail(ReadExcel.readExcel(4, 5, ".\\Data\\Book1.xlsx","Sheet1"));
		objRegPage.setPassword(ReadExcel.readExcel(4, 6, ".\\Data\\Book1.xlsx","Sheet1"));
		objRegPage.setConfirmPassword(ReadExcel.readExcel(4, 7, ".\\Data\\Book1.xlsx","Sheet1"));
		objRegPage.clickCreateButton();
		

	
	}
	
	
	  
	
	}


