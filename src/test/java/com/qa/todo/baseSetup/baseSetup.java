package com.qa.todo.baseSetup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseSetup {

	protected WebDriver driver;
	private static Properties properties;
	
	public static Properties init_properties() {
		properties = new Properties();

		try {			
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/qa/todo/utils/config.properties");
			properties.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("config file is missing, please check it...");
		} catch (IOException e) {
			System.out.println("properties could not be loaded...");
			e.printStackTrace();
		}
		return properties;
	}

	 public static String getAppUrl() {
	        // Initialize properties if not already initialized
	        if (properties == null) {
	            properties = init_properties();
	        }
	        return properties.getProperty("app_url");
	    }
	
	@BeforeClass
	public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println(getAppUrl());
        driver.get(getAppUrl());
	}

	@AfterClass
	public void closeBrowser() {
//		if (driver != null) {
//            driver.quit();
//        }
	}
}
