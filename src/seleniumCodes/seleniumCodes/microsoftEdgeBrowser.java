package seleniumCodes;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;

public class microsoftEdgeBrowser {

    public static void main(String[] args) {
        // Set EdgeDriver path
        System.setProperty("webdriver.edge.driver", "C:/new2/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        try {
            // Open Google
            driver.get("http://www.rahulshettyacademy.com/");

            // Print the page title and URL
            System.out.println("Title: " + driver.getTitle());
            System.out.println("Current URL: " + driver.getCurrentUrl());
        } finally {
            // Close all browser windows and safely end the session
            driver.quit();
        }
    }
}
