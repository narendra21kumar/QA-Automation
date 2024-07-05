package com.ReportingManagerViewTimeSheet.page;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.ConfigReader;
import com.TimeSheet.utils.Logs;


public class PM01_LoginPage {
	public WebDriver driver;
	
	private static final String TEST_DATA = "TestData/TestData.xlsx";
	private static By unsafeURL_locater = By.xpath("//body[@id='body']");

	public PM01_LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 
	@FindBy(xpath = "//div[text()='Continue with Microsoft']")
	private WebElement ContinueWithMicrosoft;

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

	//@FindBy(xpath = "//input[contains(@id,'idSI')]")
	@FindBy(id= "idSIButton9")
	
	WebElement signIn;

	@FindBy(xpath = "//input[contains(@type,'submit')]")
	WebElement staySigned;
	
	@FindBy(xpath = "//div/button[@id = 'details-button']")
	 WebElement advanceButton;

	public void getUsername() {
		String username = ConfigReader.getmanagerUsername();
		CommonUtils.explicitlyWaitForElementandClick(emailId, 10);
		CommonUtils.sendKeysToElement(emailId, username);
		Logs.info("Entered UserName");
	}
	public void getAdminUsername() {
		String username = ConfigReader.getAdminUsername();
		CommonUtils.explicitlyWaitForElementandClick(emailId, 10);
		CommonUtils.sendKeysToElement(emailId, username);

	}

	public void emailNext() {
		CommonUtils.explicitlyWaitForElementandClick(emailNext, 10);
	}

	public void clickUnsafeURL() {
		CommonUtils.explicitlyWaitForElementandClick(unsafeURL, 10);

	}

	public void clickproceedlink() {
		CommonUtils.explicitlyWaitForElementandClick(proceedlink, 10);

	}

	public void clickOnContinueWithMicrosoft() {
		CommonUtils.explicitlyWaitForElementandClick(ContinueWithMicrosoft, 10);

	}

	public void getPassword() {
		String password = ConfigReader.getManagerPassword();
		CommonUtils.explicitlyWaitForElementandClick(pwdText, 10);

			CommonUtils.sendKeysToElement(pwdText, password);

	}
	public void getAdminPassword() {
		String password = ConfigReader.getAdminPassword();
		CommonUtils.explicitlyWaitForElementandClick(pwdText, 10);
		
		try {
			CommonUtils.sendKeysToElement(pwdText, password);
		} catch(Exception e) {
			
		   // Logs.error("An exception", e);
		}

	}

	public void clickSignIn() {
		CommonUtils.explicitlyWaitForElementandClick(emailNext, 10);
		//Logs.fatal("er");
	}
	public void staySigned() {
		CommonUtils.explicitlyWaitForElementandClick(staySigned, 10);
	}

	public void clickAdvance() {
		System.out.println("Click Advance");
		advanceButton.click();
	}
	public WebDriver doLogIn() {
		
		Logs.initLogs(PM01_LoginPage.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
//		System.out.println("Heloowwww");
//		clickAdvance();
//		clickproceedlink();
//		CommonUtils.waitFor(3);
//		clickOnContinueWithMicrosoft();
		CommonUtils.waitFor(3);
		getUsername();
		emailNext();
		getPassword();
		clickSignIn();
		staySigned();
		CommonUtils.waitFor(3);
		//Logs.error("sucessfully");
	    Logs.endTestCase(this.getClass().getSimpleName());
		
		return driver;
	}
	public void doLogInAsAdmin() { 
        CommonUtils.waitFor(3);
		//clickOnContinueWithMicrosoft();
		CommonUtils.waitFor(3);
		getAdminUsername();
		emailNext();
		getAdminPassword();
		clickSignIn();
		staySigned();
		CommonUtils.waitFor(3);
      
	}
}
