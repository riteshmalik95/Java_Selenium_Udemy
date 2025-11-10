package Selenium_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass_Resizable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement frameElement=driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver.switchTo().frame(frameElement);
		WebElement resize=driver.findElement(By.cssSelector("//*[@id=\"resizable\"]/div[3]"));
		Actions act=new Actions(driver);
		Thread.sleep(2000);
		act.clickAndHold(resize).moveByOffset(80, 100).release().perform();
//		act.dragAndDropBy(resize, 150, 100).perform();
		Thread.sleep(2000);
		driver.quit();

	}

}
