package testCases;

import org.testng.annotations.Test;

import constants.CONSTANT;
import elementRepository.LoginDataprovider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class LoginDataProviderTestCase extends BaseClass {
	LoginDataprovider lp;

	@Test(dataProvider = "login")
	public void verifySucessFullLogin(String username, String password) {
		lp = new LoginDataprovider(driver);
		lp.getUserName(username);
		lp.getPassword(password);
		lp.enterSignIn();
		boolean actual = lp.titleDisplay();
		boolean expected = true;
		Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertion);

	}

	@Test(dataProvider = "unsuccessfullogin")
	public void verifyUnSucessFullLogin(String username1, String password1) {
		lp = new LoginDataprovider(driver);
		lp.getUserName(username1);
		lp.getPassword(password1);
		lp.enterSignIn();
		boolean actual = lp.failedfLoginAlert();
		boolean expected = true;
		Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertion);

	}

	@DataProvider(name = "login")
	public Object[][] dp() {
		return new Object[][] { { "admin", "admin" } };

	}

	@DataProvider(name = "unsuccessfullogin")
	public Object[][] dpMethod1() {
		return new Object[][] { { "adm", "adin" }, { "ad", "Ad" } };
	}

}
