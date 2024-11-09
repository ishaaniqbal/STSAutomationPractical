package stepdefinitions;

import org.openqa.selenium.*;

public class LoginPage {
     WebDriver driver;

    // Locators for the login page
     By usernameField = By.xpath("//input[@id='user-name']");
     By passwordField = By.xpath("//input[@id='password']");
     By loginButton = By.xpath("//input[@id='login-button']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter username
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys();
    }

    // Method to enter password
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys();
    }

    // Method to click login button
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    // Method to perform login
    public void login(String usernameField, String passwordField) {
        enterUsername("standard_user");
        enterPassword("secret_sauce");
        clickLoginButton();
    }
}
