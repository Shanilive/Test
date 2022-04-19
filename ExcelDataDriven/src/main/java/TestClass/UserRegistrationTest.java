package TestClass;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import Pages.LoginPage;
import Utility.ReadExcel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UserRegistrationTest {
	
	WebDriver driver ;
	
	LoginPage objLoginPage;
	
	
	
	@BeforeTest
	public void setup() throws FileNotFoundException,IOException,InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		
		WebDriverManager.chromedriver().setup();
        ChromeOptions optons = new ChromeOptions();

        optons.addArguments("ignore-certificate-errors");

         driver = new ChromeDriver();
        driver.get(ReadExcel.readExcel(1,0, ".\\Data\\Book1.xlsx","Sheet1"));		
		
	}
	
	
	@Test(priority=0)
	public void test_Page_Title_Appear_Correctly() throws FileNotFoundException,IOException,InvalidFormatException{
		
		objLoginPage = new LoginPage(driver);
		
		 objLoginPage.getPageTitle();
	}
	
	
	}


