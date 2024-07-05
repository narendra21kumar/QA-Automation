package com.ReportingManagerViewTimeSheet.page;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.TimeSheet.utils.CommonUtils;

public class AdminApprovedTimeSheetPageForManager {
	static WebDriver driver;
	String empid;

	public AdminApprovedTimeSheetPageForManager(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Approved']")
	WebElement approvedIcon;

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

	@FindBy(xpath = "//button[contains(@class, 'MuiIconButton-sizeMedium') and @aria-label='Detail panel visibility toggle']")
	WebElement arrowIcontoExpandRecord;

	@FindBy(xpath = "//button[contains(@class, 'MuiIconButton-sizeMedium') and @aria-label='Approve Timesheet']")
	WebElement approveTimeSheetIcon;

	@FindBy(xpath = "//button[contains(@class, 'MuiIconButton-sizeMedium') and @aria-label='Reject Timesheet']")
	WebElement rejectTimeSheetIcon;

	@FindBy(xpath = "//input[contains(@id, 'checkbox_397')]")
	WebElement selectCheckBox;

	@FindBy(xpath = "//div[@class='rdp-caption_label']")
	WebElement monthYear;

	@FindBy(xpath = "//button[@name='previous-month']")
	WebElement previousmonthArrow;

	@FindBy(xpath = "//button[@name='next-month']")
	WebElement nextmonthArrow;
	
	@FindBy(xpath = "(//button[contains(@class, 'MuiIconButton-sizeMedium') and @aria-label='Detail panel visibility toggle'])[1]")
	WebElement ExpandArrowIcon;
	
	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Submitted']")
	WebElement submittedIcon;
	
	@FindBy(xpath = "//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//td[3]//div")
	List<WebElement> listOfEmpIds;
//------------------------------------------------------------------------------------	
	public void TimeSheetSubmitted() {
		CommonUtils.waitFor(3);
		CommonUtils.explicitlyWaitForElementandClick(submittedIcon, 10);
	}
	
	public void selectStartDateandMonthforSubmitted(String Startmonth, String Startdate) {
		CommonUtils.waitFor(3); 
		String monthNm = Startmonth.split(" ")[0].trim();
		System.out.println("Req value :" + monthNm);
		CommonUtils.waitFor(2);
		CommonUtils.clickMonthTab(monthNm, nextmonthArrow, previousmonthArrow, monthYear);
		CommonUtils.waitFor(2);
		WebElement reqDate = driver.findElement(By.xpath("//*[text()='" + Startdate + "']"));
		reqDate.click();
	}
 
	public void selectEndDateandMonthforSubmitted(String EndMonth, String EndDate) {
		CommonUtils.waitFor(3); 
		String monthNm = EndMonth.split(" ")[0].trim();
		System.out.println("Req value :" + monthNm);
		CommonUtils.waitFor(2);
		CommonUtils.clickMonthTab(monthNm, nextmonthArrow, previousmonthArrow, monthYear);
		CommonUtils.waitFor(2);
		WebElement reqDate = driver.findElement(By.xpath("//*[text()='" + EndDate + "']"));
		reqDate.click();
		CommonUtils.waitFor(3); 
	}
	
	public void approveTimesheet(String empid) {
	    try {
	        this.empid = empid;
	        WebElement ApprovedEmpId = driver.findElement(By
	                .xpath("//*[@title='" + empid + "']/following::td[8]/div[1]/button[@aria-label='Approve Timesheet']"));
	        CommonUtils.explicitlyWaitForElementandClick(ApprovedEmpId, 10);
	    } catch (NoSuchElementException e) {
	        // Handle the case when the element is not found
	        System.err.println("Error: Element not found. Check your XPath or wait time.");
	        // You can log the error or perform other actions here
	    } catch (Exception e) {
	        // Handle other exceptions (e.g., WebDriverException, TimeoutException, etc.)
	        System.err.println("Error: An unexpected exception occurred.");
	        e.printStackTrace();
	    }
	}

	
	
//---------------------------------------------------------------------------------	
	public void clickonapprovedIcon() {
		try {
	        CommonUtils.waitFor(3);
	        CommonUtils.explicitlyWaitForElementandClick(approvedIcon, 10);
	    } catch (Exception e) {
	        // Handle the case when the element is not found
	        System.err.println("No Records found to click on approved");
	        // You can log the error or perform other actions here
	    } 
	}
	
	public void startCalendar() {
		CommonUtils.waitFor(3);
		CommonUtils.explicitlyWaitForElementandClick(startDateSelectDrop, 10);
	}
	
	public void endCalendar() {
		CommonUtils.waitFor(3);
		CommonUtils.explicitlyWaitForElementandClick(endDateSelectDrop, 10);
	}
	
	public void selectStartDateandMonth(String Startmonth, String Startdate) {
		CommonUtils.waitFor(3); 
		String monthNm = Startmonth.split(" ")[0].trim();
		System.out.println("Req value :" + monthNm);
		CommonUtils.waitFor(2);
		CommonUtils.clickMonthTab(monthNm, nextmonthArrow, previousmonthArrow, monthYear);
		CommonUtils.waitFor(2);
		WebElement reqDate = driver.findElement(By.xpath("//*[text()='" + Startdate + "']"));
		reqDate.click();
	}
 
	public void selectEndDateandMonth(String EndMonth, String EndDate) {
		CommonUtils.waitFor(3); 
		String monthNm = EndMonth.split(" ")[0].trim();
		System.out.println("Req value :" + monthNm);
		CommonUtils.waitFor(2);
		CommonUtils.clickMonthTab(monthNm, nextmonthArrow, previousmonthArrow, monthYear);
		CommonUtils.waitFor(2);
		WebElement reqDate = driver.findElement(By.xpath("//*[text()='" + EndDate + "']"));
		reqDate.click();
	}
	
	public void verifyApprovedEmployees() {
		for(WebElement List : listOfEmpIds ) {
			
			String ListRetreived = List.getText();
			//System.out.println("required employee id : " + ListRetreived);
			if(ListRetreived.equals(empid)) {
			System.out.println("Verify Approved Employee id: "+ ListRetreived);
			break;
			}
			else {
				
				System.out.println("Employee ID not matched");
			}
		}
	}
		
}
