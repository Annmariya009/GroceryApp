package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.CONSTANT;
import elementRepository.LoginPage;
import elementRepository.ManageDeliveryBoy;
import utilities.ExcelReadUtils;

public class ManageDeliveryBoyTestCases extends BaseClass {
	LoginPage lp;
	ManageDeliveryBoy mdb;

	@Test
	public void verifyBackgroundColorofResetMenuinDeliveryBoyTab() throws IOException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read(1, 0), ExcelReadUtils.read(1, 1));
		mdb = new ManageDeliveryBoy(driver);
		mdb.clickDeliveryBoy();
		String actual=mdb.resetBackgroungColor();
		String expected="rgba(255, 193, 7, 1)";
		 Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertion);
	}
}
