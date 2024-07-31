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

public class PM15_ReportsTimesheetSubmissionReportPage{

	
	public WebDriver driver;
	public PM15_ReportsTimesheetSubmissionReportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@title='Reports']")
	WebElement reportspage;
	
	@FindBy(xpath="(//*[@class='MuiFormControl-root css-u1d4k'])[1]")
	WebElement dropdown;
	
	@FindBy(xpath="(//*[@role='listbox']/li)[1]")
	WebElement timesheetsubmissionreport;
	
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
	public void timesheetSubmissionReport() {
		CommonUtils.explicitlyWaitForElementandClick(dropdown, 10);
		Logs.info("Clicked on dropdown");
		CommonUtils.explicitlyWaitForElementandClick(timesheetsubmissionreport, 10);
		Logs.info("Clicked on timesheet submission report");
		}
	public void export() {
		CommonUtils.explicitlyWaitForElementandClick(exportData, 10);
		Logs.info("Clicked on export data icon");
	}
	public void validatetotalhourstext(String totalhours) {
		WebElement ele=driver.findElement(By.xpath("(//*[@class='MuiTableCell-root MuiTableCell-head MuiTableCell-alignLeft MuiTableCell-sizeSmall css-194n8ko'])[10]")); 
		scrollIntoElement(driver, ele);
		String text=ele.getText();
		Assert.assertEquals(text, totalhours);
		Logs.info("Validated the total hours text");
		
	}
	
	}