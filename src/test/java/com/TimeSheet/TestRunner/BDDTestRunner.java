package com.TimeSheet.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
	features = {"src/test/resources/EmployeeViewFeatures", "src/test/resources/AdminFeatureFiles","src/test/resources/ReportingManagerViewfeatures"}, 
	tags =   "@employee", 
	glue = {"com.EmployeeView.stepDefinitions", "com.AdminView.stepDefinitions","com.ReportingManagerView.stepDefinitions"}, 
	plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failedScripts.txt"
			,"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class BDDTestRunner {
	
	
}
