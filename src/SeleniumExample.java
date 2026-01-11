import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class SeleniumExample {
    public static void main(String[] args) throws Exception {
        // Initialize WebDriver
        System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        // Create explicit wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Navigate to a website
            driver.get("https://example.com");
            System.out.println("Page title: " + driver.getTitle());

            // Find elements using different locators
            
            // 1. By ID
            WebElement elementById = driver.findElement(By.id("elementId"));
            
            // 2. By CSS Selector
            WebElement elementByCSS = driver.findElement(By.cssSelector(".className"));
            
            // 3. By XPath
            WebElement elementByXPath = driver.findElement(By.xpath("//button[@id='submit']"));
            
            // 4. By Class Name
            WebElement elementByClass = driver.findElement(By.className("buttonClass"));
            
            // 5. By Name
            WebElement elementByName = driver.findElement(By.name("fieldName"));
            
            // 6. By Link Text
            WebElement elementByLink = driver.findElement(By.linkText("Click Here"));
            
            // 7. By Partial Link Text
            WebElement elementByPartialLink = driver.findElement(By.partialLinkText("Click"));

            // Explicit Waits (Best Practice)
            
            // Wait for element to be clickable
            WebElement clickableElement = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("clickBtn"))
            );
            clickableElement.click();
            
            // Wait for element to be visible
            WebElement visibleElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("textElement"))
            );
            String text = visibleElement.getText();
            System.out.println("Text: " + text);
            
            // Wait for element to be invisible (disappear)
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));
            
            // Wait for element presence in DOM
            WebElement presentElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("newElement"))
            );

            // Interactions
            
            // Click
            elementById.click();
            
            // Send keys (typing)
            WebElement inputField = driver.findElement(By.id("inputField"));
            inputField.clear();
            inputField.sendKeys("Hello World");
            
            // Submit form
            inputField.submit();
            
            // Get text
            String elementText = elementById.getText();
            System.out.println("Element text: " + elementText);
            
            // Get attribute
            String attributeValue = elementById.getAttribute("data-value");
            System.out.println("Attribute: " + attributeValue);
            
            // Check if element is displayed
            boolean isDisplayed = elementById.isDisplayed();
            System.out.println("Is displayed: " + isDisplayed);
            
            // Check if element is enabled
            boolean isEnabled = elementById.isEnabled();
            System.out.println("Is enabled: " + isEnabled);
            
            // Check if element is selected
            boolean isSelected = elementById.isSelected();
            System.out.println("Is selected: " + isSelected);

            // Window and Navigation
            
            // Get current URL
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl);
            
            // Get page source
            String pageSource = driver.getPageSource();
            
            // Navigate back
            driver.navigate().back();
            
            // Navigate forward
            driver.navigate().forward();
            
            // Refresh
            driver.navigate().refresh();

            // Assertions (simple examples)
            assert elementText.equals("Expected Text") : "Text mismatch";
            assert isDisplayed : "Element not displayed";
            System.out.println("✓ All assertions passed");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}