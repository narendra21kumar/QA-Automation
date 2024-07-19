package com.EmployeeView.stepDefinitions;


import java.time.Duration;

import org.joda.time.LocalDateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.ConfigReader;
import com.TimeSheet.utils.WebDriverManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	  private static WebDriver driver;
	  private static ExtentReports extent;
	  private static ExtentTest logger;
	  
//	  @BeforeAll
//	  public static void setup() {
//		  extent =new ExtentReports();
//		  ExtentHtmlReporter report=new ExtentHtmlReporter("target/extent-report.html");
//		  report.config().setDocumentTitle("Cucumber Extent Report");
//		  report.config().setReportName("Skill Matrix Project");
//		  report.config().setEncoding("utf-8");
//		  extent.attachReporter(report);
//		  logger=extent.createTest("Skill Matrix Project");
//	  }

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
//        @After
//        public void waitBrow() {
//        	CommonUtils.waitFor(3);
//        }
}
