package com.MyTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.junit.After;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class D03TrialTest {
	@Test
	public void test1() {
		System.out.println("\t\t\tTest 1");
	}
	@Test
	public void test2()
	{
		System.out.println("\t\t\tTest 2");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("\tBefore Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("\tAfter Class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("\t\tBefore Method");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("\t\tAfter Method");
	}

}
