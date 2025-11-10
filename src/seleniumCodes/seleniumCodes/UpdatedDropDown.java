package seleniumCodes;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropDown {
	
	public static void main(String[] args) throws InterruptedException {
		//Launching a Chrome Driver
		WebDriver driver=new ChromeDriver();
		//Navigating through URL
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//Put Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//Maximise the Window
		driver.manage().window().maximize();
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
//		int i=1;
//		while (i<5) {
//			driver.findElement(By.id("hrefIncAdt")).click();
//			i++;
//			System.out.println("Five adults are Selected");
//			Thread.sleep(1000);
//		}
		for(int i=1;i<5;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
			
			
			Thread.sleep(1000);
		}
		System.out.println("Five adults are Selected");
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println("Adults are Selected");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		
		
		
		Thread.sleep(2000);
		driver.quit();
	}
     
}
