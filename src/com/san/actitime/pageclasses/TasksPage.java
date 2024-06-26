package com.san.actitime.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TasksPage{
	public void clickOnTasks(WebDriver driver) {
		driver.findElement(By.xpath("//div[text()='Tasks']")).click();
	}
	
	public void clickOnAddNew(WebDriver driver) {
		driver.findElement(By.xpath("//div[text()='Add New']")).click();
	}

}
