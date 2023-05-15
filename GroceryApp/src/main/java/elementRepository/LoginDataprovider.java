package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginDataprovider {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public LoginDataprovider(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // page factory
	}

	@FindBy(name = "username")
	WebElement userName;
	@FindBy(name = "password")
	WebElement Password;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signIn;
	@FindBy(xpath = "//span[@class='brand-text font-weight-light']")
	WebElement homeTitle;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement Alert;

	public void getUserName(String enterUserName) {
		userName.sendKeys(enterUserName);
	}

	public void getPassword(String passwordEnter) {

		Password.sendKeys(passwordEnter);
	}

	public void enterSignIn() {
		signIn.click();
	}
}
