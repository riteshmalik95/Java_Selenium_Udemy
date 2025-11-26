package Selenium_Practice;
//Rahul Shetty
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestionAssignment {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        driver.manage().window().maximize();
        driver.findElement(By.id("autocomplete")).sendKeys("ind");
        Thread.sleep(3000);

        //For getting particular auto-suggestion then use Keys.DOWN
//        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
//        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
//        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));

        // Collect all autosuggestions
        List<WebElement> suggestions = driver.findElements(By.cssSelector("li.ui-menu-item div"));

        System.out.println("Total Suggestions: " + suggestions.size());
        System.out.println("Suggestions List:");

        // Print each suggestion text
        for (WebElement s : suggestions) {
            System.out.println(s.getText());


        }
        driver.quit();
    }
}