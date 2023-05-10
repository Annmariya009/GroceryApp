package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.CONSTANT;
import elementRepository.LoginPage;
import elementRepository.ManageExpense;
import utilities.ExcelReadUtils;

public class ManageExpenseTestCases extends BaseClass {
	LoginPage lp;
	ManageExpense me;

	@Test(enabled = false)
	public void verifyTextofNewinExpenseCategoryofManageExpenseTab() {
		lp = new LoginPage(driver);
		lp.getUserName("admin");
		lp.getPassword("admin");
		lp.enterSignIn();
		me = new ManageExpense(driver);

		me.enterManageExpense();
		me.enterExpenseCaregory();
		String actual = me.newText();
		String expected = "New";
		Assert.assertEquals(actual, expected, "not matching");

	}

	@Test(enabled = false)
	public void verifyDropdownofUserinManageExpenseSubmenu() throws IOException {
		lp = new LoginPage(driver);
		lp.getUserName(ExcelReadUtils.read(1, 0));
		lp.getPassword(ExcelReadUtils.read(1, 1));
		lp.enterSignIn();
		me = new ManageExpense(driver);
		me.enterManageExpense();
		me.enterManageExpensesub();
		me.clickNew();
		String actual = me.selectuserDropDown();
		String expected = "Staff(Staff)";
		Assert.assertEquals(actual, expected, "not matching");

	}@Test
	public void verifyViewMoreisExpandableinListExpenseofManageExpensetab() throws IOException, InterruptedException
	{
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read(1, 0), ExcelReadUtils.read(1, 1));
		me = new ManageExpense(driver);
		me.enterManageExpense();
		me.enterManageExpensesub();
		boolean actual=me.clickViewMore();
		boolean expected=true;
		Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertion);

	}
	
	

}
