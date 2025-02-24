package runner;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import utilities.ExtentReportManager;

@CucumberOptions(features = "src/test/resources/features",
        glue = {"stepDefs"},
        dryRun = false,
        monochrome = true,
        plugin = {
        "pretty",  // Console output
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json"
},tags = "not @skipTest"
)
public class runnerClass extends AbstractTestNGCucumberTests {

    private static ExtentTest extentTest;
    @BeforeClass
    public void beforeClass() {
        ExtentReportManager.getExtentReport();
    }
    @AfterClass
    public void afterClass() {
        ExtentReportManager.endTest();
        ExtentReportManager.closeReport();
    }
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
