package com.automation.tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.automation.utility.BrowserFactory;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//this is the base class for the framework
public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider ex;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setExcelData() {
		 ex=new ExcelDataProvider();	
		 
		 //Extent Reports
		 ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/TestReport.html"));
		 report=new ExtentReports();
		 report.attachReporter(extent);   
		 	
	}
	
	
	@BeforeClass
	public void setMethod() throws InterruptedException {
	driver=BrowserFactory.launchBrowser(driver,"Chrome","https://classic.freecrm.com/login.cfm");
	System.out.println(driver.getTitle());
	Thread.sleep(3000);
	String currentHandle= driver.getWindowHandle();
	driver.switchTo().newWindow(WindowType.TAB);
	driver.switchTo().newWindow(WindowType.TAB);
	driver.switchTo().window(currentHandle);
		}
	
	@AfterClass
	public void closeMethod() {
		BrowserFactory.closeBrowser(driver);
	}
	
	@AfterMethod
	public void screenshotMethod(ITestResult result) {
		if (result.getStatus()==ITestResult.FAILURE)
		Helper.takeScreenshot(driver);
		report.flush();
			}
	

	
}
