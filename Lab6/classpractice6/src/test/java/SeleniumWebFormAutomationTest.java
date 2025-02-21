import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.locators.RelativeLocator;
import java.time.Duration;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class SeleniumWebFormAutomationTest {

    private static WebDriver driver;
    private final String webFormUrl = "https://www.selenium.dev/selenium/web/web-form.html";
    private String[] inputTestData = { "Hello Selenium", "password123", "This is a sample input for the text area." };
    private String[] passwordTestData = { "password123", "password456", "password789" };
    private String[] textAreaTestData = { "This is a sample input for the text area.1",
            "This is another sample input for the text area.2", "This is a third sample input for the text area.3" };
    private String[] selectTestData = { "One", "Two", "Three" };

    @BeforeAll
    static void setUpClass() {
        System.setProperty("webdriver.chrome.driver",
                "../chromedriver-win64/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeEach
    void setUpTest() {
        driver.get(webFormUrl);
    }

    @AfterAll
    static void tearDownClass() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testTextInputAndPassword() {
        // Fill text input, password and text area; then verify their values.
        WebElement textInput = driver.findElement(By.name("my-text"));
        for (String dataTest : inputTestData) {
            textInput.clear();
            textInput.sendKeys(dataTest);
            assertEquals(dataTest, textInput.getAttribute("value"), "Text input mismatch");
        }

        WebElement passwordInput = driver.findElement(By.name("my-password"));
        for (String dataTest : passwordTestData) {
            passwordInput.clear();
            passwordInput.sendKeys(dataTest);
            assertEquals(dataTest, passwordInput.getAttribute("value"), "Password input mismatch");
        }

        WebElement textArea = driver.findElement(By.name("my-textarea"));
        for (String dataTest : textAreaTestData) {
            textArea.clear();
            textArea.sendKeys(dataTest);
            assertEquals(dataTest, textArea.getAttribute("value"), "Text area mismatch");
        }
    }

    @Test
    void testReturnLinkAndTitle() throws InterruptedException {
        WebElement returnLink = driver.findElement(By.linkText("Return to index"));
        returnLink.click();
        Thread.sleep(2000);
        String expectedTitle = "Index of Available Pages";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle, "Page title mismatch after clicking return link");
        driver.navigate().back();
        Thread.sleep(2000);
    }

    @Test
    void testSelectOptionInSelectOptionInDropdown() {
        // In the dropdown, select option "One" and verify it.
        WebElement selectElement = driver.findElement(By.name("my-select"));
        Select dropdown = new Select(selectElement);
        for (String dataTest : selectTestData) {
            dropdown.selectByVisibleText(dataTest);
            assertEquals(dataTest, dropdown.getFirstSelectedOption().getText(), "Selected option mismatch");
        }
    }

    @Test
    void testRadioButtons() {
        // Select the radio button "Option 2" and verify it.
        WebElement radioButton = driver.findElement(By.cssSelector("input[type='radio']"));
        radioButton.click();
        assertTrue(radioButton.isSelected(), "Radio button not selected");
    }

    @Test
    void testRelativeLocatorDefaultCheckbox() {
        // Using Relative Locator to locate the default checkbox to the left of the
        // radio button.
        WebElement radioButton = driver.findElement(By.cssSelector("input[type='radio']"));
        WebElement defaultCheckbox = driver
                .findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(radioButton));
        assertNotNull(defaultCheckbox, "Default checkbox not found");
        assertNotNull(defaultCheckbox.getAttribute("id"), "Default checkbox does not have an id attribute");
    }

    @Test
    void testChangeColor() throws InterruptedException {
        // Change the color picker and verify the new value.
        WebElement colorPicker = driver.findElement(By.name("my-colors"));
        colorPicker.clear();
        colorPicker.sendKeys("#ff0000");
        assertEquals("#ff0000", colorPicker.getAttribute("value"), "Color picker value mismatch");
        Thread.sleep(2000);
    }

    @Test
    void testSetDateInDatePicker() {
        // Set the date picker and verify the new date.
        WebElement datePicker = driver.findElement(By.name("my-date"));
        datePicker.clear();
        datePicker.sendKeys("2025-02-21");
        assertEquals("2025-02-21", datePicker.getAttribute("value"), "Date picker value mismatch");
    }

    @Test
    void testClickSubmitButton() throws InterruptedException {
        // Click the submit button and verify that the confirmation message "Received!"
        // is displayed.
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        Thread.sleep(2000);
        WebElement body = driver.findElement(By.tagName("body"));
        String bodyText = body.getText();
        assertTrue(bodyText.contains("Received!"), "Confirmation message 'Received!' not displayed");
    }
}
