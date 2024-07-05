package com.ReportingManagerViewTimeSheet.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PM081_TimesheetManagementPage {

	WebDriver driver;

	public PM081_TimesheetManagementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Submitted']")
	WebElement submittedIcon;

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
	

}
