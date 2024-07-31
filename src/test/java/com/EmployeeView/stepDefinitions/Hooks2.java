//package com.EmployeeView.stepDefinitions;
//
//import java.time.Duration;
//
//import org.junit.After;
//import org.junit.Before;
//import org.openqa.selenium.WebDriver;
//
//import com.TimeSheet.utils.BrowserManager;
//import com.TimeSheet.utils.ConfigReader;
//
//public class Hooks {
//
//	  static WebDriver driver;
//	  BrowserManager browserManager=new BrowserManager();
//	  
//	  @Before
//		public void beforeScenarion() throws Throwable {
//        System.out.println("SETUP gets Executed");
//        String browser = ConfigReader.getBrowserType();
//		browserManager.startBrowser(browser);
//        Thread.sleep(3000);
//  	  	String URLBrowser = ConfigReader.matrixUrl();
//  		driver = BrowserManager.getDriver();
//  		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));			
//  	    driver.get(URLBrowser);  
//	  }
//
//		@After
//		public void quitBrow() {
//		 browserManager.quitBrowser();
//		}
//}


