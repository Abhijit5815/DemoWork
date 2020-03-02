package com.hbsp.commonutilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UserActions {

	WebDriver driver;
	Actions s = new Actions(this.driver);

	public void clickOnelement(WebElement w) {
		this.s.click(w).build().perform();
		;
	}

	public void doubleclick(WebElement w) {
		this.s.doubleClick().build().perform();
		;
	}

	public void ctrlpluskey(WebElement w, char x) {
		this.s.keyDown(Keys.CONTROL).sendKeys("x").build().perform();
		;

	}

}
