package com.ReportingManagerViewTimeSheet.page;

import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;

public class PM02_CreateCurrentWeekTimeSheetPage {
	WebDriver driver;

	public PM02_CreateCurrentWeekTimeSheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	String startdatetext;
	String enddatetext;

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Create Timesheet']")
	WebElement createTimesheetIcon;

	@FindBy(xpath = ("//*[@aria-label='Select Week']/following::label[2]"))
	WebElement startdate;

	@FindBy(xpath = ("//*[@aria-label='Select Week']/following::label[4]"))
	WebElement enddate;

	@FindBy(xpath = "(//*[@class=\"_3HctNa4SpoWtFT9b3gCxL\"])[1]")
	WebElement managerName;
	
	@FindBy(xpath = "(//*[@class=\"_3HctNa4SpoWtFT9b3gCxL\"])[2]")
	WebElement approverName;

	@FindBy(xpath = "//*[@aria-label='Save all']")
	WebElement saveall;

	@FindBy(xpath = "//*[text()='Submit']")
	WebElement submit;

	@FindBy(xpath = "//*[text()='Confirm']")
	WebElement confirm;

	public void createTimesheetIcon() throws Exception {
		CommonUtils.explicitlyWaitForElementandClick(createTimesheetIcon, 10);
		Logs.info("Clicked on create timesheet icon");
	}

	public void selectCurrentWeek() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cal.add(Calendar.DATE, 1);
		Date currentDate = cal.getTime();
		int date = currentDate.getDate();
		System.out.println(currentDate);
		Logs.info("Selected the currrent date from calendar");
	}

	public void managerName(String managername) {
 
		String managernametext = managerName.getText();
		System.out.println("manager name is : " + managernametext);
		Assert.assertEquals(managernametext, managername);
	}

	public void approverName(String approvername) {

		String approvernametext = approverName.getText();
		System.out.println("approver name is : " + approvernametext);
		Assert.assertEquals(approvernametext, approvername);
	}

	public void enterTaskDescriptionCategorySubcategory(String SheetName) throws Exception {
		startdatetext = startdate.getText();
		enddatetext = enddate.getText();
		System.out.println("printing the selected start week date " + " : " + startdatetext + " and end date is "
				+ " : " + enddatetext);
		CommonUtils.waitFor(2);
		CommonUtils.taskDesccategoryandEnteringHours(driver, SheetName);
		Logs.info("Entered the task description,category and hours");
	}

	public void saveIcon() {
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(saveall, 10);
		Logs.info("Clicked on saveall icon");
	}

	public void submitButton() {
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(submit, 10);
		Logs.info("Clicked on submit button");
	}

	public void confirmButton() {
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(confirm, 10);
		Logs.info("Clicked on confirm button");
	}

	public void validateTimesheetResponse() throws Exception {
		String alreadysubmittedtext = driver.findElement(By.xpath("//*[text()='Timesheet already submitted!']"))
				.getText();
		Assert.assertEquals(alreadysubmittedtext, "Timesheet already submitted!");
		Logs.info("Validated the response as timesheet already submitted");
	}
}