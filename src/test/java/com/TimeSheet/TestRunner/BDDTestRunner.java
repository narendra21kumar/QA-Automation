package com.TimeSheet.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
	features = {"src/test/resources/EmployeeViewfeatures"}, 
	tags =   "@employee", 
	glue = {"com.EmployeeView.stepDefinitions"}, 
	plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
)
public class BDDTestRunner {
	
	
}
