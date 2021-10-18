package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.BaseClass;
import utilities.ExtentReporter;

public class Listeners extends BaseClass implements ITestListener{
	ExtentTest extentTest;
	WebDriver driver=null;
	ExtentReports extentReport=ExtentReporter.getExtentReport();
	ThreadLocal<ExtentTest> extentTestThread=new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		
	String testName=result.getName();
	extentTest = extentReport.createTest(testName);
	extentTestThread.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName=result.getName();
		//extentTest.log(Status.PASS, testName+"got passed");
		extentTestThread.get().log(Status.PASS, testName+"got passed");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		
		String testName=result.getName();
		//extentTest.fail(result.getThrowable());
		extentTestThread.get().fail(result.getThrowable());
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			e1.printStackTrace();
		}
	try {
		String screenshotFilePath = takescreenShot(testName,driver);
		extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath,testName);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		
	}

}
