package myStore.UiPackages;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;



public class signInPage {
	WebDriver driver;

	public signInPage(WebDriver driver) {
		this.driver = driver;
		
	}
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Sign in')]")
	WebElement SignInBtn;
	
	@FindBy(how= How.ID, using= "email_create")
	WebElement createEmail;
	
	@FindBy(how = How.XPATH , using ="//form[@id='create-account_form']//span[1]")
	WebElement CreateAccBtn;
	
	@FindBy(how = How.ID , using ="id_gender2")
	WebElement Gender;
	
	@FindBy(how = How.ID , using ="customer_firstname")
	WebElement CustomerFirstName;
	
	@FindBy(how = How.ID , using ="customer_lastname")
	WebElement CustomerLasName;
	
	@FindBy(how = How.ID , using ="passwd")
	WebElement Password;
	
	@FindBy(how= How.ID, using = "days")
	WebElement date;
	
	@FindBy(how = How.ID, using = "firstname")
	WebElement AddFirstName;
	
	@FindBy(how = How.ID, using = "lastname")
	WebElement AddLastName;
	
	@FindBy(how = How.ID, using = "company")
	WebElement Company;
	
	@FindBy(how = How.ID, using = "address1")
	WebElement Address;
	
	@FindBy(how = How.ID, using = "city")
	WebElement City;
	
	@FindBy(how = How.ID, using = "id_state")
	WebElement State;
	
	@FindBy(how = How.ID, using = "postcode")
	WebElement PostalCode;
	
	@FindBy(how = How.ID, using = "id_country")
	WebElement Country;
	
	@FindBy(how = How.ID, using ="phone_mobile")
	WebElement MobileNum;
	
	@FindBy(how = How.ID, using= "alias")
	WebElement Alias;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Register')]" )
	WebElement Register;
	
	
	@Test
	public void signIn(String email, String firstName, String lastName, String pwd, 
			String addressFN,String addressLN, String companyField, String addressField,
			String cityField, String stateField, String postalField, String countryField, 
			String MobNo, String aliasField) {
		try {
			Thread.sleep(2000);
			SignInBtn.click();
			
			Thread.sleep(2000);
			createEmail.sendKeys(email);
			
			Thread.sleep(1000);
			CreateAccBtn.click();
			
			Thread.sleep(2000);
			Gender.click();
			
			Thread.sleep(2000);
			CustomerFirstName.sendKeys(firstName);
			
			Thread.sleep(2000);
			CustomerLasName.sendKeys(lastName);
			
			Thread.sleep(2000);
			Password.sendKeys(pwd);
			
			Thread.sleep(2000);
			//date.click();
			Select days = new Select(driver.findElement(By.id("days")));
			days.selectByValue("6");
			Select month = new Select(driver.findElement(By.id("months")));
			month.selectByValue("5");
			Select year= new Select(driver.findElement(By.id("years")));
			year.selectByValue("1994");
			Thread.sleep(2000);
			System.out.println("Your Address");
			
			AddFirstName.sendKeys(addressFN);
			
			Thread.sleep(1000);
			AddLastName.sendKeys(addressLN);
			
			Thread.sleep(1000);
			Company.sendKeys(companyField);
			
			Thread.sleep(1000);
			Address.sendKeys(addressField);
			
			Thread.sleep(1000);
			City.sendKeys(cityField);
			
			Thread.sleep(1000);
			State.sendKeys(stateField);
			
			Thread.sleep(1000);
			PostalCode.sendKeys(postalField);
			
			Thread.sleep(1000);
			Country.sendKeys(countryField);
			
			Thread.sleep(1000);
			MobileNum.sendKeys(MobNo);
			
			Thread.sleep(1000);
			Alias.sendKeys(aliasField);
			
			Thread.sleep(1000);
			Register.click();
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
