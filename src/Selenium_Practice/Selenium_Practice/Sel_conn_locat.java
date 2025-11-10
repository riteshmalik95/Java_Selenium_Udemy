package Selenium_Practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;




public class Sel_conn_locat {

	public static void main(String[] args) throws InterruptedException { 
//		System.setProperty("webdriver.chrome.driver", "C:/Users/user/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		// Open Google
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(10);
//		driver.findElement(By.xpath("//input[contains(@id,'name')]")).sendKeys("Ritesh");////input[contains(@id,'email')]
//		driver.findElement(By.xpath("//input[contains(@id,'email')]")).sendKeys("Ritesh@gmail.com");
//		// Print the page Title
//		String str = driver.getTitle();
//		System.out.println(str);
//		System.out.println(driver.getCurrentUrl());
//		
//		WebElement table=driver.findElement(By.xpath(str));
		WebElement elem=driver.findElement(By.id("country"));
		Select dropdown=new Select(elem);
		dropdown.selectByVisibleText("France");
		System.out.println("Country has been selected successfully");
		
		// Close the Browser
		driver.close();		
//		driver.quit();
	}

}

