package Selenium_Practice;
//By Rahul Shetty
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsClassDemo {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        Actions a = new Actions(driver);

        WebElement move = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));

        // Hover on the element
        a.moveToElement(move).contextClick().build().perform();

        // Wait for dropdown to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='Your Account']")));

        // Wait until search box is clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));

        // Type "HELLO" (SHIFT + hello)
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        a.moveToElement(searchBox)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("hello")
                .doubleClick()
                .keyUp(Keys.SHIFT)
                .perform();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//div[@id='sac-suggestion-row-2'])")));

        // Now i want to select whole text "HELLO" with the help of Automation Script.
        //then i will just use double click() method.

        // Drag and Drop Concept , Rahul Shetty will explain in Frames......


        driver.quit();
    }
}
