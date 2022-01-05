package com.automation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Helper {

	
	public static void takeScreenshot(WebDriver driver) {
		TakesScreenshot wb=((TakesScreenshot)driver);
		File src=wb.getScreenshotAs(OutputType.FILE);
		File dst=new File("./screenshots/"+setDate()+".png");
		try {
			FileHandler.copy(src,dst);
		} catch (IOException e) {
			
			System.out.println("Failed:"+e.getMessage());
		}
		
	}
	
	public static String setDate() {
		DateFormat sd=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return sd.format(currentDate);
	}
}
