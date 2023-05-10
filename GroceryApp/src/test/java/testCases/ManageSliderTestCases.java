package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageSlider;
import utilities.ExcelReadUtils;

public class ManageSliderTestCases extends BaseClass {
	LoginPage lp;
	ManageSlider ms;

	@Test
	public void verifyCancelButtoninAddSliderofManageTab() throws IOException, AWTException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read(1, 0), ExcelReadUtils.read(1, 1));
		ms = new ManageSlider(driver);
		ms.clickManangeSlider();
		ms.clickNew();
		ms.clickChoosefile();
		ms.enterLink();
		ms.clickCancel();
		boolean actual=ms.listSliderDisplay();
		boolean expected=true;
		Assert.assertEquals(actual, expected, "diplayed as not expected");

	}
	@Test
	public void verifyAndChangesStatusinManageSliderTab() throws IOException, InterruptedException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read(1, 0), ExcelReadUtils.read(1, 1));
		ms = new ManageSlider(driver);
		ms.clickManangeSlider();
		ms.pageScroll();
		Thread.sleep(2000);
		ms.clickStatus();
		String actual = ms.alerttext();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, "Text is not matching");
		
	}
	
}
