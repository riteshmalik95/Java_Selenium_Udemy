package Selenium_Practice;
//By Rahul Shetty
//Limiting WebDriver Scope
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DriverScope {
    public static void main(String[] args) throws InterruptedException {
        // Give me the count of the Links on this Webpage
        //If you have a link on the Webpage then Link should have a tag with name //a

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());

        //Give the counts of the Links which are present in the Footer Section of the Webpage.
        //right now,Global driver of objects is available for the entire page so we have to minimise
        //the scope for the Footer Section.
        //so how to create SubDriver or Subset of Driver to only limit the scope of the Global WebDriver
        //for a particular section....

        WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
        //This footerdriver or mini driver will play the role of actual driver for this subsection

        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        //Now I want to get the counts of the Links of the First Column of this Section.
        //I have to create again a new driver is columndriver

        WebElement columndriver = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

        List<WebElement> links = columndriver.findElements(By.tagName("a"));
        System.out.println(links.size());

        //Click on each link in the column and check if the pages are opening...
        for (int i = 1; i < links.size(); i++) {

            //Open the Links into separate tabs and also grab the titles of all child windows

            String clickOnLinktab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            links.get(i).sendKeys(clickOnLinktab);
            Thread.sleep(5000);

        }

        //Navigate to Each Tabs
        Set<String> abc = driver.getWindowHandles();//4
        Iterator<String> it = abc.iterator();    //iterator will help move from one tab to another tab.

        //hasNext() tells us whether next index is present or not.
        while (it.hasNext()) {
            Thread.sleep(3000);
            driver.switchTo().window(it.next());//actually move to next index.
            System.out.println(driver.getTitle());
        }
        driver.quit();
    }

}
