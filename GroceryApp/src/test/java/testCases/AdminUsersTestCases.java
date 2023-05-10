package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.CONSTANT;
import elementRepository.AdminUsers;
import elementRepository.LoginPage;
import utilities.ExcelReadUtils;

public class AdminUsersTestCases extends BaseClass {
	LoginPage lp;
	AdminUsers au;

	@Test(enabled=false)
	public void verifyAndUpdateUserTypeOfAdminUsersinAdminUsersTab() throws IOException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read(1, 0), ExcelReadUtils.read(1, 1));
		au = new AdminUsers(driver);
		au.clickAdminUsers();
		au.clickEdit();
		String actual = au.selectDropdown();
		String expected = "Partner";
		Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertion);
		au.clickUpdate();

	}

	@Test

	public void verifyThePasswordOfUserisDisplayedinAdminUsersTab() throws IOException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read(1, 0), ExcelReadUtils.read(1, 1));
		au = new AdminUsers(driver);
		au.clickAdminUsers();
		au.clickPassword();
		boolean actual = au.passwordDisplay();
		boolean expected = true;
		Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertion);

	}
}
