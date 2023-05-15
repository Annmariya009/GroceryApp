package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageProduct;

public class ManageProductTestCases extends BaseClass {
	LoginPage lp;
	ManageProduct mp;

	@Test
	public void verifyNonvegRadioButtoninManageProductTab() {
		lp = new LoginPage(driver);
		lp.performLogin("admin", "admin");
		mp = new ManageProduct(driver);	
		mp.enterManageProduct();
		mp.clickNew();
		mp.clickRadioButton();
		boolean actual = mp.verifyRadioButton();
		boolean expected = true;
		Assert.assertEquals(actual, expected, "not matching");
	}
}
