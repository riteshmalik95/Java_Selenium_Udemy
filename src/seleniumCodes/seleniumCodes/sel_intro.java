package seleniumCodes;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sel_intro {

	public static void main(String[] args) {
		// Invoking Browser
		// WebDriver Methods+Class Methods
//		ChromeDriver driver=new ChromeDriver();//only access class Methods 
		System.setProperty("webdriver.chrome.driver", "C:/Users/user/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// chromedriver.exe(third party library)--> invokes Chrome Browser
		// Steps to invoke Chrome Driver
		// Selenium Manager
		// Maximize Browser Window
		driver.manage().window().maximize();
		// Open Google
		driver.get("http://www.rahulshettyacademy.com/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Print the page Title
		String str = driver.getTitle();
		System.out.println(str);
		System.out.println(driver.getCurrentUrl());
		// Close the Browser
//		driver.close();		
		driver.quit();
	}

}
