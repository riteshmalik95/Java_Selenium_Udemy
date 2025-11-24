package Selenium_Practice;
//By Rahul Shetty
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class JavaScriptExecutorDemo {
    public static <JavaScriptExecutor> void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=6000");
        Thread.sleep(3000);
        List<WebElement> listprice=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum=0;
        for (int i=0;i<listprice.size();i++){
            System.out.println(Integer.parseInt(listprice.get(i).getText()));
            sum=sum+Integer.parseInt(listprice.get(i).getText());

        }
        System.out.println("Total Amount Collected: "+sum);
        int actualAmount=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
        Assert.assertEquals(sum,actualAmount);
        driver.quit();
    }
}
