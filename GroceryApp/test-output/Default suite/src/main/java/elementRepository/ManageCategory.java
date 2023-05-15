package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageCategory {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public ManageCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

}
	@FindBy(xpath="//i[@class='nav-icon fas fa-list-alt']")
	WebElement manageCategory;
	@FindBy(xpath="//p[text()='Sub Category']")
	WebElement subCategory;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alert;
	public void clickManageCategory() {
		gu.getClickElement(manageCategory);
	}
	public void clickSubCategory() {
		gu.getClickElement(subCategory);
	}
	public void clickStatusActive()
	{
		int rowValue = gu.getDynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]", "Turnips");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + rowValue
				+ "]//td[4]//a[1]";
		WebElement activeStatus = driver.findElement(By.xpath(locator));
		activeStatus.click();

	}
	public String alerttext()
	{
		return gu.getElementText(alert);
	}
	
	
}
