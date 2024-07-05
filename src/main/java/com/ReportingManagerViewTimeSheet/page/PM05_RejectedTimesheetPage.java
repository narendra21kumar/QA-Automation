package com.ReportingManagerViewTimeSheet.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;

public class PM05_RejectedTimesheetPage {
	WebDriver driver;

	public PM05_RejectedTimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Rejected']")
	WebElement rejectedIcon;
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
	@FindBy(xpath = "//tbody/tr[1]/td[1]/button[1]//*[name()='svg']")
	WebElement arrowIcontoExpandRecord;
	@FindBy(xpath = "(//input[contains(@id, 'checkbox')])[1]")
	WebElement selectCheckBox;
	@FindBy(xpath = "//*[@class='PrivateSwitchBase-input MuiSwitch-input css-1m9pwf3']")
	WebElement ShowselfTimesheetIcon;

	public void rejectIcon() {
		rejectedIcon.click();
		CommonUtils.waitFor(2);
	}

	public void selectweekDate() {
		CommonUtils.explicitlyWaitForElementandClick(startDateSelectDrop, 2);
		CommonUtils.CalenderSelectWithDate(driver, 5);
		CommonUtils.waitFor(2);
		CommonUtils.JavaScriptExecutorClick(driver, ShowselfTimesheetIcon);
		CommonUtils.waitFor(2);
	}

	public void ExpandArrowToVerify(String date) {
		WebElement e = driver.findElement(By.xpath("((//*[text()='" + date + "'])//preceding-sibling::td)[1]"));
		CommonUtils.explicitlyWaitForElementandClick(arrowIcontoExpandRecord, 10);
		String RejectedText = driver
				.findElement(
						By.xpath("((//*[text()='" + date + "'])//preceding-sibling::td)[6]/div[@title='Rejected']"))
				.getText();
		Assert.assertEquals(RejectedText, "Rejected");
	}
}