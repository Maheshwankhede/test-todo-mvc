package com.qa.todo.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class utils {
	
	public void saveToDo(WebDriver driver) {
		driver.findElement(By.id("todo-input")).sendKeys(Keys.ENTER);
	}

	public void updateToDo(WebDriver driver) {
		driver.findElement(By.xpath("//main[@class='main']//li[1]")).sendKeys(Keys.ENTER);
	}
	
	public String getLeftToDoItemCount(WebDriver driver) {
		String letfCount = driver.findElement(By.xpath("//span[@class='todo-count']")).getText();
		return letfCount;
	}
}
