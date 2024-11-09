package stepdefinitions;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class PurchasePage {
    WebDriver driver;

    // Locators for the product page
    By backPack = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    By bikeLight = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
    By cartLink = By.xpath("//a[@class='shopping_cart_link']");
    By checkOutButton = By.xpath("//button[@id='checkout']");
    By cartItem = By.xpath("//div[@class='cart-item']");
    By firstName = By.xpath("//input[@id='first-name']");
    By lastName = By.xpath("//input[@id='last-name']");
    By postalCode = By.xpath("//input[@id='postal-code']");
    By continueButton = By.xpath("//input[@id='continue']");

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
    }


    // Method to add the product to the cart
    public void addProductToCart() {

        driver.findElement(backPack).click();
        driver.findElement(bikeLight).click();
    }

    // Method to navigate to the cart page
    public void goToCart() {
        driver.findElement(cartLink).click();

        //Assertion to check product is in cart
        WebElement slb = driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']"));
        assertTrue(slb.isDisplayed());

        WebElement slbl = driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Bike Light']"));
        assertTrue(slbl.isDisplayed());

        driver.findElement(checkOutButton).click();
    }

    public void checkOut() {

        driver.findElement(firstName).sendKeys("John");
        driver.findElement(lastName).sendKeys("Doe");
        driver.findElement(postalCode).sendKeys("12345");
        driver.findElement(continueButton).click();
    }

    public void confirmPurchase() {


        String totalPrice = driver.findElement(By.xpath("(//div[@class='summary_total_label'])[1]")).getText();
        Assert.assertEquals(totalPrice, "43.18", "43.18");

        driver.findElement(By.xpath("//button[@id='finish']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        String orderConfirm = driver.findElement(By.xpath("//h2[normalize-space()='Thank you for your order!']")).getText();
        Assert.assertEquals(orderConfirm, "Thank you for your order!", "Thank you for your order!");
    }

    public void purchase_done() throws IOException {

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("screenshot.png"));

        driver.quit();
    }

}
