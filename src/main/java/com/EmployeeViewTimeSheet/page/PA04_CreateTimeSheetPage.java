package com.EmployeeViewTimeSheet.page;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TimeSheet.utils.CommonUtils;

public class PA04_CreateTimeSheetPage {
	WebDriver driver;

	public PA04_CreateTimeSheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Create Timesheet']")
	WebElement createTimesheetIcon;

	@FindBy(xpath = "//*[@aria-label='Select Week']")
	WebElement calendarStart;

	@FindBy(xpath = "//div[@class='rdp-caption_label']")
	WebElement monthYear;

	@FindBy(xpath = "//button[@name='previous-month']")
	WebElement previousmonthArrow;

	// button[@name='previous-month']
	@FindBy(xpath = "//button[@name='next-month']")
	WebElement nextmonthArrow;

	@FindBy(xpath = "//div[contains(text(),'Client CP')]")
	WebElement selectProject;

	@FindBy(xpath = "(//*/table/tbody/tr)//child::*[@class='MuiSvgIcon-root MuiSelect-icon']")
	List<WebElement> dropdownarrows;

	@FindBy(xpath = "(//*[@class='MuiSvgIcon-root MuiSelect-icon'])[1]")
	WebElement projectdropdownicon;

	@FindBy(xpath = "(//*[@class='_3C127Bu90msN4CSusQTzd1'])[1]")
	WebElement taskdescription1;

	@FindBy(xpath = "//*[text()='Engineering']")
	WebElement category;

	@FindBy(xpath = "//*[text()='Dev Coding']")
	WebElement subcategory;

	@FindBy(xpath = "//*[name()='path' and contains(@d,'M17 3H5c-1')]")
	WebElement saveall;

	@FindBy(xpath = "//*[text()='Submit']")
	WebElement submit;

	@FindBy(xpath = "//*[text()='Confirm']")
	WebElement confirm;

	@FindBy(xpath = "(//*[@class=\"MuiSvgIcon-root\"])[2]")
	WebElement editicon;

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Pending Approval']")
	WebElement pendingApprovalIcon;

	@FindBy(xpath = "//*[text()='View Timesheet']")
	WebElement viewTimesheetHeader;
	
	@FindBy(xpath = "//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//tr[*]//td[1]")
	List <WebElement> listOfEmployeeNames;
	
	@FindBy(xpath = "//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//tr[*]//td[5]")
	List <WebElement>  statusOfEmployeeFromeReports;

	public void CreateTimeSheetIconClick() {
		CommonUtils.explicitlyWaitForElementandClick(createTimesheetIcon, 10);
	}

	public void selectcalendar() {
		CommonUtils.waitFor(3);
		CommonUtils.explicitlyWaitForElementandClick(calendarStart, 15);
		CommonUtils.waitFor(3);

	}

	public void selectStartDateandMonth(String Startmonth, String Startdate) {
		CommonUtils.waitFor(3);
		String monthNm = Startmonth.split(" ")[0].trim();
		System.out.println("Req value :" + monthNm);
		CommonUtils.waitFor(2);
		CommonUtils.clickMonthTab(monthNm, nextmonthArrow, previousmonthArrow, monthYear);
		CommonUtils.waitFor(2);
		WebElement reqDate = driver.findElement(By.xpath("//*[text()='" + Startdate + "']"));
		System.out.println(reqDate.getText());
		CommonUtils.waitFor(2);
		reqDate.click();
	}

	public void enterTimeSheetDetails() throws Exception {
		CommonUtils.taskDesccategoryandEnteringHours(driver, "14th Week");
	}

	public void saveAll() {
		CommonUtils.waitFor(2);
		saveall.click();
	}

	public void submit() {
		CommonUtils.waitFor(2);
		submit.click();
	}

	public void confirm() {
		CommonUtils.clickElement(confirm);
		CommonUtils.waitFor(4);
	}

	
	public void verifyFromReports(String EmpName, String result) {		
		for(WebElement NamesOfEmployee : listOfEmployeeNames) {
			String nameOfEmployees = NamesOfEmployee.getText();
			   System.out.println(nameOfEmployees);
			if(nameOfEmployees.equalsIgnoreCase(EmpName)) {
				for(WebElement getStatusOfEmp : statusOfEmployeeFromeReports) {
				     String getEmpStatus = getStatusOfEmp.getText();
				     if(getEmpStatus.equalsIgnoreCase(result)) {
				    	 System.out.println(getEmpStatus);
				     }
				}
			}
		}
	}
	
	
}
