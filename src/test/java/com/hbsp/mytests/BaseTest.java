package com.hbsp.mytests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.hbsp.mypages.BasePage;
import com.hbsp.mypages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	WebDriverWait wait;
	public Page page;

	@BeforeMethod
	@Parameters(value = { "browser" })
	public void setUpTest(String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			this.driver = new ChromeDriver();
			this.wait = new WebDriverWait(this.driver, 15);
		} else if (browser.equals("ff")) {
			WebDriverManager.firefoxdriver().setup();
			this.driver = new FirefoxDriver();
			this.wait = new WebDriverWait(this.driver, 15);
		} else {

			System.out.println("No browser is defined");
		}

		this.driver.get("https://www.facebook.com/");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.page = new BasePage(this.driver, this.wait);

		// pass driver to the Page class constructor so that it will be supplied to all
		// child classws
		// call constructor of absrtact class Page

	}

	@AfterMethod
	public void teardown() {
		this.driver.quit();
	}

	public void failed() {

		File screenshotfile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenshotfile, new File("E:\\Vamp-workspace\\HBSelTng\\ScreenshotsFails"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
