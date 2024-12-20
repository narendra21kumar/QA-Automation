package com.TimeSheet.utils;
import com.epam.healenium.SelfHealingDriver;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class WebDriverManager {
   // private static WebDriver driver;
    static private SelfHealingDriver driver;
    
    public static WebDriver getDriver() {
        if (driver == null) {
        	
        	
            ChromeOptions options=new ChromeOptions();
//            options.addArguments("--no-sandbox");
//            options.addArguments("--disable-dev-shm-usage");
//            options.addArguments("--headless");

            String chromeArguments = ConfigReader.getChromeArguments();
            if(chromeArguments !=null && !chromeArguments.isEmpty())
            {
            	options.addArguments(chromeArguments.split("\\s+"));
            }
           
            WebDriver delegate = new ChromeDriver(options);
            driver= SelfHealingDriver.create(delegate);
            
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            CommonUtils.waitFor(2);
            driver.manage().deleteAllCookies();
            if (driver.manage().getCookies().isEmpty()) {
                System.out.println("All cookies are cleared.");
            } else {
                System.out.println("Cookies are not cleared.");
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

