package pages;

import commons.GenericMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static commons.BaseTest.getDriver;

public class dp2Pages {

    GenericMethods gm = new GenericMethods();
    private static ExtentTest test;  // Declare ExtentTest object for logging

    public static final By footerLocator = By.xpath("//h2[contains(text(),'Team')]/parent::nav/parent::div/parent::div/parent::footer");
    public static final By footerSection = By.xpath("//h2[contains(text(),'Team')]");

    public dp2Pages() {
        // Initialize the ExtentTest object at the start of the class
        test = ExtentReportManager.startTest("dp2Pages Test", "Test logging actions for dp2Pages class");
    }

    // Method to scroll down to the footer section
    public void scrollDownToFooter() {
        try {
            gm.scrollToViewJS(getDriver(), footerSection);
            test.info("Scrolled down to the footer section.");
        } catch (Exception e) {
            test.error("Error while scrolling to the footer section: " + e.getMessage());
        }
    }

    // Method to store all footer links and log duplicate links
    public void storingAllFooterLinks() {
        WebElement footer = getDriver().findElement(footerLocator);
        List<WebElement> footerLinks = footer.findElements(By.tagName("a"));
        Set<String> uniqueLinks = new HashSet<>();
        Set<String> duplicateLinks = new HashSet<>();
        File file = new File("footerLinks.csv");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Link Text, URL");
            writer.newLine();
            for (WebElement link : footerLinks) {
                String linkText = link.getText().trim();
                String url = link.getAttribute("href");
                if (uniqueLinks.contains(url)) {
                    duplicateLinks.add(url);
                } else {
                    uniqueLinks.add(url);
                    writer.write(linkText + "," + url);
                    writer.newLine();
                }
            }
            if (!duplicateLinks.isEmpty()) {
                test.info("Duplicate Links Found: ");
                for (String duplicateLink : duplicateLinks) {
                    test.info("Duplicate Link: " + duplicateLink);
                }
            } else {
                test.info("No Duplicate Links Found");
            }
            test.info("All Footer Links are stored in footerLinks.csv file.");
            System.out.println("All Footer Links are stored in footerLinks.csv file");

        } catch (Exception e) {
            test.error("Error while storing footer links: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
