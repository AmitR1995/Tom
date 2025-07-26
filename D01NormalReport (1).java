package com.ExtentReportDemos;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class D01NormalReport {

	public static void main(String[] args) {
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("MyReport.html");
		//Report file
		ExtentReports report = new ExtentReports();	
		//Actual report
		
		//Attach report to file
		report.attachReporter(htmlReport);
		
		ExtentTest test1;
		
		//Add env. details
		report.setSystemInfo("Machine Name", "Dell");
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("User", "Ajay");
		report.setSystemInfo("Browser", "Google Chrome");
		
		htmlReport.config().setDocumentTitle("My First Report");
		htmlReport.config().setReportName("My Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setTimeStampFormat("EEEE MMMM dd yyyy, hh:mm a '('zzz')'");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.fitpeo.com/revenue-calculator");
		System.out.println("Title: " + driver.getTitle());
		
		driver.close();
		
		test1 = report.createTest("RPM Test");
		test1.log(Status.PASS, MarkupHelper.createLabel("RPM Test: ", ExtentColor.GREEN));
		
		report.flush();	
		//GEnerates the report
	}

}
