package Selenium_Practice;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class Checkboxes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		Thread.sleep(5000);
		//Select single checkbox
		
		//WebElement checkBox=driver.findElement(By.xpath("//input[@value='wednesday']"));
		//checkBox.click();

		//Select multiple checkbox
		
		List<WebElement> checkBoxes=driver.findElements(By.xpath("//input[@type='checkbox' and @class='form-check-input']"));
		
		for(WebElement checkbox:checkBoxes) {
			
			
			String str=checkbox.getAttribute("value");
			//Here we will use OR operator becoz we have to choose one condition from both the conditions
//			if (str.equalsIgnoreCase("tuesday") && str.equalsIgnoreCase("wednesday") )
				
			if (str.equalsIgnoreCase("monday") || str.equalsIgnoreCase("wednesday") ) {
//				System.out.println("Skip Checkbx:"+str);
				continue;//for skipping steps
			}
			
			checkbox.click();
			if(checkbox.isSelected()==true) {
				System.out.println("Check is selected");
			}else {
				System.out.println("Checkbox is not selected");
			}
			
		}
	}

}