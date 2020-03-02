package com.hbsp.mypages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hbsp.globalutilities.JSONReader3;

public class LoginPage extends BasePage {

	JSONReader3 jr = new JSONReader3("E:\\Vamp-workspace\\HBSelTng\\Resources\\or.json");

	public LoginPage(WebDriver driver, WebDriverWait wait) throws FileNotFoundException {

		super(driver, wait);

	}

	By email = this.jr.getlocator("loginpage", "username");
	By password = this.jr.getlocator("loginpage", "password");
	By loginbtn = this.jr.getlocator("loginpage", "loginbutton");

	public void doLogin(String emailid, String password1) {

		this.getElement(this.email).sendKeys(emailid);

		this.getElement(this.password).sendKeys(password1);

		this.getElement(this.loginbtn).click();

		// return getInstance(HomePage.class);
	}

}
