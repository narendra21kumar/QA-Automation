package com.EmployeeViewTimeSheet.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.ConfigReader;
import com.TimeSheet.utils.Logs;

public class PE01_LoginPage {

	private WebDriver driver;

	public PE01_LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Continue with Microsoft']")
	private WebElement ContinueWithMicrosoft;

	@FindBy(xpath = "//body[@id='body']")
	private WebElement unsafeURL;

	@FindBy(xpath = "//a[@id='proceed-link']")
	private WebElement proceedlink;;

	@FindBy(xpath = "//input[contains(@name,'loginfmt')]")
	private WebElement emailId;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement emailNext;

	@FindBy(xpath = "//input[@name='passwd']")
	private WebElement pwdText;

	@FindBy(xpath = "//input[contains(@id,'idSI')]")
	private WebElement signIn;

	@FindBy(xpath = "//input[contains(@type,'submit')]")
	private WebElement staySigned;

	private void emailNext() {
		CommonUtils.explicitlyWaitForElementandClick(emailNext, 10);
	}

	private void clickSignIn() {
		CommonUtils.explicitlyWaitForElementandClick(emailNext, 10);
	}

	private void staySigned() {

		CommonUtils.explicitlyWaitForElementandClick(staySigned, 10);
	}

	public void doLogIn() {
		
		getmanagerUsername();
		Logs.info("Entered Username for Manager");
		emailNext();
		getManagerPassword();
		Logs.info("Entered Password for Manager");
		clickSignIn();
		staySigned();
		Logs.info("Successfully logged into Manager View");
		CommonUtils.waitFor(3);

	}

	private void getEmpUsername() {
		String username = ConfigReader.getUsername();
		CommonUtils.explicitlyWaitForElementandClick(emailId, 10);
		CommonUtils.sendKeysToElement(emailId, username);
		System.out.println(username);
	}

	private void getEmpPassword() {
		String password = ConfigReader.getPassword();
		CommonUtils.explicitlyWaitForElementandClick(pwdText, 10);
		CommonUtils.sendKeysToElement(pwdText, password);
		System.out.println(password);
	}

	private void getmanagerUsername() {
		String username = ConfigReader.getmanagerUsername();
		CommonUtils.explicitlyWaitForElementandClick(emailId, 10);
		CommonUtils.sendKeysToElement(emailId, username);

	}

	private void getManagerPassword() {
		String password = ConfigReader.getManagerPassword();
		CommonUtils.explicitlyWaitForElementandClick(pwdText, 10);
		CommonUtils.sendKeysToElement(pwdText, password);

	}

	private void getManUsername() {

		String Manusername = ConfigReader.getmanagerUsername();
		CommonUtils.explicitlyWaitForElementandClick(emailId, 10);
		CommonUtils.sendKeysToElement(emailId, Manusername);

	}

	private void getManPassword() {

		String Manpassword = ConfigReader.getManagerPassword();
		CommonUtils.explicitlyWaitForElementandClick(pwdText, 10);
		CommonUtils.sendKeysToElement(pwdText, Manpassword);

	}

	public void doLogInAsMananger() {
		getManUsername();
		emailNext();
		getManPassword();
		clickSignIn();
		staySigned();
		CommonUtils.waitFor(3);

	}

	public void doLogInAsEmp() {
		Logs.initLogs(PE01_LoginPage.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		getEmpUsername();
		Logs.info("Entered Username for Employee");
		emailNext();
		getEmpPassword();
		Logs.info("Entered Password for Employee");
		clickSignIn();
		CommonUtils.waitFor(3);
		staySigned();
		Logs.info("Successfully logged into Employee View");
		CommonUtils.waitFor(3);
	}

	public void verifyAccessAccordingToLogin() throws InterruptedException {
		WebElement usersName = driver.findElement(By.xpath("//*[@class='MuiStack-root css-vb6e92']//h5"));
		String getName = usersName.getText();
		Thread.sleep(3000);
		if (getName.contains("APPROVER")) {
			System.out.println("User Access to Approver as " + getName);
		} else if (getName.contains("ADMIN")) {
			System.out.println("User Access to Admin as " + getName);
		} else if (getName.contains("REPORTING_MANAGER")) {
			System.out.println("User Access to Reporting Manager as " + getName);
		} else {
			System.out.println("User Access to Employee View as " + getName);
		}
	}

	public void checkTitle(String titleOfPage) {
		String actualTitle = driver.getTitle();
		if (actualTitle.startsWith(titleOfPage)) {
			System.out.println("Page title matches the expected prefix: " + actualTitle);
		} else {
			System.out.println("Page title does not match the expected prefix.");
		}
	}

}
