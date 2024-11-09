package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class WebDriverFactory {

    // Method to initialize WebDriver based on the browser name
    public static WebDriver getDriver(String browser) {
        WebDriver driver = null;

        switch (browser.toLowerCase()) {
            case "chrome":
                // Set ChromeDriver path
                System.setProperty("WebDriver.chrome.driver", "C:/chrome-win64/chrome-win64");
                driver = new ChromeDriver();
                break;

            case "firefox":
                // Set GeckoDriver path
                System.setProperty("WebDriver.gecko.driver", "C:/chrome-win64/geckodriver");

                //Enable headless mode for firefox
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                options.addArguments("--width=1920");  // Set width (optional)
                options.addArguments("--height=1080");  // Set height (optional)
                options.addArguments("--no-sandbox");  // For CI/CD environments
                driver = new FirefoxDriver(options);
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        return driver;
    }
}
