package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resourses.Base;

public class LoginTest extends Base {

	Logger log;
	WebDriver driver;

	@Test(dataProvider="getLoginData")
	public void login(String email, String password, String expectedResult) throws IOException {
		
		
		
		
		LandingPage landingPage = new LandingPage(driver);
		
		landingPage.myAccountDropdown().click();
		log.debug("Clicked on My Account dropdown");
		
		landingPage.loginOption().click();
		log.debug("Clicked on login option");
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.emailField().sendKeys(email);
		log.debug("Email addressed got entered");
		
		loginPage.passwordField().sendKeys(password);
		log.debug("Password got entered");
		
		loginPage.loginButton().click();
		log.debug("Clicked on login option");
		
		AccountPage accountPage = new AccountPage(driver);
		
		String actualResult = null;
		try {
			
			if(accountPage.AccountInfoEditOption().isDisplayed()) {
				log.debug("User got logged in");
				actualResult = "Successfull";
			}
			
		}catch(Exception e) {
			log.debug("User didn't log in");
			actualResult = "Failure";
			
		}
		
		Assert.assertEquals(actualResult,expectedResult);
		log.info("Login Test got passed");
		
		
	}

	@BeforeMethod
	public void openApplication() throws IOException {
		log = LogManager.getLogger(LoginTest.class.getName());
		
		driver = initializeDriver();
//		log.debug("Browser got launched");
		
		driver.get(prop.getProperty("url"));
//		log.debug("Navigated to application URL");
		
	}
	
	
	@AfterMethod
	public void tearDown() {

		driver.close();
		log.debug("Browser got closed");

	}

	@DataProvider
	public Object[][] getLoginData() {

		Object[][] data = { { "anirudha.selenium5@gmail.com", "Anirudha@123", "Successfull" },
//				{ "dummy@test.com", "dummy", "Failure" } 
				};

		return data;

	}
};