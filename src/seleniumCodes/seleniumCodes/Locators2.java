package seleniumCodes;

import java.time.Duration;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// Launch Chrome Browser
		String name="Ritesh";
		System.setProperty("webdriver.chrome.driver", "C:/Users/user/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		System.setProperty("webdriver.edge.driver", "C:/new2/msedgedriver.exe");
//        WebDriver driver = new EdgeDriver();
		String password=getPassword(driver);
		System.out.println(password);
//		Implicit Wait-
//      It is globally applicable for each and every step
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		// Open Google
		driver.get("http://www.rahulshettyacademy.com/");
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("submit")).click();
		
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		//ParentTagName ChildTagName      used as CSS here
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello " +name+ ",");
//		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		driver.close();
	}

	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		Thread.sleep(1000);
		String passwordText=driver.findElement(By.cssSelector("form p")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.
		String[] passwordArray=passwordText.split("'");
		//0th Index-Please use temporary password
		//1st Index-rahulshettyacademy' to Login.
		String pass=passwordArray[1].split("'")[0];
		return pass;
	}
}
