package SelPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	WebDriver driver;
	SoftAssert sa;
	

@BeforeTest
public void setup() 
{
	WebDriverManager.chromedriver().setup();
	sa = new SoftAssert();
	driver = new ChromeDriver();
	
	
		
}

@Test
public void LoginTests()
{
	driver.get("https://demo.guru99.com/insurance/v1/index.php");
	driver.findElement(By.xpath("//div[@class='content']/a")).click();
	sa.assertEquals(driver.findElement(By.xpath("//div[@class='content']/h1")).getText(),"Sign up as a new user");
	WebElement T = driver.findElement(By.id("user_title"));
	Select getTitle = new Select(T);
	getTitle.selectByVisibleText("Miss");
	driver.findElement(By.id("user_firstname")).sendKeys("Shani");
	driver.findElement(By.id("user_surname")).sendKeys("Hettiarachchi");
	driver.findElement(By.id("user_phone")).sendKeys("0718400116");
	driver.findElement(By.id("user_dateofbirth_1i")).sendKeys("1990");
	driver.findElement(By.name("month")).sendKeys("May");
	driver.findElement(By.name("date")).sendKeys("3");
	driver.findElement(By.id("licencetype_t")).click();
	WebElement LP = driver.findElement(By.id("user_licenceperiod"));
	Select Lperiod = new Select(LP);
	Lperiod.selectByVisibleText("5");
	WebElement Occu = driver.findElement(By.id("user_occupation_id"));
	Select Occupation = new Select(Occu);
	Occupation.selectByVisibleText("Engineer");
	driver.findElement(By.id("user_address_attributes_street")).sendKeys("Thumbowila");
	driver.findElement(By.id("user_address_attributes_city")).sendKeys("Piliyandala");
	driver.findElement(By.id("user_address_attributes_county")).sendKeys("Sri Lanka");
	driver.findElement(By.id("user_address_attributes_postcode")).sendKeys("7500");
	driver.findElement(By.id("user_user_detail_attributes_email")).sendKeys("hettiarachchism@gmail.com");
	driver.findElement(By.id("user_user_detail_attributes_password")).sendKeys("Shani@1234");
	driver.findElement(By.id("user_user_detail_attributes_password_confirmation")).sendKeys("Shani@1234");
	driver.findElement(By.name("submit")).click();
	driver.findElement(By.id("email")).sendKeys("hettiarachchism@gmail.com");
	driver.findElement(By.id("password")).sendKeys("Shani@1234");
	driver.findElement(By.name("submit")).click();
	sa.assertEquals(driver.findElement(By.xpath("//div[@id='tabs-1']/h2")).getText(),"Broker Insurance WebPage");
	
		
}

@AfterTest
public void TearDown()
{
	sa.assertAll();
	
	driver.close();
	driver.quit();
}


}
