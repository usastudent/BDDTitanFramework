package stepDef;

import org.junit.Assert;

import core.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import utilities.WebDriverUtility;

public class HomeStepDef extends Base {
	HomePage homePage = new HomePage();

	@Given("User is on retail Website")
	public void user_is_on_retail_website() {
		Assert.assertTrue(homePage.isTestEnvironmentLogoPresent());
		logger.info("user is on Retail Website");
		WebDriverUtility.takeScreenShot();


	}

	@When("User click on myAccount")
	public void user_click_on_myAccount() {
		homePage.clickOnMyAccount();
		logger.info("user clicked on MyAccount option");


	}

	@And("User click on Login option")
	public void user_click_on_login_option() {
		homePage.clickonLoginOption();
		logger.info("user clicked on Login Option");

	}

	@And("User enter userName {string} and password {string}")
	public void user_enter_userName_and_password(String email, String pass) {
		homePage.enterUserNameAndPassword(email, pass);
		logger.info("user enter " + email + " and " + pass);


	}

	@And("User click on login button")
	public void user_click_on_login_button() {
		homePage.clickOnLoginButton();
		logger.info("user clicked on login button");


	}

	@Then("User should be logged into myAccount page")
	public void user_should_be_logged_into_myAccount_page() {
		Assert.assertTrue(homePage.ismyAccountValidationPresent());
		logger.info("user is on My Account Page");
		WebDriverUtility.takeScreenShot();

	}

}
