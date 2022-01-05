package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	///POM Class
	@FindBy(name="username")
	private WebElement un;
	
	@FindBy(name="password")
	private WebElement pw;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	private WebElement clk;
	
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setLogin(String unm,String pwd) {
		un.sendKeys(unm);
		pw.sendKeys(pwd);
		clk.click();
	}

}
