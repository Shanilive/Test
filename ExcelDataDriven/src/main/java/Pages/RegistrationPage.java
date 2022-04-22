package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	
	WebDriver driver;
	
	By registrationPageTitle = By.xpath("//div[@class='content']/h1");
	By userTitle = By.id("user_title");
	By userFirstName = By.id("user_firstname");
	By userSurName = By.id("user_surname");
	By phone = By.id("user_phone");
	By birthYear = By.id("user_dateofbirth_1i");
	By birthMonth = By.id("user_dateofbirth_2i");
	By birthDate = By.id("user_dateofbirth_3i");
	By licenceType = By.id("licencetype_f");
	By licencePeriod = By.id("user_licenceperiod");
	By occupation = By.id("user_occupation_id");
    By street_Add = By.id("user_address_attributes_street");
    By city_Add = By.id("user_address_attributes_city");
    By country_Add = By.id("user_address_attributes_county");
    By postCode = By.id("user_address_attributes_postcode");
    By email = By.id("user_user_detail_attributes_email");
    By password = By.id("user_user_detail_attributes_password");
    By confirmPassword = By.id("user_user_detail_attributes_password_confirmation");
    By button_Create = By.name("submit");
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver ;
	}
	
	public String getRegistrationPageTitle() {
		
		return driver.findElement(registrationPageTitle).getText(); 
	}
	
	public void setUserTitle(String strUserTitle) {
		
		Select selectTitle = new Select( driver.findElement(userTitle));
    	selectTitle.selectByValue(strUserTitle);
	}
	
	public void setUserFirstName(String strFirstName) {
		
		driver.findElement(userFirstName).sendKeys(strFirstName);
	}
	
    public void setUserSurName(String strSurName) {
		
		driver.findElement(userSurName).sendKeys(strSurName);
	}

     public void setPhone(String strPhone) {
	
	driver.findElement(phone).sendKeys(strPhone);
}
	
     public void setBirthYear(String strBirthYear) {
 		
 		Select selectBirthYear = new Select( driver.findElement(birthYear));
 		selectBirthYear.selectByValue(strBirthYear);
 	}
     
     public void setBirthMonth(String strBirthMonth) {
  		
  		Select selectBirthMonth = new Select( driver.findElement(birthMonth));
  		selectBirthMonth.selectByVisibleText(strBirthMonth);
  	}
     
     public void setBirthDate(String strBirthDate) {
  		
  		Select selectBirthDate = new Select( driver.findElement(birthDate));
  		selectBirthDate.selectByValue(strBirthDate);
  	}
     
     public void setLicenceType(String strLicence) {
    		driver.findElement(licenceType).sendKeys(strLicence);
    	}
     
     public void setLicencePeriod(String strPeriod) {
    		Select selectPeriod = new Select(driver.findElement(licencePeriod));
    		selectPeriod.selectByVisibleText(strPeriod);
    	}
     
     public void setOccupation(String strOccupation) {
    		Select selectOccupation = new Select(driver.findElement(occupation));
    		selectOccupation.selectByVisibleText(strOccupation);
    	}

    	public  void setStreetAddress(String strSt_Add) {
    		driver.findElement(street_Add).sendKeys(strSt_Add);
    			
    	}

    	public  void setCityAddress(String strCity_Add) {
    		driver.findElement(city_Add).sendKeys(strCity_Add);
    			
    	}

    	public  void setCountryAddress(String strCountry_Add) {
    		driver.findElement(country_Add).sendKeys(strCountry_Add);
    			
    	}

    	public  void setPostCode(String strPostCode) {
    		driver.findElement(postCode).sendKeys(strPostCode);
    			
    	}
    	public  void setEmail(String strEmail) {
    		driver.findElement(email).sendKeys(strEmail);
    			
    	}
    	public  void setPassword(String strPassword) {
    		driver.findElement(password).sendKeys(strPassword);
    			
    	}

    	public  void setConfirmPassword(String strConPassword) {
    		driver.findElement(confirmPassword).sendKeys(strConPassword);
    			
    	}

    	public void clickCreateButton() {
    		driver.findElement(button_Create).click();
    	}

     

	
}
