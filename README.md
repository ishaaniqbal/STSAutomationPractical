**Selenium Cucumber Test Framework with TestNG**

This project is a test automation framework that integrates Selenium WebDriver, Cucumber, and TestNG to automate end-to-end tests for a web application. It supports parallel execution on different browsers (Chrome, Firefox, Edge) and can be configured to run in headless mode for CI/CD environments.

**Prerequisites**
Java (Version 8 or higher)
Maven (Version 3.5 or higher)
IDE (e.g., IntelliJ IDEA, Eclipse)

**Setup Instructions**
1. Clone the Repository
Clone the repository to your local machine:

git clone https://github.com/ishaaniqbal/STSAutomationPractical/tree/master

**Install Dependencies**
Navigate to the project folder and run the following Maven command to download all the required dependencies:

mvn clean install

This will download the necessary Selenium, Cucumber, TestNG dependencies, and also the WebDriverManager for managing the browser drivers (Chrome, Firefox).

**Configure WebDriver**
The framework uses WebDriverManager to automatically download and manage the appropriate browser driver binaries (e.g., chromedriver, geckodriver, etc.). You do not need to manually download drivers; WebDriverManager will handle this for you.

**Set Up Browsers for Testing**
Make sure that the browsers you want to test on (Chrome, Firefox, Edge) are installed on your local machine or your CI/CD environment. The framework will run tests on these browsers by passing their names in the testng.xml file.

**Running Tests**
The tests can be run in different environments, including your local machine or a CI/CD pipeline (e.g., Jenkins, GitLab CI). Follow the instructions below to run the tests.

Run Tests Locally (Maven)
To run the tests locally with Maven, open a terminal/command prompt and navigate to the project directory. Then run the following command:
mvn clean test

This command will:

Execute the tests defined in the TestRunner class.
Use the testng.xml file for parallel execution across multiple browsers (Chrome, Firefox, Edge).
Running Tests in Headless Mode (Optional)
If you want to run the tests in headless mode (without opening a browser window), you can pass the headless parameter in the command line:
mvn clean test -Dheadless=true


**Run Tests via IDE**
You can also run the tests directly from your IDE (e.g., IntelliJ IDEA or Eclipse):

Open the testng.xml file in your IDE.
Right-click on the file and select Run.
This will execute the tests in parallel for all configured browsers (Chrome, Firefox, Edge) as defined in the testng.xml file.
