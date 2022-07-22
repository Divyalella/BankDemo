package Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.Base;

public class Listeners extends Base implements ITestListener {
	WebDriver driver=null;
	ExtentTest etest;
	ExtentReports eReport = ExtentReport.getExtentReport();
	ThreadLocal<ExtentTest> extentThread=new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		etest=eReport.createTest(result.getName()+"Execution started");
		extentThread.set(etest);
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		extentThread.get().log(Status.PASS,result.getName()+"Test success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String TestMethodName=result.getName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String ScreenshotPath=getScreenshot(TestMethodName,driver);
			extentThread.get().addScreenCaptureFromPath(ScreenshotPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onFinish(ITestContext context) {
		eReport.flush();
	}

	
	

}
