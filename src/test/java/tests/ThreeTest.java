package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resourses.Base;

//sample Automation code for testng.xml file

public class ThreeTest extends Base {
	public WebDriver driver;

	@Test
	public void testThree() throws IOException, InterruptedException {

		System.out.println("Test Three");
		
		driver = initializeDriver();
		
		driver.get("https://tutorialsninja.com/demo/");
		
		Thread.sleep(2000);
		
		driver.close();
	}

}
