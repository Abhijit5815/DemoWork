package com.hbsp.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Page {
	// protected
	// JSONReader3 objectRepo = null;

	public BasePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// Constructor of abstract class
	}

	/*
	 * public JSONReader3 jrfilecheck(String filePath) throws FileNotFoundException
	 * { if (this.objectRepo == null || this.objectRepo.isOfFile(filePath) == false)
	 * { this.objectRepo = new JSONReader3(filePath); } return this.objectRepo; }
	 */

	@Override
	public String getPageTitle() {
		return this.driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return this.getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			this.waitForElementPresent(locator);
			element = this.driver.findElement(locator);
			return element;
		} catch (Exception e) {

			System.out.println("some erro occured while getting elemtn" + locator.toString());
			e.printStackTrace();

		}
		return element;
	}

	@Override
	public void waitForElementPresent(By locator) {

		try {

			this.wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		} catch (Exception e) {

			System.out.println("some erro occured while waiting for  elemtn" + locator.toString());
			e.printStackTrace();
		}
	}

	@Override
	public void waitForPageTitle(String title) {
		// TODO Auto-generated method stub

		try {

			this.wait.until(ExpectedConditions.titleContains(title));

		} catch (Exception e) {

			System.out.println("some erro occured while waiting for  elemtn" + title);
			e.printStackTrace();
		}
	}

}
