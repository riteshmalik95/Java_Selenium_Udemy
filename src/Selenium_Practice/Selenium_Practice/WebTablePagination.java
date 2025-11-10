package Selenium_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WebTablePagination {

    public static void main(String[] args) throws IOException, InterruptedException {
        
    	System.setProperty("webdriver.chrome.driver", "C:/Users/user/Downloads/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        // Log file
        BufferedWriter writer = new BufferedWriter(new FileWriter("table_data.log"));

        // Count pagination pages
        List<WebElement> pages = driver.findElements(By.xpath("//div[@id='pagination']//a | //div[@id='pagination']//button"));
        int totalPages = pages.size();
        System.out.println("Total Pages: " + totalPages);

        for (int p = 1; p <= totalPages; p++) {
            // Click on each page number
            driver.findElement(By.xpath("//a[text()='" + p + "'] | //button[text()='" + p + "']")).click();
            Thread.sleep(2000); // wait for page load (better use explicit wait)

            // Capture table rows
            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='productTable']//tbody/tr"));

            for (WebElement row : rows) {
                String rowData = row.getText();
                System.out.println(rowData); // print on console
                writer.write(rowData);
                writer.newLine();
            }
        }

        writer.close();
        driver.quit();
    }
}
