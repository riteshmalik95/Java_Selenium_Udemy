package Selenium_Practice;
//By Rahul Shetty
//If you want to learn more about frames then refer HandlingFrames1 class in the same package.
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
//Frames are a component which are hosted on webpages so basically it is a container
//that is independent of HTML Code and Frame is some HTML Code.....but it is separately prepared
//and host it on the Webpage.So Selenium cannot directly locate elements inside the frame until
//you explicitly switch the WebDriver’s context to that frame.hence you need to tell to the Selenium
//Hey! it's a frame

public class FrameTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //If we have more than one frame on a webpage like 3 Frames then We can switch in different frames
        //by using index-frame(0),second frame-frame(1) and so on.......
//        driver.switchTo().frame(0);
        //There are three switch statements below: All are same.......
//        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        // cssSelector-   tagName.className
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
        //driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
//        driver.findElement(By.id("draggable")).click();
        Actions a=new Actions(driver);
        Thread.sleep(2000);
        WebElement source=driver.findElement(By.id("draggable"));
        Thread.sleep(2000);
        WebElement target=driver.findElement(By.id("droppable"));
        a.dragAndDrop(source,target).build().perform();


        driver.quit();
    }
}
//In the context of a web browser, a frame is a part of a web page or browser window which displays content
//independent of its container, with the ability to load content independently. The HTML or media elements
//that go in a frame may or may not come from the same web siteras the other elements of content on display.