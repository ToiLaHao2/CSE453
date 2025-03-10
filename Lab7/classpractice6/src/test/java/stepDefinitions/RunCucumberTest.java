package stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", // Đường dẫn tới file feature
        glue = "stepDefinitions", // Package chứa các step definitions
        plugin = { "pretty", "html:target/cucumber-reports.html" })
public class RunCucumberTest {
}
