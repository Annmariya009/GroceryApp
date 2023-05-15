package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.PushNotifications;

public class PushNotificationsTestCases extends BaseClass {
	LoginPage lp;
	PushNotifications pn;

	@Test
	public void verifytextOfSaveButtoninPushNotification() {
		lp = new LoginPage(driver);
		lp.performLogin("admin", "admin");
		pn = new PushNotifications(driver);
		pn.clickPush();
		pn.enterTitle("hello");
		pn.inputDescription("how r u");
		pn.clickSave();
		pn.clickSave();
		String actual = pn.saveButtonText();
		String expected = "Send";
		Assert.assertEquals(actual, expected, "not matching");

	}
}
