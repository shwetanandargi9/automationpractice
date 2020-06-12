package myStore.TestPackages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import myStore.FrameworkPackages.browserFactory;

public class helperClass {
	public static WebDriver driver;
	browserFactory obj1;
	 
	public  helperClass(){
	}
	 
	@BeforeSuite
	public void beforeSuite(){
	 
	}
	 
	@BeforeClass
	public void beforeClass(){
	System.out.println("in @BeforeClass");
	}
	 
	@BeforeMethod
	public void beforeMethodClass(){
	System.out.println("in @BeforeMethod");
		helperClass.driver = browserFactory.getDriver("Chrome");
	 
	}
	 
	@AfterMethod
	public void close()
	{
	this.driver.close();
	}
	 
	@AfterClass
	public void afterClass(){
	 
	}
	 
	@AfterSuite
	public void afterSuite() throws IOException{
	 
	driver.quit();
	}
	
}
