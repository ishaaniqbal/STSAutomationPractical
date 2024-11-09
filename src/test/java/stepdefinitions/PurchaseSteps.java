package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PurchaseSteps {
    WebDriver driver;
    LoginPage loginPage;
    PurchasePage purchasePage;

    @Given("I am logged in to the application")
    public void i_am_logged_in_to_the_application() {
        System.setProperty("WebDriver.chrome.driver", "C:/chrome-win64/chrome-win64");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @When("I add the product to the cart")
    public void i_add_the_product_to_the_cart() {
        purchasePage.addProductToCart();
    }

    @And("I proceed to checkout")
    public void i_proceed_to_checkout() {
        purchasePage.goToCart();
        purchasePage.checkOut();
    }

    @Then("I should see the order confirmation message")
    public void i_should_see_the_order_confirmation_message() {

        String totalPrice = driver.findElement(By.xpath("(//div[@class='summary_total_label'])[1]")).getText();
        Assert.assertEquals(totalPrice, "43.18", "43.18");

        driver.findElement(By.xpath("//button[@id='finish']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        String orderConfirm = driver.findElement(By.xpath("//h2[normalize-space()='Thank you for your order!']")).getText();
        Assert.assertEquals(orderConfirm, "Thank you for your order!", "Thank you for your order!");

    }

    @Then("I Close the browser")
    public void tear_down()
    {
        driver.quit();
    }
}
