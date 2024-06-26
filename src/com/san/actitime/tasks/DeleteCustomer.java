package com.san.actitime.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.san.actitime.testbase.Baseclass;

public class DeleteCustomer extends Baseclass {
  @Test
  public void testdeletecustomer() throws InterruptedException {
	  tp.clickOnTasks(driver);
	  Thread.sleep(2000);
	  String custname = xlib.getExcelData("DeleteCustomer", 1, 0);
	  driver.findElement(By.xpath("(//input[@placeholder='Start typing name ...'])[1]")).sendKeys(custname);
	  Thread.sleep(2000);
	  Actions act = new Actions(driver);
	  WebElement name = driver.findElement(By.xpath("//span[@class='highlightToken' and text()='"+custname+"']"));
	  Thread.sleep(2000);
	  act.moveToElement(name).perform();
	  Thread.sleep(2000);
	  WebElement set = driver.findElement(By.xpath("//span[text()='"+custname+"']/../../../div[@class='editButton']"));
	  act.moveToElement(set).perform();
	  set.click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("(//div[text()='ACTIONS'])[1]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("(//div[text()='Delete'])[2]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//span[text()='Delete permanently']")).click();
	  Thread.sleep(2000);
	  
	  
	  
	  
  }
}
