package AutomationProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

//import resources.ExtentReporterNG;

public class Listeners extends Base implements ITestListener{

	WebDriver driver;
//	ExtentTest test;
//	ExtentReports extent=ExtentReporterNG.getReportObject();
//	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
//		test= extent.createTest(result.getMethod().getMethodName());
//		extentTest.set(test);
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
//		extentTest.get().fail(result.getThrowable());
//		WebDriver driver =null;
//		String testMethodName =result.getMethod().getMethodName();
//		
//		try {
//			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//		} catch(Exception e)
//		{
//			
//		}
//		try {
//			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
	//	 TODO Auto-generated method stub
		String text = result.getMethod().getMethodName();
		TakesScreenshot t =  (TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		 //String desti = System.getProperty("user.dir")+"\\ScreenShots\\"+text+".png";
		File dest= new File("./screenshots/"+text+".png");
		try{
			FileUtils.copyFile(src, dest);
		}
		catch(Exception e) {
			
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
