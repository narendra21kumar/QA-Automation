package com.TimeSheet.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
	features = {"src/test/resources/EmployeeViewFeatures", "src/test/resources/AdminFeatureFiles"}, 
	tags =   "@employee", 
	glue = {"com.EmployeeView.stepDefinitions", "com.AdminView.stepDefinitions" }, 
	plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
)
public class BDDTestRunner {
	
	
}
