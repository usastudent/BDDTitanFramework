package stepDef;

import java.util.List;

import java.util.Map;

import org.junit.Assert;

import core.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RetailsPage;
import utilities.WebDriverUtility;

public class RetailStepDef extends Base {

	RetailsPage retail = new RetailsPage();

	@When("User click on Register Option")
	public void user_click_on_register_option() {
		retail.clickOnRegister();
		logger.info("user clicked on Register Option");

	}

	@When("User fill Personal Details with below information")
	public void user_fill_personal_details_with_below_information(DataTable dataTable) {
		List<Map<String, String>> information = dataTable.asMaps(String.class, String.class); // we store it as List of Map
		retail.enterFirstNameValue(information.get(0).get("firstName")); // we get this information from datatable , it is list of map so we provide the list of index(row) and key(colum) for the map to get the value. 
		retail.enterLastNameValue(information.get(0).get("lastName"));
		retail.enterEmailValue(information.get(0).get("email"));
		retail.enterTelephoneValue(information.get(0).get("telephone"));
		retail.enterPasswordValue(information.get(0).get("password"));
		retail.enterConfirmPasswordValue(information.get(0).get("passwordConfirm"));
		retail.subscribe(information.get(0).get("subscribe"));
		logger.info("user filled the personal information");
		WebDriverUtility.takeScreenShot();

	}

	@When("User click on privacyPolicy")
	public void user_click_on_privacy_policy() {
		retail.checkPrivacyPolicyBox();
		logger.info("user clicked on privacy Policy");

	}

	/*
	 * this method click on Continue button and it is part of Step definition for
	 * Register Page
	 */
	@When("User click on ContinueButton")
	public void user_click_on_continue_button() {
		retail.clickOnContinueButton();
		logger.info("user clicked on Continue Button");

	}

	@Then("User should see a success message {string}")
	public void user_should_see_a_success_message(String expectedMessage) {
		Assert.assertEquals(expectedMessage, retail.actualSuccessMessage());
		logger.info("actual message " + retail.actualSuccessMessage() + " " + "equals " + "expected message "
				+ expectedMessage);
		WebDriverUtility.takeScreenShot();
	}

}
