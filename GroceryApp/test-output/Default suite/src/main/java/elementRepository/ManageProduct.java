package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageProduct {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public ManageProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-tasks']")
	WebElement manageProduct;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath="//input[@value='Nonveg']")
	WebElement clickNonVegRadioButton;

	public void enterManageProduct() {
		manageProduct.click();
	}

	public void clickNew() {
		newButton.click();
	}
	public void clickRadioButton()
	{
		clickNonVegRadioButton.click();
		
	}
	public boolean verifyRadioButton()
	{
		return gu.isCheckBoxSelected(clickNonVegRadioButton);
	}

}
