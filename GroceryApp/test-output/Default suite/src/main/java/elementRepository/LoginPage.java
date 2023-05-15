package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // page factory
	}

	@FindBy(name = "username")
	WebElement userName;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signIn;

	public void getUserName(String enterUserName) {
		userName.sendKeys(enterUserName);
	}

	public void getPassword(String passwordEnter) {

		password.sendKeys(passwordEnter);
	}

	public String signInText() {
		return gu.getElementText(signIn);
	}

	public String getBackgroundcolorofSignIn() {
		return gu.getElementStyleProperty(signIn, "background-color");
	}

	public void enterSignIn() {
		signIn.click();
	}

	public void performLogin(String enterUserName,String enterPassword)
	{
		userName.sendKeys(enterUserName);
		password.sendKeys(enterPassword);
		signIn.click();
		
	}

}
