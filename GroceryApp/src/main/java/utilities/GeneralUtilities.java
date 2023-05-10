package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	// general reusable methods

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;

	}

	public String getElementStyleProperty(WebElement element, String propertyType) {
		String value = element.getCssValue(propertyType);
		return value;
	}

	public String getDropDownSelect(WebElement element, int index) {
		Select obj = new Select(element);
		obj.selectByIndex(index);
		element = obj.getFirstSelectedOption();
		String text = element.getText();
		return text;

	}

	public boolean isCheckBoxSelected(WebElement element) {
		boolean check = element.isSelected();
		return check;
	}
	

	public int getDynamicTable(WebDriver driver, String columnValue, String compareName) {
		List<WebElement> columnElements = driver.findElements(By.xpath(columnValue));
		int value = 0;
		for (int i = 0; i < columnElements.size(); i++) {
			if (columnElements.get(i).getText().equals(compareName)) {
				value = i + 1;
			}

		}
		return value;
	}

	public void alertSelection(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getAlertText(WebDriver driver) {
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}

	public void getFileUpload(WebDriver driver, WebElement element, String type) throws AWTException {
		Robot robot = new Robot();
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		StringSelection ss = new StringSelection(type);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void getClickElement(WebElement element) {
		element.click();
	}

	public void getPageScroll(WebDriver driver, int horizontalValue, int verticalValue) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + horizontalValue + "," + verticalValue + ")", "");
	}

	public boolean isDisplayed(WebElement element) {
		boolean display = element.isDisplayed();
		return display;

	}

	public void getTextSelected(WebElement element, String text) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_A);
	}

	public boolean isEnabled(WebElement element)
	{
		boolean enable=element.isEnabled();
		return enable;
	}

}
