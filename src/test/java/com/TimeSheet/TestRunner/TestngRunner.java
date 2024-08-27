package com.TimeSheet.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		
	features = {"src/test/resources/EmployeeViewFeatures", "src/test/resources/AdminFeatureFiles","src/test/resources/ReportingManagerViewfeatures"}, 
	tags =   "@admin1", 
	glue = {"com.EmployeeView.stepDefinitions", "com.AdminView.stepDefinitions","com.ReportingManagerView.stepDefinitions"}, 
	plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
)
public class TestngRunner extends AbstractTestNGCucumberTests {
	
	
}
