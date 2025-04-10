package com.eteration.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.eteration.automation.stepdefinitions"},
    tags = "@api",
    plugin = {
        "pretty",
        "html:target/cucumber-reports/api-tests.html",
        "json:target/cucumber-reports/api-tests.json"
    }
)
public class APITestRunner extends AbstractTestNGCucumberTests {
    
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
} 