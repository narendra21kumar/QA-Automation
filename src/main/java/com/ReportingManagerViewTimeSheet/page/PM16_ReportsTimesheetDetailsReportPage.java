package com.ReportingManagerViewTimeSheet.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;

public class PM16_ReportsTimesheetDetailsReportPage {
	public WebDriver driver;
	public PM16_ReportsTimesheetDetailsReportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@title='Reports']")
	WebElement reportspage;
	
	@FindBy(xpath="(//*[@class='MuiFormControl-root css-u1d4k'])[1]")
	WebElement dropdown;
	
	@FindBy(xpath="(//*[@role='listbox']/li)[2]")
	WebElement timesheetdetailreport;
	
	@FindBy(xpath="(//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv'])[1]")
	WebElement exportData;
	
	public static void scrollIntoElement(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		CommonUtils.waitFor(3);
	}
	public void reports() {
		CommonUtils.explicitlyWaitForElementandClick(reportspage, 10);
		Logs.info("Clicked on reports page icon");
	}
	public void timesheetDetailReport() {
		CommonUtils.explicitlyWaitForElementandClick(dropdown, 10);
		Logs.info("Clicked on dropdown");
		CommonUtils.explicitlyWaitForElementandClick(timesheetdetailreport, 10);
		Logs.info("Clicked on timesheet detail report");
		}
	public void export() {
		CommonUtils.explicitlyWaitForElementandClick(exportData, 10);
		Logs.info("Clicked on export data icon");
		CommonUtils.waitFor(3);

	}
	
}
