package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {

    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    // Create ExtentReports instance and configure it
    public static ExtentReports getExtentReport() {
        if (extentReports == null) {
            String reportName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String filePath = System.getProperty("user.dir") + "/target/extent-reports/ExtentReport_" + reportName + ".html";

            // Create ExtentHtmlReporter instance
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
            htmlReporter.config().setDocumentTitle("Test Automation Report");
            htmlReporter.config().setReportName("Automation Assessment Test Results");
            extentReports = new ExtentReports();
            extentReports.attachReporter(htmlReporter);
            extentReports = new ExtentReports();
            extentReports.attachReporter(htmlReporter);
            extentReports.setSystemInfo("OS", "MacOS");
            extentReports.setSystemInfo("Tester", "NagaDeep Jiripurapu");
            extentReports.setSystemInfo("Framework", "Selenium + Cucumber + TestNG + Core Java");
        }
        return extentReports;
    }

    public static void attachFileToReport(ExtentTest test, String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                test.info("Attaching jacket details file to the report.");
                String content = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                test.info("File contents: \n" + content);
                //test.info("Attached the jacket details file to the report.");
            } else {
                test.warning("The jacket details file does not exist at the specified path: " + filePath);
            }
        } catch (Exception e) {
            test.error("Error attaching jackets details file to report: " + e.getMessage());
        }
    }



    // Create a test
    public static ExtentTest startTest(String testName, String testDescription) {
        extentTest = extentReports.createTest(testName, testDescription);
        return extentTest;
    }

    // Flush the report
    public static void endTest() {
        extentReports.flush(); // Always call flush to write the report
    }

    // Close the report
    public static void closeReport() {
        extentReports.flush();
    }

    // Accessor method to get the current test
    public static ExtentTest getTest() {
        return extentTest;
    }
}
