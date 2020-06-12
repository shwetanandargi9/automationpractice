package myStore.FrameworkPackages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browserFactory {

	public static WebDriver driver;

	public browserFactory() {

	}

	public static WebDriver getDriver(String browserName) {
		System.out.println("in chrome");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sandeep Sagar\\Desktop\\java\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		return driver;

	}
}
