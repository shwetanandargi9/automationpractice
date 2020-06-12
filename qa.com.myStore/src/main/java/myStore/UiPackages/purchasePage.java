package myStore.UiPackages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class purchasePage {
	WebDriver driver;

	public purchasePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='block_top_menu']//a[contains(text(),'Women')]")
	WebElement SelectTshirt;
	
	@FindBy(how=How.XPATH, using = "//body[@id='category']/div[@id='page']/div/div[@id='columns']/div/div[@id='center_column']/ul/li[4]/div[1]/div[1]/div[1]/a[1]")
	WebElement product;
	
	@FindBy(how= How.XPATH, using =" //a[2]//span[1]")
	WebElement qty;
	
	@FindBy(how= How.XPATH, using= "//span[contains(text(),'Add to cart')]")
	WebElement AddTOCart; 
	
	@FindBy(how=How.XPATH, using = "//span[contains(text(),'Proceed to checkout')]")
	WebElement ProceedToCheckout;
	
	@FindBy(how = How.XPATH, using = "//select[@id='id_address_delivery']")
	WebElement Delivery;
	
	@FindBy(how = How.XPATH, using="//input[@id='cgv']")
	WebElement CheckBox;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Pay by bank wire')]")
	WebElement payByBankwire;
	
	@FindBy(how =How.XPATH, using ="//span[contains(text(),'I confirm my order')]")
	WebElement ConfirmOrder;
	
	@FindBy(how= How.XPATH, using= "//body[@id='order-confirmation']/div[@id='page']/div/div[@id='columns']/div[1]")
	WebElement orderHistory;
	
	public void selectPage() {
		try {
			SelectTshirt.click();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement elt = driver.findElement(By.xpath(
					"//div[@id='center_column']//ul//li//div//div//a[contains(text()," + "'Printed Chiffon Dress')]"));
			js.executeScript("arguments[0].scrollIntoView(true);", elt);

			Thread.sleep(2000);
			WebElement elem = driver.findElement(By.xpath("//li[1]//div[1]//div[1]//div[1]//a[1]//img[1]"));
			js.executeScript("arguments[0].scrollIntoView(true);", elem);
			
			product.click();
			
			WebElement productSelect=driver.findElement(By.xpath("//h3[contains(text(),'Data sheet')]"));
			js.executeScript("arguments[0].scrollIntoView(true);", productSelect);
			qty.click();
			
			Thread.sleep(2000);
			AddTOCart.click();
			Thread.sleep(2000);
			String MainWindow=driver.getWindowHandle();		
    		
	        // To handle all new opened window.				
	            Set<String> s1=driver.getWindowHandles();		
	        Iterator<String> i1=s1.iterator();		
	        		
	        while(i1.hasNext())			
	        {		
	            String ChildWindow=i1.next();		
	            		
	            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
	            {    		
	                 
	                    // Switching to Child window
	                    driver.switchTo().window(ChildWindow);	                                                                                                           
	                            			
	                    
	                    driver.findElement(By.name("//div[@id='layer_cart']//div//div//div//img")).click();			
	                                 
				// Closing the Child Window.
	                        driver.close();		
	            }		
	        }		
	        // Switching to Parent window i.e Main Window.
	            driver.switchTo().window(MainWindow);				
	    		
			
			System.out.println("We are in AddTo Cart page");
			ProceedToCheckout.click();
			
						
			Thread.sleep(2000);
			System.out.println("In process");
			driver.findElement(By.xpath("//div[@id='center_column']//span[contains(text(),'Proceed to checkout')]")).click();
			Thread.sleep(2000);
			Delivery.click();
			
			Thread.sleep(2000);
			System.out.println("In Address");
			driver.findElement(By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")).click();
			System.out.println("Proceed to Checkout");
			
			Thread.sleep(1000);
			CheckBox.click();
			driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")).click();
			
			Thread.sleep(1000);
			WebElement Scroll = driver.findElement(By.xpath("//a[contains(text(),'Pay by bank wire')]"));
			js.executeScript("arguments[0].scrollIntoView(true);", Scroll);
			
			Thread.sleep(1000);
			payByBankwire.click();
			
			WebElement elemt= driver.findElement(By.xpath("//form//a[1]"));
			js.executeScript("arguments[0].scrollIntoView(true);", elemt);
			
			Thread.sleep(1000);
			ConfirmOrder.click();
			
			Thread.sleep(1000);
			WebElement et = driver.findElement(By.xpath("//a[contains(text(),'Back to orders')]"));
			js.executeScript("arguments[0].scrollIntoView(true);", et);
			
			Thread.sleep(1000);
			WebElement Ord = driver.findElement(By.xpath("//body[@id='order-confirmation']/div[@id='page']/div/div[@id='columns']/div[1]"));
			js.executeScript("arguments[0].scrollIntoView(true);", Ord);
			
			orderHistory.click();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
