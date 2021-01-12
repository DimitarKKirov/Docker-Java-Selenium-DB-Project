package Selenium.resources.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"src/test/resources/RemoteFeatures"},
        tags = "@Show",
        plugin = {"pretty","html:target/cucumber-hmtl-report","json:target/cucumber.json"},
        glue = {"Selenium.steps.RemoteWebShopLilly","Selenium.steps.StepDefinitions","Selenium.steps.webShopEmag"},
        dryRun=false
)

public class Runner {
}
