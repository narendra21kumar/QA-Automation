package com.ReportingManagerViewTimeSheet.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;

public class PM08_VerifyManagerRejectedTimesheetPage {
	public WebDriver driver;

	public PM08_VerifyManagerRejectedTimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Rejected']")
	WebElement rejectedIcon;

	@FindBy(xpath = "//*[@class='PrivateSwitchBase-input MuiSwitch-input css-1m9pwf3']")
	WebElement ShowselfTimesheetIcon;

	@FindBy(xpath = "(//*[text()='Rejected'])[1]")
	WebElement rejectedText;

	public void rejectIcon() {
		CommonUtils.explicitlyWaitForElementandClick(rejectedIcon, 10);
		CommonUtils.waitFor(2);
		Logs.info("Clicked on reject icon");
	}

	public void showSelfTimesheetToggle() {
		CommonUtils.JavaScriptExecutorClick(driver, ShowselfTimesheetIcon);
		CommonUtils.waitFor(2);
		Logs.info("Clicked on show self timesheet toggle");

	}

	public void expandArrow() {
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(rejectedText, 10);
		CommonUtils.waitFor(2);
		Logs.info("Clicked on expand arrow");
	}

	public void verifyStatus() {
		String RejectedText = driver.findElement(By.xpath("(//*[@title='Rejected'])[2]")).getText();
		Assert.assertEquals(RejectedText, "Rejected");
		Logs.info("Validated the response as rejected timesheet status");
	}
}