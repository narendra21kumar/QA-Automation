package com.EmployeeViewTimeSheet.page;
 
import java.time.Duration;
import java.util.List;
 
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
 
import com.TimeSheet.utils.CommonUtils;
 
public class ManagerLoginForApprovalPage {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	Actions act;
	String WeekStartDate;
	public ManagerLoginForApprovalPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
	@FindBy(xpath = "//a[contains(@title,'Submitted')]")
	WebElement SubmittedIcon;
	@FindBy(xpath = "(//*[@class='MuiSvgIcon-root'])[1]")
	WebElement calendarStart;
 
	@FindBy(xpath = "//div[@class='rdp-caption_label']")
	WebElement monthYear;
 
	@FindBy(xpath = "//button[@name='previous-month']")
	WebElement previousmonthArrow;
 
	@FindBy(xpath = "//button[@name='next-month']")
	WebElement nextmonthArrow;

	@FindBy(xpath = "//button[contains(@aria-label,'Approve Timesheet')]")
	WebElement ApprovedOKTimeSheet;

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Approved']")
	WebElement approvedIcon;
	
	@FindBy(xpath = "//*/table/tbody/tr")
	List<WebElement> Totaltable;

	@FindBy(xpath = "//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-alignLeft MuiTableCell-sizeMedium css-q34dxg']")
	List<WebElement> TotalElements;
	
	@FindBy(xpath = "(//*[@class='_2pnfWKxpUmAwFEMKV33FOI'])[1]")
	WebElement getEmpId;
	
	@FindBy(xpath = "//*[@title='1083']/following::td[8]/div[1]/button[@aria-label='Approve Timesheet']")
	WebElement ApproveTimesheetIcon;
	
	@FindBy(xpath = "//*[@title='1083']/following::td[8]/div[1]/button[2][@aria-label='Reject Timesheet']")
	WebElement RejectTimesheetIcon;
	
	@FindBy(xpath = "(//*[@title='1083']/ancestor::td//preceding-sibling::td)[1]")
	WebElement ExpandArrowIcon;

	public void approveTimesheet(String empid) {
		WebElement element = driver.findElement(By.xpath("//*[@title='" + empid + "']/following::td[8]/div[1]/button[@aria-label='Approve Timesheet']"));
		CommonUtils.explicitlyWaitForElementandClick(element, 10);
	}
 
	public void clickonTimeSheetMaangementIcon() {
		CommonUtils.explicitlyWaitForElementandClick(SubmittedIcon, 10);
	}
	public void startCalendar() {
		CommonUtils.waitFor(3);
		CommonUtils.explicitlyWaitForElementandClick(calendarStart, 10);
	}
	public void selectDate() {
		CommonUtils.CalenderSelectWithDate(driver,12);
	}
	public void getAttribute() {
		String empid=getEmpId.getText();
		approveTimesheet(empid);
	}
 
	public void EmpApprovedTimesheetandVerify() {
		
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(approvedIcon, 10);
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(calendarStart, 10);
		CommonUtils.CalenderSelectWithDate(driver,12);
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(ExpandArrowIcon, 10);
		CommonUtils.waitFor(5);				
		String ApprovedText = driver.findElement(By.xpath("//*[@title='1083']/following::td[4]/div[@title='Approved']")).getText();
		CommonUtils.waitFor(2);
		Assert.assertEquals(ApprovedText,"Approved");
		CommonUtils.waitFor(2);
	}
	}