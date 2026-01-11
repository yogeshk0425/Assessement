# DemoQA Web Tables Test Automation

This project automates the testing of the DemoQA Web Tables functionality using Selenium WebDriver.

## Project Overview

The test performs the following tasks:
1. **Count rows** - Gets the initial row count in the web table
2. **Add a person** - Clicks the "Add" button and fills out a form to add a new person
3. **Verify count increase** - Confirms the row count increased by 1
4. **Edit person** - Finds the newly added person and clicks the Edit (pencil) icon to modify their age
5. **Verify update** - Confirms the age has been updated in the table

## Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher
- Google Chrome browser installed
- ChromeDriver (matching your Chrome version)

## Setup Instructions

1. **Install ChromeDriver**:
   - Download ChromeDriver from [ChromeDriver Downloads](https://chromedriver.chromium.org/)
   - Extract it and place it in the `lib/` folder of this project
   - Or let the WebDriverManager handle it automatically

2. **Install Dependencies**:
   ```bash
   mvn clean install
   ```

3. **Run the Test**:
   ```bash
   mvn exec:java
   ```

## Project Structure

- `src/` - Java source files
- `lib/` - External libraries and chromedriver
- `bin/` - Compiled output files
- `pom.xml` - Maven configuration with Selenium dependencies

## Test Output

The test will output:
- Initial and final row counts
- Confirmation of successful row count increase
- Confirmation of successful age update
- Test completion status

## Dependencies

- **Selenium WebDriver 4.15.0** - Browser automation
- **WebDriverManager 5.6.3** - Automatic driver management (optional)
