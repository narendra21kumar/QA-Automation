package com.ReportingManagerViewTimeSheet.page;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TimeSheet.utils.CommonUtils;

public class PM09_AssignManagerApprover {
	    WebDriver driver;
	    String sheet = "14th Week";

	public PM09_AssignManagerApprover(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Assign Manager/Approver']")
	WebElement assignMangerIcon;
	
	@FindBy(id = "clientSelect")
	WebElement selectClient;
	
	@FindBy(xpath = "//div[@data-value='%s']")
	WebElement selectDropDownValue;
	
	@FindBy(id = "teamSelect")
	WebElement selectTeam;
		
	public  void taskDesccategoryandEnteringHours(WebDriver driver, String Sheet) throws Exception {
		FileInputStream file = new FileInputStream("TestData/TestData.xlsx");
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet(Sheet);
		for (int a = 1; a <= 3; a++) {
			Row row = sheet.getRow(a);
			for (int x = 1; x <= 1; x++) {
				String Tasktitle = row.getCell(x).getStringCellValue();
				int b = x + 1;
				WebElement taskdesc = driver.findElement(
		       By.xpath("//*[@class='MuiTableBody-root']//tr[" + a + "]/td[" + b + "]/textarea[1]"));
				CommonUtils.actionsclasssendkeys(driver, taskdesc, Sheet);
				CommonUtils.waitFor(1);
			}
		}
	}
}

