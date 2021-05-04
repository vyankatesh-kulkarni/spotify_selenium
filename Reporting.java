package com.spotify.code;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest xTest;
	public WebDriver driver;
	
	public void onStart(ITestContext testContext) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report" + timeStamp + ".html";
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/Reports/" + repName);
		htmlReporter.config().setDocumentTitle("Automation Testing");
		htmlReporter.config().setReportName("Functional testing");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setAutoCreateRelativePathMedia(true);
		
		System.out.println("i am onStart");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("QA name", "vyankatesh");
		extent.setSystemInfo("OS", "windows 10");
	}
	
	public void onFinish(ITestContext testContext) {
		
		extent.flush();
	}
	
	
	public void onTestSuccess(ITestResult tr) {
		
		xTest = extent.createTest(tr.getName());
		xTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
		xTest.log(Status.PASS, "Test is Passed");
		
		System.out.println("i am onTestSuccess");
		
	}
	
	
	public void onTestFailure(ITestResult tr) {
		xTest = extent.createTest(tr.getName());
		xTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		xTest.log(Status.FAIL, "Test is failed");

		String screenshotpath = System.getProperty("user.dir")+"/Screenshots/" + tr.getName() + ".png";
	
		File file = new File(screenshotpath);
		
		if(file.exists()) {
			
			try {
				xTest.fail("Screenshot for test is failed is : " + xTest.addScreenCaptureFromPath(screenshotpath));			
			} catch(IOException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void onTestSkipped(ITestResult tr) {
		
		xTest = extent.createTest(tr.getName());
		xTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));
		xTest.log(Status.SKIP, "test is skipped");
	}

	
	


	/*
	
	public void onTestFailure(ITestResult result){
	//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
		if(ITestResult.FAILURE==result.getStatus()){
			try{
				// To create reference of TakesScreenshot
				TakesScreenshot screenshot=(TakesScreenshot)driver;
				// Call method to capture screenshot
				File src=screenshot.getScreenshotAs(OutputType.FILE);
				// Copy files to specific location 
				// result.getName() will return name of test case so that screenshot name will be same as test case name
				FileUtils.copyFile(src, new File("D:\\"+result.getName()+".png"));
				System.out.println("Successfully captured a screenshot");
			}catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
	}
	driver.quit();
	}
}
*/

}
	
