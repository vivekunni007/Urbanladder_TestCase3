package userDefinedLibraries;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsManager {
	
	public static ExtentReports report;
	public static ExtentTest test;
	
	public static ExtentReports generateExtentReport(){
		
		if(report==null){
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("extentReport.html");
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		//test=extent.createTest("Collections test","Test to  validate collections tab");
		}
		return report;
		
		
	}

}
