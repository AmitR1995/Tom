package com.ExtentReportDemos;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class D02ForTestNG {
	WebDriver driver;
	ExtentSparkReporter htmlReport;
	//Report file
	ExtentReports report;
	//Actual report
	ExtentTest test1;
	
	@Test
	public void openGoogle() {
		test1 = report.createTest("Google Test");
		driver.get("https://www.google.com");
		System.out.println("Title: " + driver.getTitle());
		
		Assert.assertTrue(driver.getTitle().contains("Google"));
		
	}
	@Test
	public void openYahoo() {
		test1 = report.createTest("Yahoo Test");
		driver.get("https://www.yahoo.com/?guccounter=1");
		System.out.println("Title: " + driver.getTitle());
		
		Assert.assertTrue(driver.getTitle().contains("Google"));
		
	}
	@Test
	public void openBing() {
		test1 = report.createTest("Bing Test");
		driver.get("https://www.bing.com/");
		System.out.println("Title: " + driver.getTitle());
		
		throw new SkipException("Skiping this test case");
	}
	

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE)
		{
			test1.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
			test1.fail(result.getThrowable());
		}
		else if (result.getStatus() == ITestResult.SUCCESS)
			test1.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		else if (result.getStatus() == ITestResult.SKIP)
			test1.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));
	}

	@BeforeClass
	public void beforeClass() {
		htmlReport = new ExtentSparkReporter("MyNewReport.html");
		report = new ExtentReports();
		//Attach report to file
		report.attachReporter(htmlReport);
		
		report.setSystemInfo("Machine Name", "Dell");
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("User", "Ajay");
		report.setSystemInfo("Browser", "Google Chrome");
		
		htmlReport.config().setDocumentTitle("My First Report");
		htmlReport.config().setReportName("My Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setTimeStampFormat("EEEE MMMM dd yyyy, hh:mm a '('zzz')'");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	@AfterClass
	public void afterClass() {
		report.flush();
		driver.close();
	}

}
