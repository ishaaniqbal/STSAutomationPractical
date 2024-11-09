package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.WebDriverFactory;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    WebDriver driver;
    private LoginPage loginPage;

    @Given("User is on the login page")
    public void userIsOnTheLoginPage(String browser) {

        // Set up WebDriver and navigate to login page

        driver = WebDriverFactory.getDriver(browser);
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage(driver);

    }

    @When("User enters valid credentials")
    public void userEntersValidCredentials() {
        loginPage.login("validUser", "validPass");

    }

    @When("User enters invalid credentials")
    public void userEntersInvalidCredentials() {
        loginPage.login("invalidUser", "invalidPass");
    }

    @Then("User should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        // Assert that user is successfully logged in
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "https://www.saucedemo.com/inventory.html");
        driver.quit();
    }

    @Then("User should see an error message")
    public void userShouldSeeAnErrorMessage() {
        // Assert that an error message is displayed
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));
        assertTrue(errorMessage.isDisplayed());
        driver.quit();
    }
}