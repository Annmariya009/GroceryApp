package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.CONSTANT;
import elementRepository.LoginPage;

public class LoginTestCases extends BaseClass {
	LoginPage lp;
  @Test(groups={"High"})
  public void verifyLoginButtonText() {
	   lp=new LoginPage(driver);
	  String actual= lp.signInText();
	  String expected="Sign In";
	  Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertion);
  }
  @Test(groups={"Critical"})
  public void verifyLoginButtonBackgroundColor() {
	  lp=new LoginPage(driver);
	  String actual=lp.getBackgroundcolorofSignIn();
	  String expected=CONSTANT.loginButtonBackgroundColor;
	  Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertion);
	  
  }
  
  
}
