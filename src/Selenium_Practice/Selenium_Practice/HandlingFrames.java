package Selenium_Practice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		List<WebElement> iframes=driver.findElements(By.xpath("//frame[contains(@src, 'frame')]"));
		System.out.println(iframes.size());
		for(int i=1; i<=iframes.size(); i++) {
			driver.switchTo().frame(i-1);
			driver.findElement(By.xpath("//input[@name='mytext"+i+"']")).sendKeys("Testing");
			driver.switchTo().defaultContent();
			if(i == 3) {
				driver.switchTo().frame(i);
				List<WebElement> list = driver.findElements(By.xpath("//div[@role='radiogroup']//span[@dir='auto']"));
				for(WebElement element : list) {
					element.click();
				}
			}
		}
		
		
	}

}