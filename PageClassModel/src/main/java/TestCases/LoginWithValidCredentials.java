package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.HomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginWithValidCredentials {
	
	WebDriver driver;
	SoftAssert sa; 
    LoginPage objLoginPage;
    HomePage objHomePage;
    
   @BeforeTest
   
   public void setUp() {
	   WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	   sa = new SoftAssert();	   
   }
   
   @Test
   public void login() {
	   objLoginPage = new LoginPage(driver);
		objHomePage = new HomePage(driver);
		
		objLoginPage.navigateLoginPage();
		
		//Validate landing page
		sa.assertTrue(objLoginPage.getLoginPageTitle().toLowerCase().contains("Guru99 Bank"));
		
		//Login with credentials
		objLoginPage.login("mngr395343", "usavyrE");
		
		//verify home page
		sa.assertTrue(objHomePage.getHomePageUserID().toLowerCase().contains("Manger Id : mngr395343"));
			
	   
   }
    
}
