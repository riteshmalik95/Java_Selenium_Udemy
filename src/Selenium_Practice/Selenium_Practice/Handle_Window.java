package Selenium_Practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handle_Window {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String parentWinId = driver.getWindowHandle();
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> iterator = allWindows.iterator();

		while (iterator.hasNext()) {
			String childWinId = iterator.next();
			System.out.println(childWinId);
			if (!parentWinId.equals(childWinId)) {
				Thread.sleep(2000);
				driver.switchTo().window(childWinId);
				System.out.println("Switched to: " + driver.getTitle());
				driver.findElement(By.xpath("//button[contains(text(), 'Book a Free Demo')]")).click();
				driver.close();
			}
		}

		driver.switchTo().window(parentWinId);
		System.out.println("Back to: " + driver.getTitle());

		driver.quit();
	}
}
