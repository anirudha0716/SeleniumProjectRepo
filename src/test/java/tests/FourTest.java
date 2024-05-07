package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resourses.Base;

//sample Automation code for testng.xml file

public class FourTest extends Base{

	public WebDriver driver;
	@Test
	public void testFour() throws IOException, InterruptedException {

		System.out.println("Test Four");
		
		driver = initializeDriver();
		
		driver.get("https://tutorialsninja.com/demo/");
		
		Thread.sleep(2000);
		
//		Assert.assertTrue(false);
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
		
	}

}
