package com.TimeSheet.TestRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.TimeSheet.utils.ConfigReader;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = {"src/test/resources/EmployeeViewFeatures", "src/test/resources/AdminFeatureFiles","src/test/resources/ReportingManagerViewfeatures"}, 
		tags = "@admin1", 
		glue = {"com.EmployeeView.stepDefinitions", "com.AdminView.stepDefinitions","com.ReportingManagerView.stepDefinitions"},  
		monochrome = true,
		dryRun = false,
		plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
   
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
	@BeforeTest
	@Parameters({ "browser" })
	public void defineBrowser(String browser) throws Throwable {
		ConfigReader.setBrowserType(browser);
	}
}
