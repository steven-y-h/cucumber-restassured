package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        monochrome = true,
        snippets = CAMELCASE,
        stepNotifications = true,
        tags = "@GetPaymentFooter",
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class CucumberRunner {
}
