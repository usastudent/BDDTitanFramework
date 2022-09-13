package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class HomePage extends Base{
	
	/**
	 * we will create a constructor and inside the constructor 
	 * we will use PageFactory Class of Selenium and its method initElements to
	 * initialize the UI Elements in this page
	 */
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	// for locating UI Elements using PageFactory we use @FindBy annotation and then we 
	// store UI Elements in WebElement data type and make it private. 
	// driver.findElement(By.LocatorType) == @FindBy(locatorType = "value")
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	private WebElement myAccount;
	
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	private WebElement loginOption;
	
	@FindBy(id = "input-email")
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//a[contains(text(),'TEST ENVIRONMENT')]")
	private WebElement homePageLogo;
	
	@FindBy(xpath = "//h2[contains(text(),'My Account')]")
	private WebElement myAccountValidation;
	
	
	public void clickOnMyAccount() {
		myAccount.click();
	}
	
	public void clickonLoginOption() {
		loginOption.click();
	}
	
	public void enterUserNameAndPassword(String emailValue, String passValue) {
		emailField.sendKeys(emailValue);
		passwordField.sendKeys(passValue);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public boolean isTestEnvironmentLogoPresent() {
		if(homePageLogo.isDisplayed())
			return true;
		else 
			return false;
	}
	
	public boolean ismyAccountValidationPresent() {
		if(myAccountValidation.isDisplayed())
			return true;
		else 
			return false;
	}

}
