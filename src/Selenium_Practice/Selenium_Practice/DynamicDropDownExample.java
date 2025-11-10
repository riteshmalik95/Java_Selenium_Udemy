package Selenium_Practice;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class DynamicDropDownExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        // Type text into the search box
        driver.findElement(By.name("q")).sendKeys("selenium");

        // Wait a bit for suggestions to load
        Thread.sleep(2000);

        // Capture all suggestions in the dynamic dropdown
        List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@role='listbox']//li//span"));

        System.out.println("Number of suggestions: " + suggestions.size());

        // Loop through suggestions and click a specific one
        for (WebElement option : suggestions) {
            String text = option.getText();
            System.out.println(text);

            if (text.equalsIgnoreCase("selenium webdriver")) {
                option.click();   // Click desired suggestion
                break;
            }
        }

        driver.quit();
    }
}
