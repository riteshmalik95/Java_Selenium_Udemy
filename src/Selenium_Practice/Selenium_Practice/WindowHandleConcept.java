package Selenium_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

// By Rahul Shetty
//Here what we are going to do- the task is that we will copy an
// email id from a parent window and paste it into the child window.
public class WindowHandleConcept {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.xpath("//a[@href='https://rahulshettyacademy.com/documents-request']")).click();
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> it=windows.iterator(); // [parentid,childid]
        String parentid=it.next();// Control will go to parentid
        String childid=it.next();// Now again control will go to childid
        System.out.println(parentid);
        System.out.println(childid);
        driver.switchTo().window(childid);
        //for css selectors if we have space in class name then we must replace it with dot(.)
        // for getting good css selectors as locator.
        String mytext=driver.findElement(By.cssSelector(".im-para.red")).getText();
        System.out.println(mytext);
        String emailid=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        System.out.println(emailid);
        driver.switchTo().window(parentid);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(emailid);
        Thread.sleep(3000);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.textToBePresentInElementValue(
//                By.xpath("//input[@name='username']"), emailid));          //DOUBT

        driver.quit();


    }
}
