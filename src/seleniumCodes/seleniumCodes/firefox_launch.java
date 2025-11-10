package seleniumCodes;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;

public class firefox_launch {

	public static void main(String[] args) {
		// Firefox Launch
         
		System.setProperty("webdriver.gecko.driver", "C:/Myfolder/geckodriver");
		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
		// Open Google
		driver.get("http://www.rahulshettyacademy.com/");
		
		// Print the page Title
		String str = driver.getTitle();
		System.out.println(str);
		System.out.println(driver.getCurrentUrl());
		// Close the Browser
//		driver.close();		
		driver.quit();
	}

}
