package seleniumCodes;
import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Locators3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/user/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Siblings-Parent to child Traverse
		//header/div/button[1]/following-sibling::button[1]
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		//Another way of traversing same as above
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
		//Siblings-Child to Parent  Traverse
		//--//header/div/button[1]/parent::div
		//header/div/button[1]/parent::div/parent::header
		//header/div/button[1]/parent::div/parent::header/a
		
	}

}
