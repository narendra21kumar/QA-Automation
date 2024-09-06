package com.AdminViewTimeSheet.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TimeSheet.utils.CommonUtils;

public class PA13_SendNotificationPage {
	public WebDriver driver;

	public PA13_SendNotificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@title='Send Notification']")
	WebElement sendnotificationpage;

	@FindBy(xpath = "(//*[@value=\"Yes\"])[1]")
	WebElement timesheetcreatedyesradiobtn;

	// @FindBy(xpath="(//*[@value='No'])[2]")
	// WebElement timesheetsubmittednoradiobtn;

	@FindBy(xpath = "//*[text()='Send Email']")
	WebElement sendemailbutton;

	public void sendnotificationpage() {
		CommonUtils.explicitlyWaitForElementandClick(sendnotificationpage, 10);
	}

	public void timesheetcreatedradiobutton() {
		CommonUtils.JavaScriptExecutorClick(driver, timesheetcreatedyesradiobtn);
	}

	public void sendemailbutton() {
		if (sendemailbutton.isEnabled()) {
			CommonUtils.explicitlyWaitForElementandClick(sendemailbutton, 10);
		} else {
			System.out.println("send email button is in disabled mode");
		}
	}

}
