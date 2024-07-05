
package com.ReportingManagerView.stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.TimeSheet.utils.BrowserManager;
import com.TimeSheet.utils.ConfigReader;
import com.TimeSheet.utils.WebDriverManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {

	private static ExtentReports extent;
	private static ExtentTest logger;
	private static WebDriver driver;
	BrowserManager browserManager = new BrowserManager();

	
	@Before
	public void setbrowser() {
		String URLBrowser = ConfigReader.matrixUrl();
		driver = WebDriverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URLBrowser);

	}
//	@BeforeAll
//	public static void setup() {
//		extent = new ExtentReports();
//		ExtentHtmlReporter report = new ExtentHtmlReporter("target/extent-report.html");
//		report.config().setDocumentTitle("Cucumber Extent Report");
//		report.config().setReportName("Skill Matrix Project");
//		report.config().setEncoding("utf-8");
//		extent.attachReporter(report);
//		logger = extent.createTest("Skill Matrix Project");
//	}
//
//	@Before
//	public void beforeScenarion() throws Throwable {
//		System.out.println("SETUP gets Executed");
//		String browser = ConfigReader.getBrowserType();
//		browserManager.startBrowser(browser);
//		Thread.sleep(3000);
//		String URLBrowser = ConfigReader.matrixUrl();
//		driver = BrowserManager.getDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get(URLBrowser);
//	}
//
//	public static void launchBrow() {
//
//	}

	@AfterStep
	public static void tearDown(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
	}

	@After
	public void quitBrow() {
		//WebDriverManager.quitDriver();
		//browserManager.quitBrowser();
	}
}
