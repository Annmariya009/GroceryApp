package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageLocation {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public ManageLocation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location']")
	WebElement manageLocation;
	
}
