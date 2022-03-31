package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.HomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase {
	
	WebDriver driver;
	SoftAssert sa;
	LoginPage objLoginPage;
	HomePage objHomePage;
	

	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		sa = new SoftAssert();
				
	}
	
	@Test(priority=0)
	public void login() {
		//login in to site
		objLoginPage = new LoginPage(driver);
		objHomePage = new HomePage(driver);
		
		// Navigate to URL
		driver.get("https://demo.guru99.com/V4/index.php");
		
		//Validate landing page
		sa.assertTrue(objLoginPage.getLoginTitle().toLowerCase().contains("Guru99 Bank"));
		
		//Login with credentials
		objLoginPage.loginToGuru99("mngr395343", "usavyrE");
		objLoginPage.clickLoginButton();
		
		//verify home page
		sa.assertTrue(objHomePage.getHomePageUserID().toLowerCase().contains("Manger Id : mngr395343"));
			
	}
	
	@AfterTest
	public void TearDown()
	{
		sa.assertAll();
		driver.close();
		driver.quit();
	}
}
