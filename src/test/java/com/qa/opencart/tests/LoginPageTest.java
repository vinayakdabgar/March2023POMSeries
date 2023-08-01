package com.qa.opencart.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstant;

public class LoginPageTest extends BaseTest{ 
	
	
	@Test(priority =1)
	public void LoginPageTitleTest()
	{
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, AppConstant.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority =2)
	public void LoginPageURLTest()
	{
		String actualURL = loginPage.getLoginPageUrl();
		Assert.assertTrue(actualURL.contains(AppConstant.LOGIN_PAGE_URL_FRACTION));
	}
	
	@Test(priority =3)
	public void isforgotPwdLinkExistTest()
	{
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Test(priority =4)
	public void loginTest()
	{
		accPage =loginPage.doLogin("janautomation@gmail.com", "Selenium@12345");
		Assert.assertEquals(accPage.isLogoutLinkExist(), true);
		
	}

}
