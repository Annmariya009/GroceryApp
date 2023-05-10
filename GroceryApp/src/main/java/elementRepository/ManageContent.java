package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageContent {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public ManageContent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-edit']")
	WebElement manageContent;
	@FindBy(xpath = "//p[text()='Manage Pages']")
	WebElement managePages;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(id = "title")
	WebElement title;
	@FindBy(xpath = "//div[@class='note-editable card-block']")
	WebElement description;
	@FindBy(id = "page")
	WebElement page;
	@FindBy(id = "main_img")
	WebElement imageUpload;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alert;
	@FindBy(xpath="//i[@class='note-icon-bold']")
	WebElement  bold;

	public void clickManageContent() {
		gu.getClickElement(manageContent);
	}

	public void clickManagePages() {
		gu.getClickElement(managePages);
	}

	public void clickNew() {
		gu.getClickElement(newButton);
	}

	public void enterTitle() {
		title.sendKeys("hello");

	}

	public void enterDescrip() {
		description.sendKeys("mariya");
	}
	public void selectBold() {
		 gu.getClickElement(bold);
	}
	public boolean enableBold()
	{
		return gu.isEnabled(bold);
	}
	public void selectText() throws AWTException {
		gu.getTextSelected(description, "mariya");
	}
	

	public void enterPage() {
		page.sendKeys("onion");
	}

	public void scrollDown() {
		gu.getPageScroll(driver, 0, 4000);
	}

	public void fileUpload() throws AWTException {
		gu.getFileUpload(driver, imageUpload,
				System.getProperty("user.dir") + "\\src\\main\\resources\\FileUpload\\imageUpload.png");
	}

	public void clickSave() {
		gu.getClickElement(save);
	}
	public String alerttext() {
		return gu.getElementText(alert);
	}

}
