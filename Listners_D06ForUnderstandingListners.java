package com.MyTests;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.*;
import org.testng.ITestListener;

public class Listners_D06ForUnderstandingListners implements ITestListener
{
	WebDriver driver;
	public void onStart(ITestContext result)
	{
		System.out.println("Test Started");
	}
	public void onFinish(ITestContext result)
	{
		System.out.println("Test Finish");
	}
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test Fail");
		//File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileHandler.copy(file, file);
	}
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test Skipped");
	}
	public void onTestStart(ITestResult result)
	{
		System.out.println("Test Case Started");
	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test Pass");
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}
	public void onTestFailedWithTimeout(ITestResult result)
	{
		
	}
}
