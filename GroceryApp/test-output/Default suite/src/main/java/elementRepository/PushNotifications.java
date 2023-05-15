package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;

public class PushNotifications {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public PushNotifications(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-fas fa-bell']")
	WebElement pushNotification;
	@FindBy(xpath = "//input[@id='title']")
	WebElement title;
	@FindBy(xpath = "//input[@id='description']")
	WebElement enterDescription;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	WebElement saveButton;

	public void clickPush() {
		pushNotification.click();
	}

	public void enterTitle(String gettitle) {
		title.sendKeys(gettitle);
	}

	public void inputDescription(String descrip) {
		enterDescription.sendKeys(descrip);
	}

	public void clickSave() {
		saveButton.click();
	}
	public String saveButtonText() {
		return gu.getElementText(saveButton);
	}

}
