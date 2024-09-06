package com.AdminViewTimeSheet.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;

public class PA07_ApproveSelfTimesheetPage {
	WebDriver driver;
	String empid;

	public PA07_ApproveSelfTimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
	@FindBy(xpath = "//*[@class='PrivateSwitchBase-input MuiSwitch-input css-1m9pwf3']")
    WebElement enableToggle;
	
	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Approved']")
	WebElement approvedIcon;

	@FindBy(xpath = "//div[contains(@class, '_1PlWXS4_EMHgqB5ngxCevb')][1]")
	WebElement startDateSelectDrop;

	@FindBy(xpath = "//div[contains(@class, '_1PlWXS4_EMHgqB5ngxCevb')][2]")
	WebElement endDateSelectDrop;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement searchClient;

	@FindBy(xpath = "//button[contains(@title, 'Clear')]")
	WebElement disSelectClientFromDrpdwn;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement searchByName;

	@FindBy(xpath = "//button[contains(@class, 'MuiIconButton-sizeMedium') and @aria-label='Detail panel visibility toggle']")
	WebElement arrowIcontoExpandRecord;

	@FindBy(xpath = "//button[contains(@class, 'MuiIconButton-sizeMedium') and @aria-label='Approve Timesheet']")
	WebElement approveTimeSheetIcon;

	@FindBy(xpath = "//button[contains(@class, 'MuiIconButton-sizeMedium') and @aria-label='Reject Timesheet']")
	WebElement rejectTimeSheetIcon;

	@FindBy(xpath = "//input[contains(@id, 'checkbox_397')]")
	WebElement selectCheckBox;

	@FindBy(xpath = "//div[@class='rdp-caption_label']")
	WebElement monthYear;

	@FindBy(xpath = "//button[@name='previous-month']")
	WebElement previousmonthArrow;

	@FindBy(xpath = "//button[@name='next-month']")
	WebElement nextmonthArrow;
	
	@FindBy(xpath = "(//button[contains(@class, 'MuiIconButton-sizeMedium') and @aria-label='Detail panel visibility toggle'])[1]")
	WebElement ExpandArrowIcon;
	
	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Submitted']")
	WebElement submittedIcon;
	
	@FindBy(xpath = "//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//td[3]//div")
	List<WebElement> listOfEmpIds;
	
	@FindBy(xpath = "//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//td[8]")
	List<WebElement> subDateOfEmp;
	
	@FindBy(xpath ="(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]")
	WebElement checkbox;
	
	@FindBy(xpath ="//button[text()='Approve']")
	WebElement approvebtn;
	
//------------------------------------------------------------------------------------	
	
	public void enableToggle() {
		CommonUtils.waitFor(3);
		enableToggle.click();
		Logs.info("clicked on enable Toggle");
	}
	
	public void timeSheetSubmitted() {
		CommonUtils.waitFor(3);
		CommonUtils.explicitlyWaitForElementandClick(submittedIcon, 10);
		Logs.info("clicked on Timesheet Management page");
	}
	
	public void approveTimesheet(String empid) {		
		this.empid = empid;
		WebElement ApprovedEmpId = driver.findElement(By
				.xpath("//*[@title='" + empid + "']/following::td[8]/div[1]/button[@aria-label='Approve Timesheet']"));
		CommonUtils.explicitlyWaitForElementandClick(ApprovedEmpId, 10);
		Logs.info("clicked on approve icon to Approve the timesheet");
	}
	
	
//---------------------------------------------------------------------------------	
	public void clickonapprovedIcon() {
		CommonUtils.waitFor(3);
		CommonUtils.explicitlyWaitForElementandClick(approvedIcon, 10);
		Logs.info("clicked on Approved Page");
	}
	
	public void startCalendar() {
		CommonUtils.waitFor(3);
		CommonUtils.explicitlyWaitForElementandClick(startDateSelectDrop, 10);
		Logs.info("clicked on Start Calender Icon");
	}
	
	public void endCalendar() {
		CommonUtils.waitFor(3);
		CommonUtils.explicitlyWaitForElementandClick(endDateSelectDrop, 10);
		Logs.info("clicked on End Calender Icon");
	}
	
	public void verifyApprovedEmployees() {
		for(WebElement List : listOfEmpIds ) {
			
			String ListRetreived = List.getText();
			//System.out.println("required employee id : " + ListRetreived);
			if(ListRetreived.equals(empid)) {
			System.out.println("Verify Approved Employee id: "+ ListRetreived);
			Logs.info("Successfully Verified the Approve Timesheet in approved page");
			break;
			}   
			else {
				
				System.out.println("Employee ID not matched");
				Logs.info("Approved employee id is not Present in approved page");
			}
		}
	}
	
	public void verifyApprovedEmployeDate(String Date) {
		for(WebElement subDateList : subDateOfEmp ) {
			String listOfSubDate = subDateList.getText();
			//System.out.println("required employee id : " + ListRetreived);
			if(listOfSubDate.equals(Date)) {
			System.out.println("Verify Approved Employee id: "+ listOfSubDate);
			Logs.info("Successfully Verified the Approve Timesheet in approved page");
			break;
			}   
			else {
				
				System.out.println("Employee Submission date is  not matched");
				Logs.info("Approved employee id is not Present in approved page");
			}
		}
	}
	
	public void bulkApprove()
	{
		CommonUtils.waitFor(3);
		CommonUtils.JavaScriptExecutorClick(driver, checkbox);
		Logs.info("Selected the checkbox for bulkApprove");
		CommonUtils.waitFor(6);
		CommonUtils.explicitlyWaitForElementandClick(approvebtn, 2);
		Logs.info("SuccessFully Bulk approved the timesheets");
	}
	
}

/*
 
 
 	public void selectStartDateandMonthforSubmitted(String Startmonth, String Startdate) {
		CommonUtils.waitFor(3); 
		String monthNm = Startmonth.split(" ")[0].trim();
		System.out.println("Req value :" + monthNm);
		CommonUtils.waitFor(2);
		CommonUtils.clickMonthTab(monthNm, nextmonthArrow, previousmonthArrow, monthYear);
		CommonUtils.waitFor(2);
		WebElement reqDate = driver.findElement(By.xpath("//*[text()='" + Startdate + "']"));
		reqDate.click();
		Logs.info("Selected the start Week and month to Approve");
	}
 
	public void selectEndDateandMonthforSubmitted(String EndMonth, String EndDate) {
		CommonUtils.waitFor(3); 
		String monthNm = EndMonth.split(" ")[0].trim();
		System.out.println("Req value :" + monthNm);
		CommonUtils.waitFor(2);
		CommonUtils.clickMonthTab(monthNm, nextmonthArrow, previousmonthArrow, monthYear);
		CommonUtils.waitFor(2);
		WebElement reqDate = driver.findElement(By.xpath("//*[text()='" + EndDate + "']"));
		reqDate.click();
		CommonUtils.waitFor(3); 
		Logs.info("Selected the End Week and month to Approve");
	}
		public void selectStartDateandMonth(String Startmonth, String Startdate) {
		CommonUtils.waitFor(3); 
		String monthNm = Startmonth.split(" ")[0].trim();
		System.out.println("Req value :" + monthNm);
		CommonUtils.waitFor(2);
		CommonUtils.clickMonthTab(monthNm, nextmonthArrow, previousmonthArrow, monthYear);
		CommonUtils.waitFor(2);
		WebElement reqDate = driver.findElement(By.xpath("//*[text()='" + Startdate + "']"));
		reqDate.click();
		Logs.info("Selected the start Week and month to Approve");
	}
 
	public void selectEndDateandMonth(String EndMonth, String EndDate) {
		CommonUtils.waitFor(3); 
		String monthNm = EndMonth.split(" ")[0].trim();
		System.out.println("Req value :" + monthNm);
		CommonUtils.waitFor(2);
		CommonUtils.clickMonthTab(monthNm, nextmonthArrow, previousmonthArrow, monthYear);
		CommonUtils.waitFor(2);
		WebElement reqDate = driver.findElement(By.xpath("//*[text()='" + EndDate + "']"));
		reqDate.click();
		Logs.info("Selected the End Week and month to approve");
	}
	
 */
