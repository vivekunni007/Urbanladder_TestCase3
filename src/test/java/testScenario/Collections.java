package testScenario;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;

//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.relevantcodes.extentreports.LogStatus;

//import com.relevantcodes.extentreports.LogStatus;

import objectRepository.Home_page;

import userDefinedLibraries.DriverSetup;

//import userDefinedLibraries.ExcelReadWrite;
import userDefinedLibraries.ExcelUtils;
import userDefinedLibraries.ExtentReportsManager;

public class Collections {

	public static WebDriver driver;
	public static Cell cell;
	public static XSSFSheet sheet;
	public static int rowNum;
	public static int item = 0;
	public static String[] resultSet;
	public static String browserType;
	public static List<WebElement> list;
	public static ExtentReports report;
	public static ExtentTest logger;

	@Parameters("browser")
	@BeforeClass
	public void driverconfig(String browser) {

		
		driver = DriverSetup.driverInstantiate(browser);
		report = ExtentReportsManager.generateExtentReport();
		logger = report.createTest("Being At Home Collections test");

	}

	@Test(priority = 0)
	public static void log() {

		if (driver.getTitle().equals(
				"Furniture Online: Buy Home Wooden Furniture Online In India At Best Price - Urban Ladder - Urban Ladder")) {
			// for pass status
			logger.log(Status.PASS, "Navigated to the home page of Urban Ladder successful");
		} else {
			// for fail status
			logger.log(Status.FAIL, "Navigated to the home page of Urban Ladder failed");
		}

	}

	@Parameters("browser")
	@Test(priority = 1)
	public static void getBeingAtHomeCollections(String browser) {

		Home_page.getPath();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			WebElement close = Home_page.getCloseButton(driver);
			wait.until(ExpectedConditions.visibilityOf(close));

			close.click();
			logger.log(Status.INFO, "Pop up closed successfully");

		} catch (NoAlertPresentException Ex) {
			System.out.println("alert was not present");
		}

		Actions action = new Actions(driver);
		// hover over the collections option
		WebElement collectionHover = Home_page.getCollections(driver);
		action.moveToElement(collectionHover).click().build().perform();
		// extracting collections items
		list = Home_page.getCollectionList(driver);
		logger.log(Status.INFO, "Items under Being At Home collections retrieved");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		// screenshot of being at home items
		// ss.takeSnapShot(driver, "./Screenshot/Being at home Items.jpg") ;
		System.out.println("Total being at home collections :" + list.size());
		logger.log(Status.INFO, "13 Being at Home Collection items are displayed");
		resultSet = new String[list.size()];
		for (WebElement el : list) {

			resultSet[item] = el.getText();
			System.out.println(resultSet[item]);
			item += 1;

		}

		browserType = browser;
		if (browserType.equalsIgnoreCase("opera")) {
			ExcelUtils.excelConfig();
			for (rowNum = 1, item = 0; rowNum <= list.size(); rowNum++, item++) {

				cell = ExcelUtils.sheet.createRow(rowNum).createCell(0);
				cell.setCellValue(resultSet[item]);
			}
			ExcelUtils.writeExcel();
			logger.log(Status.INFO, "Values written successfully");
		}

	}

	@AfterClass
	public void closeDriver() {
		report.flush();
		driver.close();
	}

}
