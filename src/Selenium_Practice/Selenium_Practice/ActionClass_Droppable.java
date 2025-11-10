package Selenium_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ActionClass_Droppable {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/selenium/practice/droppable.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement sorc=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dest=driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions acns=new Actions(driver);
		acns.dragAndDrop(sorc, dest).perform();
		String actualtext=driver.findElement(By.xpath("//div[@id='droppable']")).getText();
		System.out.println(actualtext);
		Assert.assertEquals(actualtext, "Dropped!");
        driver.quit();
	}

}
