package com.AdminViewTimeSheet.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.ConfigReader;
import com.TimeSheet.utils.Logs;

public class PA01_LoginPage {
	public WebDriver driver;
	// private static ExtentTest logger;
//	private static final String TEST_DATA = "TestData/TestData.xlsx";
//	private static By unsafeURL_locater = By.xpath("//body[@id='body']");

	public PA01_LoginPage(WebDriver driver) {
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

	private void getUsername() {
		String username = ConfigReader.getAdminUsername();
		CommonUtils.explicitlyWaitForElementandClick(emailId, 10);
		CommonUtils.sendKeysToElement(emailId, username);
		Logs.info("Entered username");
	}

	private void emailNext() {
		CommonUtils.explicitlyWaitForElementandClick(emailNext, 10);
		Logs.info("click on emailNext");
	}

//	private void clickUnsafeURL() {
//		CommonUtils.explicitlyWaitForElementandClick(unsafeURL, 10);
//		Logs.info("click on unsafeURL");
//	}
//
//	private void clickproceedlink() {
//		CommonUtils.explicitlyWaitForElementandClick(proceedlink, 10);
//		Logs.info("click on proceedlink");
//	}
//
//	private void clickOnContinueWithMicrosoft() {
//		CommonUtils.explicitlyWaitForElementandClick(ContinueWithMicrosoft, 10);
//		Logs.info("click on ContinueWithMicrosoft");
//	}

	private void getPassword() {
		String password = ConfigReader.getAdminPassword();
		CommonUtils.explicitlyWaitForElementandClick(pwdText, 10);
		CommonUtils.sendKeysToElement(pwdText, password);
		Logs.info("Entered password");
	}

	private void clickSignIn() {
		CommonUtils.explicitlyWaitForElementandClick(emailNext, 10);
		Logs.info("click on emailNext");
	}

	private void staySigned() {
		CommonUtils.explicitlyWaitForElementandClick(staySigned, 10);
		Logs.info("logIn successFully into admin view");
	}

	public void doLogIn() {
//		CommonUtils.waitFor(3);
//		clickOnContinueWithMicrosoft();
//		CommonUtils.waitFor(3);
		getUsername();
		emailNext();
		getPassword();
		clickSignIn();
		CommonUtils.waitFor(7);
		staySigned();
		CommonUtils.waitFor(3);

	}
	
	public void verifyAccessAccordingToLogin() {
	    WebElement usersName = driver.findElement(By.xpath("//*[@class='MuiStack-root css-vb6e92']//h5"));
	    String getName = usersName.getText();
	 
	    if (getName.contains("Approver")) {
	        System.out.println("User Access to Approver as " + getName);
	    } else if (getName.contains("ADMIN")) {
	        System.out.println("User Access to Admin as " + getName);
	    } else if (getName.contains("Reporting_Manager")) {
	        System.out.println("User Access to Reporting Manager as " + getName);
	    } else {
	        System.out.println("User Access to Employee View as " + getName);
	    }
	    Logs.info("Verified Names according to the Access");
	}

	
	public void checkTitle(String titleOfPage) {
	    String actualTitle = driver.getTitle();
	    
	    if (actualTitle.startsWith(titleOfPage))
	    {
	        System.out.println("Page title matches the expected prefix: " + actualTitle);
	    } else 
	    {
	        System.out.println("Page title does not match the expected prefix.");
	    }
	    Logs.info("Verified Title of the page");
	}

}
