package myStore.UiPackages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class loginPage {

	WebDriver driver;

	public loginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how= How.ID, using = "email")
	WebElement Username;
	
	@FindBy(how = How.ID, using = "passwd")
	WebElement Password;
	
	@FindBy(how= How.XPATH, using = "//div[@id='columns']//p//span[1]")
	WebElement Submit;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Sign in')]")
	WebElement SignInBtn;
	
	public void login(String Usr, String Pass) {
		try {
			SignInBtn.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath("//h4[contains(text(),'Follow us')]"));
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			
			Username.sendKeys(Usr);
			Thread.sleep(3000);
			Password.sendKeys(Pass);
			Thread.sleep(3000);
			Submit.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
