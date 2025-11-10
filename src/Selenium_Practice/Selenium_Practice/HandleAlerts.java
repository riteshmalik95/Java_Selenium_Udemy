package Selenium_Practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		//Case01
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Alert myAlert=driver.switchTo().alert();
		System.out.println(myAlert.getText());
		myAlert.accept();
		Thread.sleep(4000);
		
		//Case02
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Alert myAlert1=driver.switchTo().alert();
		System.out.println(myAlert.getText());
		myAlert.dismiss();
		Thread.sleep(4000);
		//Case03
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Alert myAlert2=driver.switchTo().alert();
		System.out.println(myAlert2.getText());
		Thread.sleep(4000);
		myAlert2.sendKeys("I am a Prompt Alert");
	   
        boolean bt = myAlert2.getText().equals(myAlert1.getText());//Giving true value why?
        System.out.println("Are Case02 and Case03 alert texts equal? " + bt);
		myAlert2.accept();


		
 

	}

}
