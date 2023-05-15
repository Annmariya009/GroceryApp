package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageSlider {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public ManageSlider(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider']")
	WebElement manageSlider;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(id = "main_img")
	WebElement chooseFile;
	@FindBy(id = "link")
	WebElement linkText;
	@FindBy(name = "create")
	WebElement save;
	@FindBy(xpath = "//a[text()='Cancel']")
	WebElement cancel;
	@FindBy(xpath = "//h4[text()='List Sliders']")
	WebElement listSliders;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alert;

	public void clickManangeSlider() {
		gu.getClickElement(manageSlider);

	}

	public void clickNew() {
		gu.getClickElement(newButton);
	}

	public void clickChoosefile() throws AWTException {
		gu.getFileUpload(driver, chooseFile,
				System.getProperty("user.dir") + "\\src\\main\\resources\\FileUpload\\imageUpload.png");
	}

	public void enterLink() {
		linkText.sendKeys("https");
	}

	public void clickCancel() {
		cancel.click();
	}

	public boolean listSliderDisplay() {
		return gu.isDisplayed(listSliders);

	}

	public void pageScroll() {
		gu.getPageScroll(driver, 0, 4000);
	}

	public void clickStatus() {
		int rowValue = gu.getDynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[2]", "https");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + rowValue
				+ "]//td[3]//a[1]";
		WebElement clickStatus = driver.findElement(By.xpath(locator));
		// Actions action=new Actions(driver);
		// action.moveToElement(clickStatus).click().perform();
		clickStatus.click();

	}

	public String alerttext() {
		return gu.getElementText(alert);
	}

}
