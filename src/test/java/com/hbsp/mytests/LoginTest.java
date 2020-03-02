package com.hbsp.mytests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbsp.mypages.LoginPage;

public class LoginTest extends BaseTest {

	// retry at test level
	// retry can be done a runtime by using tranformer listener

	@Test(priority = 1, enabled = false)
	public void loginPageTitleTest() {

		// use generics instead of creating directobject of loginpage

		// String title= page.getInstance(LoginPage.class).getLoginPageTitle();
		// Assert.assertEquals(title,"Facebook â€“ log in or sign up");
	}

	@Test(priority = 1, enabled = false)
	public void loginPageHeaderTest() {
		Assert.assertEquals(true, false);
	}

	@Test(priority = 1)
	public void doLoginTest() throws Exception {

		this.page.getInstance(LoginPage.class).doLogin("mystiqfire@gmail.com", "Chuchu");
	}

}
