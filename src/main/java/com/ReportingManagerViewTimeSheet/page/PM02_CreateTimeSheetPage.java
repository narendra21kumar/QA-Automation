package com.ReportingManagerViewTimeSheet.page;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TimeSheet.utils.CommonUtils;

public class PM02_CreateTimeSheetPage {

	WebDriver driver;

	public PM02_CreateTimeSheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Create Timesheet']")
	WebElement createTimesheetIcon;

	@FindBy(xpath = "//*[@aria-label='Select Week']")
	WebElement startDateSelectDrop;

	@FindBy(xpath = "//div[contains(text(),'Client CP')]")
	WebElement selectProject;

	@FindBy(xpath = ("//tr[1]/td[@class='MuiTableCell-root MuiTableCell-body']/textarea[@rows='1']"))
	WebElement taskdescription;
	@FindBy(xpath = "//div[contains(text(),'Engineering')]")
	WebElement selectCategoryDrop;

	@FindBy(xpath = "//div[contains(text(),'Technical Meeting')]")
	WebElement selectSubCategoryDrop;

	@FindBy(xpath = "//div[@class='MuiBox-root jss5']//*[name()='svg']")
	WebElement clickAddRowIcon;

	@FindBy(xpath = "(//div[@class='MuiBox-root jss5']//*[name()='svg'])[2]")
	WebElement clickSaveIcon;

	@FindBy(xpath = "(//div[@class='MuiBox-root jss5']//*[name()='svg'])[3]")
	WebElement clickCancelIcon;

	@FindBy(css = "//tbody/tr[1]/td[12]//*[name()='svg']//*[name()='path' and contains(@d,'M6 19c0 1.')]")
	WebElement clickDeleteIcon;
	@FindBy(xpath = "//*[@class='MuiInputBase-input MuiInput-input']")
	List<WebElement> dayslist;
	@FindBy(xpath = "//*[@aria-label='Save all']")
	WebElement saveall;

	@FindBy(xpath = "//*[text()='Submit']")
	WebElement submit;
	@FindBy(xpath = "//*[text()='Confirm']")
	WebElement confirm;

	public void saveSubmitConform() {
		CommonUtils.waitFor(2);
		saveall.click();
		CommonUtils.waitFor(2);
		submit.click();
		CommonUtils.waitFor(2);
		confirm.click();
	}

	public void CreateTimesheet() throws Exception {
		CommonUtils.explicitlyWaitForElementandClick(createTimesheetIcon, 2);
		CommonUtils.explicitlyWaitForElementandClick(startDateSelectDrop, 2);
		CommonUtils.CalenderSelectWithDate(driver, 12);
		CommonUtils.taskDesccategoryandEnteringHours(driver, "14th Week");
	}
	public void CreateTimesheetForApproval() throws Exception {
		CommonUtils.explicitlyWaitForElementandClick(createTimesheetIcon, 2);
		CommonUtils.explicitlyWaitForElementandClick(startDateSelectDrop, 2);
		CommonUtils.CalenderSelectWithDate(driver, 9);
		CommonUtils.taskDesccategoryandEnteringHours(driver, "14th Week");
	}
}