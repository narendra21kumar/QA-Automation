package com.ReportingManagerViewTimeSheet.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TimeSheet.utils.CommonUtils;

public class PM06_BulkApprovedPage {

	WebDriver driver;
	public PM06_BulkApprovedPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[@title=\"Submitted\"]")
	WebElement timesheetmanagementicon;
	
	@FindBy(xpath ="(//*[@class='MuiSvgIcon-root'])[1]")
	WebElement startdate;
	
	@FindBy(xpath ="(//*[@class='MuiSvgIcon-root'])[2]")
	WebElement enddate;
	
	@FindBy(xpath ="(//input[@type='checkbox'])[1]")
	WebElement checkbox;
	
	@FindBy(xpath ="//button[text()='Approve']")
	WebElement approvebtn;
	
	@FindBy(xpath ="//*[@placeholder=\"Search by name...\"]")
	WebElement searchbyname;
	
	
	
	public void timesheetsubmittedicon() {
		CommonUtils.explicitlyWaitForElementandClick(timesheetmanagementicon, 2);
	}
	
	public void selectstartandenddate() {
		CommonUtils.explicitlyWaitForElementandClick(startdate, 2);
		CommonUtils.CalenderSelectWithDate(driver, 1);
		CommonUtils.explicitlyWaitForElementandClick(enddate, 2);
		CommonUtils.CalenderSelectWithDate(driver, 2);
		
	}
	public void bulkapprove()
	{
		CommonUtils.JavaScriptExecutorClick(driver,checkbox);
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(approvebtn, 2);
		
	}
	
}
