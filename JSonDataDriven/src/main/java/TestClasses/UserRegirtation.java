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
import Pages.RegistrationPage;
import Utility.JSONReader;
import bsh.ParseException;
import io.github.bonigarcia.wdm.WebDriverManager;


public class UserRegirtation {
	
WebDriver driver ;
LoginPage objLoginPage;
RegistrationPage objRegPage;



@BeforeTest
public void setup() throws FileNotFoundException,IOException,ParseException, org.json.simple.parser.ParseException{
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get(JSONReader.ReadJSONFile("URL","./Data/data.json"));
}




@Test(priority = 0)
public void test_Login_Page_Appear_Correct() throws FileNotFoundException,IOException,ParseException, org.json.simple.parser.ParseException {
	
  objLoginPage = new LoginPage(driver);
  
  
  String loginPageTitle = objLoginPage.getLoginTitle();
  Assert.assertTrue(loginPageTitle.toLowerCase().contains("login"));
  
  
  //Click on register button
  objLoginPage.clickRegisterButton();
  
  objRegPage = new RegistrationPage(driver);
  
  // \Fill the registration form
  objRegPage.selectUserTitle(JSONReader.ReadJSONFile("User_Title", "./Data/data.json"));
  
  objRegPage.setFirstName(JSONReader.ReadJSONFile("First_Name", "./Data/data.json"));
  objRegPage.setSurName(JSONReader.ReadJSONFile("Last_Name", "./Data/data.json"));
  objRegPage.setPhoneNum(JSONReader.ReadJSONFile("Phone_Number", "./Data/data.json"));
  objRegPage.setBirthdayYesr(JSONReader.ReadJSONFile("Birth_Year","./Data/data.json"));
  objRegPage.setBirthMonth(JSONReader.ReadJSONFile("Birth_Month","./Data/data.json"));
  objRegPage.setBirthDate(JSONReader.ReadJSONFile("Birth_Date","./Data/data.json"));
  objRegPage.setLicenceType(JSONReader.ReadJSONFile("Licence_Type","./Data/data.json"));
  objRegPage.setLicencePeriod(JSONReader.ReadJSONFile("Licence_Period","./Data/data.json"));
  objRegPage.setOccupation(JSONReader.ReadJSONFile("Occupation","./Data/data.json"));
  objRegPage.setStreetAddress(JSONReader.ReadJSONFile("Street_Add", "./Data/data.json"));
  objRegPage.setCityAddress(JSONReader.ReadJSONFile("City_Add", "./Data/data.json"));
  objRegPage.setCountryAddress(JSONReader.ReadJSONFile("Country_Add", "./Data/data.json"));
  objRegPage.setPostCode(JSONReader.ReadJSONFile("Post_Code", "./Data/data.json"));
  objRegPage.setEmail(JSONReader.ReadJSONFile("Email", "./Data/data.json"));
  objRegPage.setPassword(JSONReader.ReadJSONFile("Password", "./Data/data.json"));
  objRegPage.setConfirmPassword(JSONReader.ReadJSONFile("Confirm_Password", "./Data/data.json"));
  
  // click register button
  
  objRegPage.clickCreateButton();
  
  }
  
  @AfterTest
  public void tearDown() {
	    driver.close();
		driver.quit();
  }
  
}


