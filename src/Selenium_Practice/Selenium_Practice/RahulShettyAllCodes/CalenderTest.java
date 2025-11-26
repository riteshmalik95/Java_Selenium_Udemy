package Selenium_Practice.RahulShettyAllCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

//By Rahul Shetty
public class CalenderTest {
    public static void main(String[] args) throws InterruptedException {
        String monthnumber = "6";
        String date = "15";
        String year = "2026";

        String[] expectedlist={monthnumber,date,year};
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div.react-date-picker__inputGroup")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='button' and @class='react-calendar__navigation__label']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='button' and @class='react-calendar__navigation__label']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
        Thread.sleep(3000);

        //If you find space in a class name then you can split it into two classes, and you can take one from them
        //as xpath and css selector during inspect the Web element.
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthnumber)-1).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
        Thread.sleep(3000);

        //Now we want to add assertions....
        List <WebElement> actualList=driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for(int i=0;i<actualList.size();i++){
            System.out.println(actualList.get(i).getAttribute("value"));
            Assert.assertEquals(actualList.get(i).getAttribute("value"),expectedlist[i]);
        }
        driver.close();
    }
}

