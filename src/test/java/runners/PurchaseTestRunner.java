package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "src/test/resources/features/purchase.feature",
        glue = {"stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class PurchaseTestRunner  {
}
