package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.CONSTANT;
import elementRepository.LoginPage;
import elementRepository.ManageCategory;

public class ManageCategoryTestCases extends BaseClass {
	LoginPage lp;
	ManageCategory mc;

	@Test
	public void verifyAlertTextofSubCategoryMenuinManageCategory() {
		lp = new LoginPage(driver);
		lp.performLogin(CONSTANT.loginUserName, CONSTANT.loginPassword);
		mc = new ManageCategory(driver);
		mc.clickManageCategory();
		mc.clickSubCategory();
		mc.clickStatusActive();
		String actual = mc.alerttext();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, "Text is not matching");

	}
}
