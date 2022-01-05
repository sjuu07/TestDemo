package com.automation.tests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.automation.pages.Login;
import com.automation.utility.Helper;

public class TestExecution extends BaseClass {
	
	@Test
	public void executeMethod() throws IOException {
		Login l=new Login(driver);
		logger=report.createTest("Login to CRM");
		logger.info("Logging IN");
		l.setLogin(ex.setData("Login",0,0),ex.setData("Login",0,1));
		
		logger.pass("Successful Login");
	
		
	}
	
	

}
