//package com.AdminView.stepDefinitions;
//
//import java.time.Duration;
//
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//import com.TimeSheet.utils.ConfigReader;
//import com.TimeSheet.utils.WebDriverManager;
//
//import io.cucumber.java.After;
//import io.cucumber.java.AfterStep;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//
//public class Hooks {
//
//	private static WebDriver driver;
//	
////	@BeforeAll
////	public static void before() throws Throwable {
////		//Get browser Type from config file
//////		ConfigReader.loadConfig();
////		String browser = ConfigReader.getBrowserType();
////		WebDriverManager2 webdriver = new WebDriverManager2();
////		driver = WebDriverManager2.initializeDrivers(browser);
////	}
//
//	@Before
//	public void setbrowser() {
//		String URLBrowser = ConfigReader.matrixUrl();
//		driver = WebDriverManager.getDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get(URLBrowser);
//
//	}
//
////	@AfterStep
//	public static void tearDown(Scenario scenario) {
//			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//			scenario.attach(screenshot, "image/png", scenario.getName());	
//	}
//
////	s@After
////	public void quitBrow() {
////		WebDriverManager.quitDriver();
////	}
//}
