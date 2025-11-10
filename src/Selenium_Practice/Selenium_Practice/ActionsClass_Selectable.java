package Selenium_Practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClass_Selectable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.tutorialspoint.com/selenium/practice/selectable.php");

		List<WebElement> items = driver.findElements(By.xpath("//div[@id='nav-home']//li"));
		//div[@id='nav-home']//li
		System.out.println("Entering into list items");

		Actions actions = new Actions(driver);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		for (WebElement item : items) {
//			wait.until(ExpectedConditions.visibilityOf(item));
			System.out.println("Entering into for loop");
			actions.click(item).perform();

		}

	}

}
