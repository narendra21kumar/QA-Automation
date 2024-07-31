package com.AdminViewTimeSheet.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;

public class PA13_AdminManageEmployeePage {
	WebDriver driver;

	public PA13_AdminManageEmployeePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@title,'Employee Master')]")
	WebElement ManageEmployeeIcon;
	
	@FindBy(xpath = "//div[contains(@class,'_2lLb2xCy2iqSCq9ycTeS90')]")
	WebElement ManageEmployeeName;
	
	public void clickManageEmpIcon() {
		CommonUtils.explicitlyWaitForElementandClick(ManageEmployeeIcon, 5);
		 Logs.info("clicked on ManageEmployee Page");
	}
	
	public void printManageEmpTitle() {
		String ActualText = ManageEmployeeName.getText();
		String ExpectedText = "Manage Employees";
        Assert.assertTrue(ActualText.contains(ExpectedText));
		System.out.println("Name of the Page is "+ ActualText );
		 Logs.info("Verified Successfully Title of the page in ManageEmployee");
	}
}
