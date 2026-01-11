# Test Automation Project

This project contains multiple Selenium WebDriver test automation scripts for different websites.

## Tests Included

### 1. DemoQA Web Tables Test (`App.java`)

Automates testing of the DemoQA Web Tables functionality.

**Tasks:**
1. **Count rows** - Gets the initial row count in the web table
2. **Add a person** - Clicks the "Add" button and fills out a form to add a new person
3. **Verify count increase** - Confirms the row count increased by 1
4. **Edit person** - Finds the newly added person and clicks the Edit (pencil) icon to modify their age
5. **Verify update** - Confirms the age has been updated in the table

**Run command:**
```bash
mvn exec:java -Dexec.mainClass="App"
```

### 2. The Internet - Dynamic Loading Test (`DynamicLoadingTest.java`)

Automates testing of dynamic content loading on The Internet website.

**Tasks:**
1. **Click Start button** - Initiates the dynamic loading process
2. **Wait for loading** - Waits for the loading bar to disappear
3. **Wait for content** - Waits for the "Hello World!" text to appear
4. **Assert text** - Verifies the text matches exactly
5. **Headless mode** - Runs in headless browser mode for CI/CD
6. **Screenshot** - Captures screenshot of the final result

**Features:**
- Headless Chrome browser execution
- Automatic screenshot capture to `screenshots/` directory
- Comprehensive waits and explicit assertions
- Error handling with screenshot capture

**Run command:**
```bash
mvn exec:java -Dexec.mainClass="DynamicLoadingTest"
```

## Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher
- Google Chrome browser installed
- ChromeDriver (matching your Chrome version)

## Setup Instructions

1. **Install ChromeDriver**:
   - Download ChromeDriver from [ChromeDriver Downloads](https://chromedriver.chromium.org/)
   - Extract it and place it in the `lib/` folder of this project

2. **Install Dependencies**:
   ```bash
   mvn clean install
   ```

3. **Run Tests**:
   
   Run all tests:
   ```bash
   mvn clean install
   ```
   
   Run specific test:
   ```bash
   mvn exec:java -Dexec.mainClass="App"
   mvn exec:java -Dexec.mainClass="DynamicLoadingTest"
   ```

## Project Structure

- `src/App.java` - DemoQA Web Tables test
- `src/DynamicLoadingTest.java` - The Internet Dynamic Loading test
- `lib/` - External libraries and chromedriver
- `bin/` - Compiled output files
- `screenshots/` - Test result screenshots (created by tests)
- `pom.xml` - Maven configuration with Selenium dependencies

## Test Output

Each test will output:
- Navigation confirmation
- Action steps with status indicators (✓ for success, ✗ for failure)
- Assertion results
- Screenshot location (for Dynamic Loading test)
- Test completion status

## Dependencies

- **Selenium WebDriver 4.15.0** - Browser automation
- **WebDriverManager 5.6.3** - Automatic driver management (optional)

## Features

- ✓ Explicit waits for element visibility and clickability
- ✓ Comprehensive error handling
- ✓ Screenshot capture capabilities
- ✓ Headless browser mode support
- ✓ Detailed logging and assertions
- ✓ Maven integration for easy execution
