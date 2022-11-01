package com.google.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleTranslate {
	WebDriver wd = null;
	Actions act = null;

	public GoogleTranslate(WebDriver driver) {
		this.wd = driver;
		PageFactory.initElements(wd, this);
		act = new Actions(driver);
	}
	
	@FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[1]/c-wiz/div[1]/c-wiz/div[2]/button")
	WebElement langSourceButton;
	
	@FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[1]/c-wiz/div[2]/c-wiz/div[1]/div/div[2]/input")
	WebElement languageSource;
	
	@FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[1]/c-wiz/div[1]/c-wiz/div[5]/button/div[3]")
	WebElement langTransButton;
	
	@FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[1]/c-wiz/div[2]/c-wiz/div[2]/div/div[2]/input")
	WebElement languageTrans;
	
//	@FindBy(xpath = "//*[@id='yDmH0d']/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[3]/c-wiz[2]/div/div[8]/div/div[1]/span[1]/span")
//	@FindBy(xpath = "//div[text()='kela']")
//	@FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[3]/c-wiz[2]/div/div[8]/div/div[1]")
	@FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[3]/c-wiz[2]/div/div[8]/div/div[1]/span[1]/span/span")
	WebElement langTarget;
	
	@FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[3]/c-wiz[1]/span/span/div/textarea")
	WebElement langSource;
	
	@FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[3]/c-wiz[1]/div[1]")
	WebElement clearSourceData;
	
	public void clearText() throws InterruptedException {
		Thread.sleep(2000);
		clearSourceData.click();
	}
	
	public void selectEnglishFromSource(String source) throws InterruptedException {
		Thread.sleep(1000);
		langSourceButton.click();
		Thread.sleep(1000);
		languageSource.sendKeys(source);
		Thread.sleep(2000);
		languageSource.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
	
	public void selectHindiFromDestination(String destination) throws InterruptedException {
		Thread.sleep(1000);
		langTransButton.click();
		Thread.sleep(1000);
		languageTrans.sendKeys(destination);
		Thread.sleep(1000);
		languageTrans.sendKeys(Keys.ENTER);
	}
	
	public void enterSourceText(String sourcetext) throws InterruptedException {
		Thread.sleep(1000);
		langSource.sendKeys(sourcetext + Keys.ENTER);
		Thread.sleep(2000);
	}
	
	public void verifyTargetText(String expected) throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertEquals(expected, langTarget.getText());
	}
	
}
