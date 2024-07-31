package com.EmployeeView.stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.ConfigReader;
import com.TimeSheet.utils.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	private static WebDriver driver;

	@Before
	public void setbrowser() {
		String URLBrowser = ConfigReader.matrixUrl();
		driver = WebDriverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URLBrowser);

	}

	@AfterStep
	public static void tearDown(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
	}

	@After
	public void quitBrow() {
		CommonUtils.waitFor(3);
		WebDriverManager.quitDriver();
		
	}
}
