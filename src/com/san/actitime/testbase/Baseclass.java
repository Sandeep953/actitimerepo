package com.san.actitime.testbase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.san.actitime.pageclasses.TasksPage;

public class Baseclass {
	public WebDriver driver;
	public ExcelLibrary xlib;
	public TasksPage tp;
 @BeforeClass
  public void openBrowser() {
	  xlib = new ExcelLibrary();
	  tp = new TasksPage();
	  String browsername = xlib.getExcelData("Browser", 1, 0);
	  if(browsername.equals("chrome")) {
		  driver = new ChromeDriver();
	  }else if (browsername.equals("firefox")) {
		  driver = new FirefoxDriver();
		
	}else if (browsername.equals("edge")) {
		driver = new EdgeDriver();
		
	}
	  
	  driver.manage().window().maximize();
	  driver.get("https://online.actitime.com/lgsoft1/login.do");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  String expectedTitle = "actiTIME - Login";
	  String actualTitle = driver.getTitle();
	  Assert.assertEquals(actualTitle, expectedTitle);
	  
	  
  }
  @BeforeMethod
  public void login() { 
	  String un = xlib.getExcelData("Login", 1, 0);
	  String pw = xlib.getExcelData("Login", 1, 1);
	  driver.findElement(By.id("username")).sendKeys(un);
	  driver.findElement(By.name("pwd")).sendKeys(pw);
	  driver.findElement(By.id("loginButton")).click();
	  String expectedText = "Enter Time-Track for";
	  String actualText = driver.findElement(By.xpath("//h3[text()='Enter Time-Track for']")).getText();
	  Assert.assertEquals(actualText, expectedText);
	  
	  
  }
  @AfterMethod
  public void logout() throws InterruptedException {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logoutLink")));
	  //Thread.sleep(2000);
	  driver.findElement(By.id("logoutLink")).click();
  }
  @AfterClass
  public void closeBrowser() {
	  driver.close();
  }
  
}
