package elementRepository;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;

public class ManageUsers {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public ManageUsers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-user']")
	WebElement manageUser;

	public void clickManageUser() {
		manageUser.click();
	}

	public void clickDelete() {
		int rowValue = gu.getDynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]", "Tester");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + rowValue
				+ "]//td[6]//a[2]";
		WebElement deleteButton = driver.findElement(By.xpath(locator));
		deleteButton.click();

	}

	public void getAlertSelect() {
		//WebDriverWait waitAlert = new WebDriverWait(driver, Duration.ofMillis(5000));
		//waitAlert.until(ExpectedConditions.alertIsPresent());
		gu.alertSelection(driver);
	}

	public String alertText() {
//		WebDriverWait waitAlert = new WebDriverWait(driver, Duration.ofMillis(5000));
//		waitAlert.until(ExpectedConditions.alertIsPresent());
		return gu.getAlertText(driver);
	}
}
