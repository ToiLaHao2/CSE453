package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class WebFormSteps {
    private static WebDriver driver;
    private final String webFormUrl = "https://www.selenium.dev/selenium/web/web-form.html";

    @Before
    public void setUp() {
        if (driver == null) {
            // Cấu hình đường dẫn đến chromedriver theo đường dẫn tương đối hoặc tuyệt đối
            System.setProperty("webdriver.chrome.driver",
                    "D:\\CSE\\CSE453\\CSE453\\Lab7\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        driver.get(webFormUrl);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    // I. Navigate to the web form page
    @Given("I navigate to {string}")
    public void i_navigate_to(String url) {
        driver.get(url);
    }

    // II. Fill in fields: Text Input, Password, Text Area
    @When("I fill in {string} with {string}")
    public void i_fill_in_field_with(String fieldName, String value) {
        WebElement element;
        switch (fieldName) {
            case "Text Input":
                // Giả sử text input có attribute name là "my-text"
                element = driver.findElement(By.name("my-text"));
                break;
            case "Password":
                // Giả sử password input có attribute name là "my-password"
                element = driver.findElement(By.name("my-password"));
                break;
            case "Text Area":
                // Giả sử text area có attribute name là "my-textarea"
                element = driver.findElement(By.name("my-textarea"));
                break;
            default:
                throw new RuntimeException("Field not recognized: " + fieldName);
        }
        element.clear();
        element.sendKeys(value);
    }

    // III. Click the link "Return to index"
    @When("I click on the {string} link")
    public void i_click_on_the_link(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    // IV. Verify the title of the index page
    @Then("the page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Page title does not match", expectedTitle, actualTitle);
    }

    // V. Navigate back to the web form page
    @When("I navigate back to {string}")
    public void i_navigate_back_to(String url) {
        driver.get(url);
    }

    // VI. Select an option from the drop down (Select Field)
    @When("I select {string} from the {string} menu")
    public void i_select_from_the_menu(String option, String menuName) {
        // Sử dụng explicit wait để lấy element mới và đảm bảo element đã sẵn sàng
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement selectElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-select")));
        wait.until(ExpectedConditions.elementToBeClickable(selectElement));
        Select dropdown = new Select(selectElement);
        dropdown.selectByVisibleText(option);
    }

    // VII. Test that the Checked Check Box and Checked Radio Box are selected
    @Then("the {string} should be selected")
    public void the_element_should_be_selected(String elementName) {
        WebElement element;
        if (elementName.equals("Checked Check Box")) {
            // Giả sử checkbox có id là "my-check-1"
            element = driver.findElement(By.id("my-check-1"));
        } else if (elementName.equals("Checked Radio Box")) {
            // Giả sử radio button có id là "my-radio-1"
            element = driver.findElement(By.id("my-radio-1"));
        } else {
            throw new RuntimeException("Element not recognized: " + elementName);
        }
        Assert.assertTrue(elementName + " is not selected", element.isSelected());
    }

    // VIII. Find the Default Checkbox using a relative locator
    @When("I locate the {string} using a relative locator")
    public void i_locate_using_relative_locator(String elementName) {
        // Locate radio button as a reference element
        WebElement radioButton = driver.findElement(By.cssSelector("input[type='radio']"));
        // Locate default checkbox to the left of the radio button using Relative
        // Locator
        WebElement defaultCheckbox = driver.findElement(
                RelativeLocator.with(By.tagName("input")).toLeftOf(radioButton));
        // Kiểm tra xem default checkbox có được tìm thấy và có thuộc tính id hay không
        if (defaultCheckbox == null || defaultCheckbox.getAttribute("id") == null) {
            throw new AssertionError("Default checkbox not found or missing id attribute");
        }
        System.out.println("Located default checkbox: " + defaultCheckbox);
    }

    // IX. Change the color in the color picker
    @When("I change the {string} to {string}")
    public void i_change_the_color_picker(String fieldName, String color) {
        if (fieldName.equals("Color Picker")) {
            // Giả sử color picker có attribute name là "my-colors"
            WebElement colorPicker = driver.findElement(By.name("my-colors"));
            colorPicker.sendKeys(color);
        }
    }

    // X. Set a date in the Date Picker
    @When("I set the {string} to {string}")
    public void i_set_the_date_picker(String fieldName, String date) {
        if (fieldName.equals("Date Picker")) {
            // Giả sử date picker có attribute name là "my-date"
            WebElement datePicker = driver.findElement(By.name("my-date"));
            datePicker.sendKeys(date);
        }
    }

    // XI. Click the submit button
    @When("I click the {string} button")
    public void i_click_the_button(String buttonName) {
        if (buttonName.equals("Submit")) {
            // Giả sử nút submit là một button với thuộc tính type="submit"
            driver.findElement(By.cssSelector("button[type='submit']")).click();
        }
    }

    // XII. Test that the submission page shows the message "Received!"
    @Then("I should see the message {string} on the submission page")
    public void i_should_see_the_message_on_the_submission_page(String expectedMessage) {
        // Giả sử thông báo xác nhận có id là "message"
        WebElement messageElement = driver.findElement(By.id("message"));
        String actualMessage = messageElement.getText();
        Assert.assertEquals("Confirmation message does not match", expectedMessage, actualMessage);
    }
}
