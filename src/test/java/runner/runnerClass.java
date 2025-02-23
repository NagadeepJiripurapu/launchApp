package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/features/dp2.feature",
        glue = {"stepDefs"},
        dryRun = false,
        monochrome = true)


public class runnerClass extends AbstractTestNGCucumberTests {
}
