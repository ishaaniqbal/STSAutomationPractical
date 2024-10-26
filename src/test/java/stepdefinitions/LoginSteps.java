package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class LoginSteps {
    WebDriver driver;
    @Given("I am on the login page")
    public void i_am_on_the_login_page() throws InterruptedException, IOException {
        String username;
        System.setProperty("WebDriver.chrome.driver", "C:/chrome-win64/chrome-win64");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "https://www.saucedemo.com/inventory.html");


        //purchase

        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();

        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();


        WebElement slb = driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']"));
        assertTrue(slb.isDisplayed());

        WebElement slbl = driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Bike Light']"));
        assertTrue(slbl.isDisplayed());

        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("John");
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Doe");
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("12345");

        driver.findElement(By.xpath("//input[@id='continue']")).click();


        WebElement total = driver.findElement(By.xpath("//div[@class='summary_total_label']"));


        String totalprice = driver.findElement(By.xpath("(//div[@class='summary_total_label'])[1]")).getText();
        Assert.assertEquals(totalprice, "43.18", "43.18");

        driver.findElement(By.xpath("//button[@id='finish']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        String orderconfirm = driver.findElement(By.xpath("//h2[normalize-space()='Thank you for your order!']")).getText();
        Assert.assertEquals(orderconfirm, "Thank you for your order!", "Thank you for your order!");

    }

    @When("I purchase asset")
    public void asset_purchase() throws InterruptedException {


        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(100));
        //log out from webpage


        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();


        WebElement logoutSidebarLink = driver.findElement(By.id("logout_sidebar_link"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", logoutSidebarLink);

        String expectedUrl = "https://www.saucedemo.com";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "https://www.saucedemo.com");

    }

    @Then("close browser")
    public void purchase_done() throws IOException {

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("screenshot.png"));

        driver.quit();
    }
}
