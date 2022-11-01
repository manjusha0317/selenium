package com.google.pages;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleScreenKeyboard {
	WebDriver wd = null;
	Actions act = null;
	JavascriptExecutor js = null;
	Robot robot = null;

	public GoogleScreenKeyboard(WebDriver driver) throws AWTException {
		this.wd = driver;
		PageFactory.initElements(wd, this);
		act = new Actions(driver);
		js = (JavascriptExecutor) driver;
		robot = new Robot();
	}

	@FindBy(xpath = "//*[@id='ow71']/div/span/button/div[3]")
	WebElement clearSourceData;

	@FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[3]/c-wiz[1]/div[4]/div[3]")
	WebElement keyBoard;

	@FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[3]/c-wiz[1]/span/span/div/textarea")
	WebElement textSource;

	public void clearText() throws InterruptedException {
		Thread.sleep(10000);
		clearSourceData.click();
	}

	public void enterTextUsingVirtualKeyboard() throws InterruptedException {
		Thread.sleep(5000);
		keyBoard.click();
		Thread.sleep(1000);
		wd.findElement(By.xpath("//*[@id=\"K16\"]")).click();
		Thread.sleep(1000);
		wd.findElement(By.xpath("//*[@id=\"K72\"]/span")).click();
		Thread.sleep(1000);
		wd.findElement(By.xpath("//*[@id=\"K73\"]/span")).click();
		Thread.sleep(1000);
		wd.findElement(By.xpath("//*[@id=\"kbd\"]/div[1]/div[2]/div/div")).click();
		Thread.sleep(1000);
	}
}
