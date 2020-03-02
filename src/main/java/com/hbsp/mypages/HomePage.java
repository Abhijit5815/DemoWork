package com.hbsp.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePage extends BasePage {

	public HomePage(WebDriver driver,WebDriverWait wait) {
		super(driver,wait);
		// TODO Auto-generated constructor stub
	}
	
	private By header =By.className("marketplace_icon");
	

	
	
	public WebElement getHeader() {
		return getElement(header);
	}

	
	
}

