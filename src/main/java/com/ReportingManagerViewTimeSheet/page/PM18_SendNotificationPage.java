package com.ReportingManagerViewTimeSheet.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;

public class PM18_SendNotificationPage {

	
	public WebDriver driver;

	public PM18_SendNotificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@title='Send Notification']")
	WebElement sendnotificationpage;
	
	@FindBy(xpath="(//*[@value=\"Yes\"])[1]")
	WebElement timesheetcreatedyesradiobtn;
	
	@FindBy(xpath="//*[text()='There are no records to display']")
	WebElement norecords;
	
	@FindBy(xpath="(//*[@type='checkbox'])[1]")
	WebElement checkbox;
	
	
	@FindBy(xpath="//*[text()='Send Email']")
	WebElement sendemailbutton;
	
	
	public void sendnotificationpage() {
		CommonUtils.explicitlyWaitForElementandClick(sendnotificationpage, 10);
	}
	public void timesheetcreatedradiobutton() {
		CommonUtils.JavaScriptExecutorClick(driver,timesheetcreatedyesradiobtn);
	}
	
	public void emailcheckBox() {
		try {
			if(norecords.isDisplayed()) {
				System.out.println("no records for check the check box");
				Logs.info("There is no timesheet records for checking the checkbox");
			}
		} catch (Exception e) {
			e.getMessage();
			CommonUtils.JavaScriptExecutorClick(driver,checkbox);
			Logs.info("Clicked on checkbox");
		}
		
	}
	
	public void sendemailbutton() {
		if(sendemailbutton.isEnabled()) {
		CommonUtils.explicitlyWaitForElementandClick(sendemailbutton, 10);
		}
		else {
			System.out.println("send email button is in disabled mode");
		}
	}
	
}
