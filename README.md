# Test Automation Project README

## Overview

This test automation project aims to automate the testing of a web-based Todo application. The application allows users to manage their tasks by adding, editing, completing, and deleting todo items. The automation tests are designed to verify the functionality and user experience of the application across different scenarios.

## Tools and Technologies Used
* Java
* Selenium WebDriver
* TestNG
* WebDriverManager
* ChromeDriver
* Maven

## Project Structure
The project is organized using the Page Object Model (POM) design pattern to improve code readability, reusability, and maintenance. Here's the directory structure:


![image](https://github.com/Maheshwankhede/test-todo-mvc/assets/47474639/2695d9c0-9f22-4074-b347-d5fee38981f6)

* baseSetup: Contains the BaseSetup class responsible for setting up and tearing down the WebDriver instance.
* pages: Contains Page Object classes representing different pages of the application (e.g., TodoPage).
* tests: Contains test classes (e.g., TodoTests) that define test cases using TestNG annotations.
* utils: Contains utility classes such as ConfigReader for reading configuration properties.

## Test Organization
Tests are organized into separate classes based on functionality or user flows. Each test class contains multiple test methods, each testing a specific feature or scenario. Test methods are annotated with TestNG annotations such as @Test, @BeforeMethod, and @AfterMethod to define test execution order and setup/teardown actions.

## Reporting
TestNG generates HTML reports by default, providing detailed information about test results, including passed, failed, and skipped tests, along with stack traces for failures. Additionally, screenshots and logs can be captured during test execution to provide further insight into test failures.

![image](https://github.com/Maheshwankhede/test-todo-mvc/assets/47474639/f02428e1-bb57-45d6-8d2d-0fad80ef208e)


## Running Tests
Tests can be executed using a build automation tool such as Maven. Simply navigate to the project directory and run the following Maven command:

`mvn clean test`


This command will compile the project, execute the tests, and generate TestNG reports in the target/surefire-reports directory.

## Conclusion
This test automation project follows best practices in test automation, including code organization, design patterns, and reporting mechanisms. It provides comprehensive test coverage for the Todo application, ensuring its functionality and user experience meet the expected requirements.
