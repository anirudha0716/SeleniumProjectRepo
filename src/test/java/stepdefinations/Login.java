package stepdefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resourses.Base;

public class Login extends Base {
	WebDriver driver;
	LandingPage landingPage;
	LoginPage loginPage;
	AccountPage accountPage;

	@Given("^Open any browser$")
	public void Open_any_browser() throws IOException {

		driver = initializeDriver();

	}

	@And("^Navigate to login page$")
	public void Navigate_to_login_page() {

		driver.get(prop.getProperty("url"));

		landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		landingPage.loginOption().click();

	}

	@When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	public void User_enters_username_as_and_password_as_into_the_fields(String email, String password) {
		
		loginPage = new LoginPage(driver);

		loginPage.emailField().sendKeys(email);
		loginPage.passwordField().sendKeys(password);

	}

	@And("^clicks the login button$")
	public void clicks_the_login_button() {
		
		loginPage.loginButton().click();

	}

	@Then("^verify user is able to successfully login$")
	public void verify_user_is_able_to_successfully_login() {
		
		accountPage = new AccountPage(driver);
		
		Assert.assertTrue(accountPage.AccountInfoEditOption().isDisplayed());
		
	}
	
	@After
	public void closeBrowser() {
		
		driver.close();
		
	}

}
