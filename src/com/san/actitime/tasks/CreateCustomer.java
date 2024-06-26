package com.san.actitime.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.san.actitime.testbase.Baseclass;

public class CreateCustomer extends Baseclass {
  @Test
  public void testcreatecustomer() throws InterruptedException {
	  tp.clickOnTasks(driver);
	  Actions act = new Actions(driver);
	  tp.clickOnAddNew(driver);
	  WebElement newcustomer = driver.findElement(By.xpath("//div[text()='+ New Customer']"));
	  act.moveToElement(newcustomer);
	  newcustomer.click();
	  Thread.sleep(2000);
	  String custname = xlib.getExcelData("CreateCustomer", 1, 0);
	  String desc = xlib.getExcelData("CreateCustomer", 1, 1);
	  driver.findElement(By.xpath("//input[@class='inputFieldWithPlaceholder newNameField inputNameField']")).sendKeys(custname);
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys(desc);
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
	  Thread.sleep(2000);
	  
	  
	  
	  
  }
}
