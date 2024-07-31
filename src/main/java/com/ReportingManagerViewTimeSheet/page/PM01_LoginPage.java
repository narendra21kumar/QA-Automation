package com.ReportingManagerViewTimeSheet.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.ConfigReader;
import com.TimeSheet.utils.Logs;

public class PM01_LoginPage {
	public WebDriver driver;

	public PM01_LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Continue with Microsoft']")
	WebElement ContinueWithMicrosoft;

	@FindBy(xpath = "//div/button[@id ='details-button']")
	WebElement advanceButton;

	@FindBy(xpath = "//body[@id='body']")
	WebElement unsafeURL;

	@FindBy(xpath = "//a[@id='proceed-link']")
	WebElement proceedlink;

	@FindBy(xpath = "//input[contains(@name,'loginfmt')]")
	WebElement emailId;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement emailNext;

	@FindBy(xpath = "//input[@name='passwd']")
	WebElement pwdText;

	@FindBy(id = "idSIButton9")
	WebElement signIn;

	@FindBy(xpath = "//input[contains(@type,'submit')]")
	WebElement staySigned;

	public void clickOnContinueWithMicrosoft() {
		CommonUtils.explicitlyWaitForElementandClick(ContinueWithMicrosoft, 10);
		Logs.info("Clicked on continue mirosoft");
	}
	public void clickAdvance() {
		System.out.println("Click Advance");
		CommonUtils.explicitlyWaitForElementandClick(advanceButton, 10);
		Logs.info("Clicked on advanced button");
	}
	public void clickUnsafeURL() {
		CommonUtils.explicitlyWaitForElementandClick(unsafeURL, 10);
		Logs.info("Clicked on unsafeurl");
	}
	public void getUsername() {
		String username = ConfigReader.getmanagerUsername();
		CommonUtils.explicitlyWaitForElementandClick(emailId, 10);
		CommonUtils.sendKeysToElement(emailId, username);
		Logs.info("Entered the username");
		CommonUtils.explicitlyWaitForElementandClick(emailNext, 10);
		Logs.info("Clicked on emailnext");
	}
	public void getPassword() {
		String password = ConfigReader.getManagerPassword();
		CommonUtils.explicitlyWaitForElementandClick(pwdText, 10);
		CommonUtils.sendKeysToElement(pwdText, password);
		Logs.info("Entered the password");
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(emailNext, 10);
		Logs.info("Clicked on email next");
	}
	public void staySigned() {
		CommonUtils.explicitlyWaitForElementandClick(staySigned, 10);
		Logs.info("Clicked on staysigned");
	}
	public void clickProceedLink() {
		CommonUtils.explicitlyWaitForElementandClick(proceedlink, 10);
		Logs.info("Click on proceedlink");
	}
	public void validateTitle(String title) {
		WebElement titleelement = driver.findElement(By.xpath("//*[@title='Timesheet Management']"));
		String titletext = titleelement.getText();
		Assert.assertEquals(titletext, title);
		Logs.info("Successfully validated the title");
	}
	public void getAdminUsername() {
		String username = ConfigReader.getAdminUsername();
		CommonUtils.explicitlyWaitForElementandClick(emailId, 10);
		Logs.info("Clicked on emailid");
		CommonUtils.sendKeysToElement(emailId, username);
		Logs.info("Entered the username");
		CommonUtils.explicitlyWaitForElementandClick(emailNext, 10);
		Logs.info("Clicked on emailnext");
	}
	public void getAdminPassword() {
		String password = ConfigReader.getAdminPassword();
		CommonUtils.explicitlyWaitForElementandClick(pwdText, 10);
		try {
			CommonUtils.sendKeysToElement(pwdText, password);
			Logs.info("Entered the password");
			CommonUtils.explicitlyWaitForElementandClick(emailNext, 10);
			Logs.info("Clicked on email next");
		} catch (Exception e) {
		}
	}
	public void doLogIn() {
		CommonUtils.waitFor(3);
		getUsername();
		getPassword();
		staySigned();
		CommonUtils.waitFor(3);
	}
	public void doLogInAsAdmin() {
		CommonUtils.waitFor(3);
		// clickOnContinueWithMicrosoft();
		getAdminUsername();
		// emailNext();
		getAdminPassword();
		staySigned();
		CommonUtils.waitFor(3);
	}
}
