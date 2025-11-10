package LEARNTESTNG.TestNG_Basics;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;

public class TG_Basics {
	WebDriver driver;

	@Test
	void A() {
		System.out.println("Print Test Method A");
	}

	@Test
	void B() {
		System.out.println("Print Test Method B");
	}

	@Test
	void C() {
		System.out.println("Print Test Method C");
	}

	@BeforeClass
	void beforeClass() {
		System.out.println("It will run before the class.");
	}

	@BeforeSuite
	void beforeSuite() {
		System.out.println("It will run before the suite.");
	}

	@BeforeGroups()
	void beforeGroup() {
		System.out.println("It will run before the Group.");
	}

	@BeforeMethod
	void beforeMethod() {
		System.out.println("It will run before each @Test method.");
		
	}

	@AfterTest
	void afterTest() {
		System.out.println("Runs after all test methods inside <test> tag in testng.xml.");
	}

	@AfterClass
	void afterClass() {
		System.out.println("Runs after all test methods in the class.");
	}

	@AfterGroups()
	void afterGroup() {
		System.out.println("It will run after the Group.");
	}

	@AfterSuite
	void afterSuite() {
		System.out.println("Runs after the suite execution is complete.");
	}

	@AfterMethod
	void afterMethod() {
		System.out.println("It will run after each @Test method.");
	}

}
