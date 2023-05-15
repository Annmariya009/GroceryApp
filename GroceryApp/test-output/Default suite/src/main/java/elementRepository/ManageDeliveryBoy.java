package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageDeliveryBoy {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public ManageDeliveryBoy (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']")
	WebElement manageDeliveryBoy;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")
	WebElement reset;
	public void clickDeliveryBoy() {
		gu.getClickElement(manageDeliveryBoy);
	}
	public String resetBackgroungColor() {
		return gu.getElementStyleProperty(reset, "background-color");
	}
	public String resetText() {
		return gu.getElementText(reset);
	}
	
	
	
}
