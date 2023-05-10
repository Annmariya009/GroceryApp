package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageUsers;

public class ManageUsersTestCases extends BaseClass {
	LoginPage lp;
	ManageUsers mu;

	@Test
	public void VerifyAlertPopUpTextinManageUserTab() throws InterruptedException {
		lp = new LoginPage(driver);
		lp.performLogin("admin", "admin");
		mu = new ManageUsers(driver);
		mu.clickManageUser();
		mu.clickDelete();
		String actual = mu.alertText();
		mu.getAlertSelect();
		String expected = "Do you want to delete this User Details?";
		Assert.assertEquals(actual, expected, "not matching");
		
	}
}
