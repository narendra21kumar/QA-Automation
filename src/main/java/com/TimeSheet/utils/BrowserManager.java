package com.TimeSheet.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserManager {
	
	OptionManager options=new OptionManager();

	public static WebDriver driver;

	public  WebDriver startBrowser(String browser) {
       String browserName = browser;
       if(browserName.equalsIgnoreCase("chrome")) {
    	   WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver(options.getChromeOptions());
	}
       else if(browserName.equalsIgnoreCase("edge")) {
    	   WebDriverManager.edgedriver().setup();
    	   driver = new EdgeDriver(options.getEdgeOptions());
       }
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.manage().window().maximize(); 
       return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	public void quitBrowser() {
		driver.quit();
	}
}
