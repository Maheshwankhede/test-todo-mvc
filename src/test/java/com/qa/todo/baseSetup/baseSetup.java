package com.qa.todo.baseSetup;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseSetup {

	protected WebDriver driver;
	private static Properties properties;
	
	public static String getAppUrl() {
        return properties.getProperty("app_url");
    }
	
	@BeforeMethod
	public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
	}

	@AfterMethod
	public void closeBrowser() {
		if (driver != null) {
            driver.quit();
        }
	}
}
