package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class MobileSlider {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public MobileSlider(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//p[text()='Mobile Slider']")
	WebElement mobileSlider;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement catogory;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFile;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alert;
	@FindBy(xpath="//button[@type='submit']")
	WebElement save;

	public void clickMobileSlider() {
		gu.getClickElement(mobileSlider);
	}

	public void clickNew() {
		gu.getClickElement(newButton);
	}

	public void selectCategory() {
		gu.getDropDownSelect(catogory, 3);
	}
	public void imageUpload() throws AWTException, InterruptedException {

		gu.getFileUpload(driver, chooseFile, System.getProperty("user.dir")+ "\\src\\main\\resources\\FileUpload\\imageupload.png");
	
	}
	public void clickSave() {
		gu.getClickElement(save);
	}
	public String alerttext()
	{
		return gu.getElementText(alert);
	}

}
