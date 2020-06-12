package myStore.TestPackages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import myStore.UiPackages.loginPage;
import myStore.UiPackages.purchasePage;
import myStore.UiPackages.signInPage;

public class testClass extends helperClass {
	
	@Test
	public void myStore() {
		this.signInUser();
		this.placeOrder();
	}
	
	public void signInUser() {
		try {
			System.out.println("In Home Page...");

			driver.get("http://automationpractice.com/index.php");
			signInPage signInPage = PageFactory.initElements(driver, signInPage.class);
			signInPage.signIn("shwetanandargi@gmail.com", "Shweta", "N", "Shwet@", "Shweta", "N", "Ecommerce",
					"#403 Building B1,LA", "LA", "US", "00012", "United States", "8050479605", "Wilson Road");

			driver.findElement(By.xpath("//header[@id='header']//div//div//div//nav//div//a[contains(text(),'Sign out')]")).click();
			System.out.println("We are in SignIn page.......");
			Thread.sleep(2000);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void placeOrder() {
		try {
			System.out.println("In Home Page...");
			
			//driver.get("http://automationpractice.com/index.php");
			
			loginPage loginPage = PageFactory.initElements(driver, loginPage.class);
			loginPage.login("shwetanandargi91@gmail.com","Shwet@");
			
			Actions act = new Actions(driver);
			WebElement ViewOption = driver.findElement(By.xpath("//div[@id='block_top_menu']//a[contains(text(),'Women')]"));
			act.moveToElement(ViewOption).perform();
			
			purchasePage selectPage = PageFactory.initElements(driver, purchasePage.class);
			selectPage.selectPage();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
