package Selenium_Practice;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingFrames1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");

		// Get all frames
		List<WebElement> iframes = driver.findElements(By.xpath("//frame[contains(@src, 'frame')]"));
		System.out.println("Total frames: " + iframes.size());

		for (int i = 1; i <= iframes.size(); i++) {
			// Skip frame2
			if (i == 2) {
				System.out.println("Skip frame2");
				continue;
			}
			driver.switchTo().frame(i - 1); // switch into each frame
			driver.findElement(By.xpath("//input[@name='mytext" + i + "']")).sendKeys("Testing");
			driver.switchTo().defaultContent(); // go back to main page

			if (i == 3) { // frame3 has a nested iframe
				driver.switchTo().frame(i - 1); // switch into frame3
				WebElement innerFrame1 = driver.findElement(By.tagName("iframe"));
				driver.switchTo().frame(innerFrame1); // switch into nested iframe
//                driver.findElement(By.xpath("//a[text()='Switch accounts']")).click();
                
//                String parentWindow = driver.getWindowHandle();
//                Set<String> allWindows = driver.getWindowHandles();
//                for (String windowHandle : allWindows) {
//                    if (!windowHandle.equals(parentWindow)) {
//                        driver.switchTo().window(windowHandle);
//                        break;
//                    }
//                }
//                driver.close();
                // Switch back to parent window
//                driver.switchTo().window(parentWindow);
//                System.out.println("Back to parent window title: " + driver.getTitle());
				// Select all radio buttons
				List<WebElement> list = driver.findElements(By.xpath("//div[@role='radiogroup']//span[@dir='auto']"));
				for (WebElement element : list) {
					Thread.sleep(1000);
					System.out.println("Radio Button Text: " + element.getText());
					element.click();

				}
				WebElement textBox = driver.findElement(By.xpath("//input[@type='text' and @jsname='YPqjbf']"));
				textBox.sendKeys("I am Ritesh Malik");
				WebElement clearElement = driver.findElement(By.xpath("//span[text()='Clear selection']"));
				clearElement.click();

//				WebElement innerFrame2 = driver.findElement(By.tagName("iframe"));
//				driver.switchTo().frame(innerFrame2); // switch into nestediframe
				List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@class='Y6Myld']//span[@dir='auto']"));
				Thread.sleep(10000);
				for (WebElement checkbox : checkboxes) {
//					String label = checkbox.findElement(By.xpath("./ancestor::label/span")).getText();
					  if (checkbox.isSelected()==true) {
					        System.out.println("Checkbox is already selected");
					    } else {
					        checkbox.click();  // Selenium selects it
					        System.out.println("Checkbox is selected by selenium itself");
					    }
					Thread.sleep(1000);
					System.out.println("Checkbox text: " + checkbox.getText());
//					checkbox.click();
				}
				WebElement selectElement = driver.findElement(By.xpath("//span[text()='Choose']"));
				selectElement.click();
				Thread.sleep(1000);
//		doubt		WebElement selectElement1=driver.findElement(By.xpath("//div[@jsname='wQNmvb']//span[text()='Yes']"));
				WebElement selectElement1 = driver.findElement(By.xpath("//div[@role='option']//span[text()='Yes']"));
				selectElement1.click();
				Thread.sleep(3000);
				System.out.println("Option Yes is Selected");
				
				WebElement clearform = driver.findElement(By.xpath("//span[text()='Clear form']"));
				clearform.click();
				WebElement cancelBtnElement = driver.findElement(By.xpath("(//span[@class='l4V7wb Fxmcue']//span[text()='Cancel' and @class='NPEfkd RveJvd snByac'])[2]"));
				cancelBtnElement.click();
//				Alert aler=driver.switchTo().alert();
//				System.out.println(aler.getText());
//				aler.dismiss();
				Thread.sleep(4000);
                //span[@class='l4V7wb Fxmcue']//span[text()='Cancel' and @class='NPEfkd RveJvd snByac']
				
				WebElement nxtbuttonElement = driver.findElement(By.xpath("//span[text()='Next']"));
				nxtbuttonElement.click();
//                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//                WebElement enterElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Xb9hP']//input[@type='text' and @jsname='YPqjbf' ]")));
//                enterElement.sendKeys("My TestCase");
				Thread.sleep(3000);
				WebElement enterElement = driver
						.findElement(By.xpath("//div[@class='Xb9hP']//input[@type='text' and @jsname='YPqjbf' ]"));
				enterElement.sendKeys("My TestCase");

				WebElement enterElement2 = driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));
				enterElement2.sendKeys(
						"I want to learn Selenium with java very deeply which is going to help me crack interview");

				WebElement submitbutton = driver.findElement(By.xpath("// span[@class='l4V7wb Fxmcue']//span[text()='Submit']"));
				submitbutton.click();
				//// span[@class='l4V7wb Fxmcue']//span[text()='Submit']
				// textarea[@class='KHxj8b tL9Q4c']
				// input[@type='text' and @jsname='YPqjbf' ]
				//// div[@class='Jwjdfe']//span//span[text()='Clear selection']
				driver.switchTo().defaultContent(); // main page
			}
		}

		Thread.sleep(3000);
		driver.quit();
	}
}
