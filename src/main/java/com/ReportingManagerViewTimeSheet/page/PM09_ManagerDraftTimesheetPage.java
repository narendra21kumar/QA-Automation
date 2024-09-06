package com.ReportingManagerViewTimeSheet.page;

import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;

public class PM09_ManagerDraftTimesheetPage {
	public WebDriver driver;

	public PM09_ManagerDraftTimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Create Timesheet']")
	WebElement createTimesheetIcon;

	@FindBy(xpath = "//*[@class='MuiSvgIcon-root']")
	WebElement calendarStartIcon;

	@FindBy(xpath = "//*[@name='previous-month']")
	WebElement PreviousMonthArrowIcon;

	@FindBy(xpath = "//*[@aria-label='Edit']")
	WebElement editicon;

	@FindBy(xpath = "//*[text()='View Timesheet']")
	WebElement viewTimesheetHeader;

	public void createTimesheetIcon() throws Exception {
		CommonUtils.explicitlyWaitForElementandClick(createTimesheetIcon, 10);
		Logs.info("Clicked on create timesheet page icon");
	}

	public void selectPastWeekDate() throws InterruptedException {
		CommonUtils.explicitlyWaitForElementandClick(calendarStartIcon, 5);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cal.add(Calendar.DATE, -7);
		Date pastDate = cal.getTime();
		int date = pastDate.getDate();
		WebElement availableDate=CommonUtils.convertIntTOWebElement(driver, date);
		//System.out.println(date);
       // boolean availableDate = true;
		if(availableDate.isSelected()) {
			CommonUtils.CalenderSelectWithDate(driver, date);	
			Thread.sleep(3000);
			Logs.info("Selected the past week date from calendar");
			System.out.println("if ");
		}
		else if(PreviousMonthArrowIcon.isEnabled()){
			CommonUtils.Click(PreviousMonthArrowIcon);
			Thread.sleep(3000);
			Logs.info("Clicked on previous month arrow and selected the past week date from calendar");
			CommonUtils.CalenderSelectWithDate(driver, date);
			System.out.println("past week"+pastDate);
			Thread.sleep(3000);
		}
	}

	public void verifyDraftFunctionality(String draftText) throws Exception {
		if (editicon.isDisplayed()) {
			System.out.println("Edit icon is displayed and verified the draft functionality ");
			Logs.info("Edit icon is displayed");
		} else {
			System.out.println("Edit is not displayed on view timesheet");
			Logs.info("Edit icon is not displayed");
		}
		String viewTimesheetText = viewTimesheetHeader.getText();
		Assert.assertEquals(viewTimesheetText, draftText);
		Logs.info("Validated the view timesheet text");
	}

}
