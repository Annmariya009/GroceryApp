package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class AdminUsers {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public AdminUsers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement adminUsers;
	@FindBy(id = "user_type")
	WebElement userType;
	@FindBy(name = "Update")
	WebElement update;
	@FindBy(xpath="//span[text()='123']")
	WebElement displayPassword;


	public void clickAdminUsers() {
		gu.getClickElement(adminUsers);
	}

	public void clickEdit() {
		int rowValue = gu.getDynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]",
				"Nyla Kling Monahan IV");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + rowValue
				+ "]//td[5]//a[2]";
		WebElement editButton = driver.findElement(By.xpath(locator));

		editButton.click();

	}
	public String selectDropdown() {
		return gu.getDropDownSelect(userType, 3);
	}
	public void clickUpdate() {
		gu.getClickElement(update);
	}
	public void clickPassword() {
		int rowValue = gu.getDynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]",
				"test123");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + rowValue
				+ "]//td[4]//a[1]";
		WebElement password= driver.findElement(By.xpath(locator));
		password.click();
	}
	public boolean passwordDisplay() {
		return gu.isDisplayed(displayPassword);
	}

}
