package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import utilities.WebDriverUtility;

public class RetailsPage extends Base {

	public RetailsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerOption;

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;

	@FindBy(xpath = "//input[@value='1' and @type ='radio' and @name='newsletter']")
	private WebElement yesRadioButton;

	@FindBy(xpath = "//input[@value='0' and @type ='radio' and @name='newsletter']")
	private WebElement noRadioButton;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicyCheckBox;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	private WebElement sucessMessage;

	public void clickOnRegister() {
		registerOption.click();
	}

	public void enterFirstNameValue(String fNameValue) {
		firstNameField.sendKeys(fNameValue);
	}

	public void enterLastNameValue(String lNameValue) {
		lastNameField.sendKeys(lNameValue);
	}

	public void enterEmailValue(String emailValue) {
		emailField.sendKeys(emailValue);
	}

	public void enterTelephoneValue(String telephoneValue) {
		telephoneField.sendKeys(telephoneValue);
	}

	public void enterPasswordValue(String passwordValue) {
		passwordField.sendKeys(passwordValue);
	}

	public void enterConfirmPasswordValue(String confirmPasswordValue) {
		confirmPasswordField.sendKeys(confirmPasswordValue);
	}

	public void subscribe(String subscribeValue) {
		if (subscribeValue.trim().equalsIgnoreCase("yes")) {
			yesRadioButton.click();
		} else
			noRadioButton.click();
	}
	
	public void checkPrivacyPolicyBox() {
		privacyPolicyCheckBox.click();
	}
	
	public void clickOnContinueButton() {
		continueButton.click();
	}
	
	public String actualSuccessMessage() {
		
		String actualText = WebDriverUtility.getText(sucessMessage);
		return actualText;
		//return sucessMessage.getText();
	}
	
	public boolean registerOptionIsPresent() {
		if(registerOption.isDisplayed())
			return true;
		else 
			return false;
	}
	


}

// syntax for storing a UI Element using @FindBy of Page Factory
/**
 * @FindBy(locatorType = "value of Locator") accessModifier WebElement
 *                     nameofElement; example:
 * @FindBy(xpath = "//input[@id='email']") private WebElement emailField;
 */
// syntax for writing action Methods
/**
 * access modifier returntype(parameter){ WebElement.selenium Methods. example:
 * public void enterValuetoEmailField(String EmailInput){
 * emailField.sendKeys(EmailInput); }
 */
