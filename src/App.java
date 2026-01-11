import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void main(String[] args) throws Exception {
        
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://demoqa.com/webtables");
            System.out.println("Navigated to DemoQA Web Tables");

            int initialRowCount = getTableRowCount();
            System.out.println("Initial row count: " + initialRowCount);

            String newName = "John Doe";
            String newEmail = "john.doe@example.com";
            String newAge = "35";
            String newSalary = "50000";
            String newDept = "IT";

            clickAddButton();
            fillAddPersonForm(newName, newEmail, newAge, newSalary, newDept);
            System.out.println("Added new person: " + newName);

            Thread.sleep(1000);

            int newRowCount = getTableRowCount();
            System.out.println("New row count: " + newRowCount);

            if (newRowCount == initialRowCount + 1) {
                System.out.println("✓ Row count verification PASSED: " + initialRowCount + " -> " + newRowCount);
            } else {
                System.out.println("✗ Row count verification FAILED: Expected " + (initialRowCount + 1) + ", got " + newRowCount);
            }

            String newAge_Updated = "40";
            editPersonAge(newName, newAge_Updated);
            System.out.println("Edited age for " + newName + " to " + newAge_Updated);

            Thread.sleep(1000);

            String updatedAge = getPersonAge(newName);
            if (updatedAge.equals(newAge_Updated)) {
                System.out.println("✓ Age update verification PASSED: Age is now " + updatedAge);
            } else {
                System.out.println("✗ Age update verification FAILED: Expected " + newAge_Updated + ", got " + updatedAge);
            }

        } finally {
            driver.quit();
            System.out.println("Test completed and browser closed");
        }
    }

    private static int getTableRowCount() {
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='rt-tbody']/div[@class='rt-tr-group']"));
        return rows.size();
    }

    private static void clickAddButton() {
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton")));
        addButton.click();
    }

    private static void fillAddPersonForm(String name, String email, String age, String salary, String dept) throws Exception {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));

        driver.findElement(By.id("firstName")).sendKeys(name.split(" ")[0]);
        driver.findElement(By.id("lastName")).sendKeys(name.split(" ")[1]);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("age")).sendKeys(age);
        driver.findElement(By.id("salary")).sendKeys(salary);
        driver.findElement(By.id("department")).sendKeys(dept);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        Thread.sleep(500);
    }

    private static void editPersonAge(String personName, String newAge) throws Exception {
        String[] nameParts = personName.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts[1];

        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[contains(., '" + firstName + "') and contains(., '" + lastName + "')]//span[@title='Edit']")
        ));
        editButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("age")));
        WebElement ageField = driver.findElement(By.id("age"));
        
        ageField.clear();
        ageField.sendKeys(newAge);

        driver.findElement(By.id("submit")).click();

        Thread.sleep(500);
    }

    private static String getPersonAge(String personName) {
        String[] nameParts = personName.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts[1];

        WebElement ageCell = driver.findElement(By.xpath(
            "//div[contains(., '" + firstName + "') and contains(., '" + lastName + "')]//div[@class='rt-td'][3]"
        ));
        
        return ageCell.getText();
    }
}
