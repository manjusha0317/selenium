package com.google.automation;

import java.awt.AWTException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.core.BaseClass;
import com.google.pages.GoogleScreenKeyboard;
import com.google.pages.GoogleSwapLanguages;
import com.google.pages.GoogleTranslate;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef extends BaseClass {

	String parentWindow = null;
	GoogleTranslate googleTranslatePage = null;
	GoogleSwapLanguages googleSwapLangPage = null;
	GoogleScreenKeyboard googleScreenKeyboardPage = null;
	JSONParser jsonParser = null;
	Object obj = null;
	FileReader reader = null;
	JSONArray array = null;
	JSONObject rec1 = null;

	@Before
	public void setup(Scenario scenario) throws IOException, ParseException, AWTException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		googleTranslatePage = new GoogleTranslate(driver);
		googleSwapLangPage = new GoogleSwapLanguages(driver);
		googleScreenKeyboardPage = new GoogleScreenKeyboard(driver);
		jsonParser = new JSONParser();
		reader = new FileReader("src/test/resources/TestData.json");
		obj = jsonParser.parse(reader);

		array = (JSONArray) ((JSONObject) obj).get("data");
		if (scenario.getName().contains("Verify translated Text from Hindi to English")) {
			rec1 = (JSONObject) array.get(1);
		} else {
			rec1 = (JSONObject) array.get(0);
		}
	}

	@Given("^Application is opened and on Home Page$")
	public void openHomePage() {
		driver.get("https://translate.google.com/");
	}

	@When("^User select source language$")
	public void sourceLanguage() throws InterruptedException {
		googleTranslatePage.selectEnglishFromSource((String) rec1.get("source"));
		Thread.sleep(1000);
	}

	@And("^select required translated language$")
	public void targetLanguage() throws InterruptedException {
		googleTranslatePage.selectHindiFromDestination((String) rec1.get("destination"));
		Thread.sleep(1000);
	}

	@And("^User type source text$")
	public void enterTextInSource() throws InterruptedException {
		googleTranslatePage.enterSourceText((String) rec1.get("sourcetext"));
	}

	@Then("^translated text should display$")
	public void verifyTextInTarget() throws InterruptedException {
		googleTranslatePage.verifyTargetText((String) rec1.get("expected"));
	}

	@Then("^user click on swap languages button$")
	public void swapLanguages() throws InterruptedException {
		googleSwapLangPage.swapLang();
	}

	@And("^verify destination text$")
	public void verifySwappedText() throws InterruptedException {
		googleSwapLangPage.swappedText((String) rec1.get("expected"));
	}

	@Then("^User click on clear source text link$")
	public void clearSourceText() throws InterruptedException {
		Thread.sleep(1000);
		googleTranslatePage.clearText();
	}

	@Then("^User click on Keyboard and type Hi text$")
	public void useVirtualKeyboard() throws InterruptedException {
		googleScreenKeyboardPage.enterTextUsingVirtualKeyboard();
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
