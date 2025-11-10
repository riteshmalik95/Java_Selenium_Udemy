package Selenium_Practice;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class DropDowns {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement elem=driver.findElement(By.id("country"));
//		WebElement elem=driver.findElement(By.xpath("//select[@id='country']"));
		Select dropdown=new Select(elem);
		dropdown.selectByVisibleText("China");
	    System.out.println("Drop Down has been selected successfully");
	    

	}

}
