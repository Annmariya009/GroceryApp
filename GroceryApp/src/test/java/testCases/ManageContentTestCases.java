package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.CONSTANT;
import elementRepository.LoginPage;
import elementRepository.ManageContent;
import utilities.ExcelReadUtils;

public class ManageContentTestCases extends BaseClass {
	LoginPage lp;
	ManageContent mcon;

	@Test(enabled=false)
	public void verifytheAlertTextinAddPagesOfManageContentTab() throws AWTException, IOException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read(1, 0), ExcelReadUtils.read(1, 1));
		mcon = new ManageContent(driver);
		mcon.clickManageContent();
		mcon.clickManagePages();
		mcon.clickNew();
		mcon.enterTitle();
		mcon.enterDescrip();
		//mcon.selectText();
		//mcon.selectBold();
		mcon.enterPage();
		mcon.scrollDown();
		mcon.fileUpload();
		mcon.clickSave();
		String actual = mcon.alerttext();
		String expected = CONSTANT.alertText;
		Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertion);

	}
	@Test
	public void verifyBoldButtonIsEnabledInManagePagesofManagecontentTab() throws AWTException, IOException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read(1, 0), ExcelReadUtils.read(1, 1));
		mcon = new ManageContent(driver);
		mcon.clickManageContent();
		mcon.clickManagePages();
		mcon.clickNew();
		mcon.enterDescrip();
		mcon.selectText();
		mcon.selectBold();
		boolean actual=mcon.enableBold();
		boolean expected=true;
		Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertion);
		
		
	}
	
}
