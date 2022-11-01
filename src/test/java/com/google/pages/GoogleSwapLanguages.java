package com.google.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSwapLanguages {
	WebDriver wd = null;

	public GoogleSwapLanguages(WebDriver driver) {
		this.wd = driver;
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//*[@id=\"ow25\"]/div/span/button/div[3]")
	WebElement swapLanguages;

	@FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[3]/c-wiz[1]/span/span/div/textarea")
	WebElement verifySwapText;

	public void swapLang() throws InterruptedException {
		Thread.sleep(2000);
		Actions act = new Actions(wd);
		act.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("s").build().perform();
		Thread.sleep(2000);
		act.keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).build().perform();
	}

	public void swappedText(String expected) throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertTrue(wd.findElements(By.xpath("//*[text()='grapes']")).size() > 0);
	}

}
