package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Resources.Base;

public class ExtentReport extends Base {

	static ExtentReports extentReport;
	public static ExtentReports getExtentReport() {
		
		String reportpath = System.getProperty("user.dir")+"\\Report\\ExtentReport.html";
		ExtentSparkReporter report=new ExtentSparkReporter(reportpath);
		report.config().setReportName("ExtentReport");
		report.config().setDocumentTitle("Mobile Test");
		
		extentReport=new ExtentReports();
		extentReport.attachReporter(report);
		extentReport.setSystemInfo("Operating System", "Windows 10");
		extentReport.setSystemInfo("Tested By", "Divya");
		return extentReport;
	}
}
