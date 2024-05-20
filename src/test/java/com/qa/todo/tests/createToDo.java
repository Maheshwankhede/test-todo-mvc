package com.qa.todo.tests;
import org.openqa.selenium.JavascriptExecutor;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.qa.todo.baseSetup.baseSetup;
import com.qa.todo.utils.constants;
import com.qa.todo.utils.utils;

public class createToDo extends baseSetup {
	
	utils util = new utils();
	constants data = new constants();
	

	@Test(priority = 1)
	public void createNewToDoItemAndVerify() {
		driver.findElement(By.id("todo-input")).sendKeys(data.firstToDoItem);
		util.saveToDo(driver);
		
		String firstTodoItem = driver.findElement(By.xpath("//main/ul/li[1]/div/label")).getText();	
		assertEquals(data.firstToDoItem, firstTodoItem);
	}
	
	@Test(priority = 2)
	public void createSecondToDoItemAndVerify() {
		driver.findElement(By.id("todo-input")).sendKeys(data.secondToDoItem);
		util.saveToDo(driver);
		
		String firstTodoItem = driver.findElement(By.xpath("//main/ul/li[1]/div/label")).getText();	
		assertEquals(data.firstToDoItem, firstTodoItem);
		assertEquals("2 items left!", driver.findElement(By.xpath("//span[@class='todo-count']")).getText());
	}
	
	@Test(priority = 3)
	public void verifyCompletedFunctionlality() {
		driver.findElement(By.xpath("//li[1]//div[1]//input[1]")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Completed']")).click();
		String completedTodo = driver.findElement(By.xpath("(//div[@class='view'])[1]")).getText();
		assertEquals(data.firstToDoItem, completedTodo);
	}
	
	@Test(priority = 4)
	public void verifyCompletedToNonCompleted() {
		driver.findElement(By.xpath("//input[@class='toggle']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='All']")).click();
		String firstTodoItem = driver.findElement(By.xpath("//main/ul/li[1]/div/label")).getText();	
		assertEquals(data.firstToDoItem, firstTodoItem);
		
	}
	
	@Test(priority = 5)
	public void verifyClearCompletedWithougClearing() {
		driver.findElement(By.xpath("//a[normalize-space()='All']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='All']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Clear completed']")).click();
		assertEquals("2 items left!", driver.findElement(By.xpath("//span[@class='todo-count']")).getText());	
	}
	
	@Test(priority = 6)
	public void createNewTodowithSingleCharacter() {
		driver.findElement(By.id("todo-input")).clear();
		driver.findElement(By.id("todo-input")).sendKeys("A");
		util.saveToDo(driver);
		String firstTodoItem = driver.findElement(By.xpath("//main/ul/li[1]/div/label")).getText();	
		assertNotEquals("A", firstTodoItem);
	}
	
	@Test(priority = 7)
	public void updateFirstTodoItemAndVerify() {
		WebElement element = driver.findElement(By.xpath("//main/ul/li[1]/div/label"));
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
		act.sendKeys(element, data.firstToDoItem + " updated text");
		act.sendKeys(Keys.ENTER);
		String firstTodoItem = driver.findElement(By.xpath("//main/ul/li[1]/div/label")).getText();	
		assertEquals(data.firstToDoItem, firstTodoItem);
	}
	
	@Test(priority = 8)
	public void verifyAllItemsCompleted() {
		driver.findElement(By.xpath("//input[@class='toggle-all']")).click();
//		driver.findElement(By.xpath("//a[normalize-space()='Active']")).click();
		assertEquals("0 items left!", driver.findElement(By.xpath("//span[@class='todo-count']")).getText());
	}
	
	@Test(priority = 9)
	public void clearAllTodos() {
		driver.findElement(By.xpath("//button[normalize-space()='Clear completed']")).click();
		
	}
	
	
}
