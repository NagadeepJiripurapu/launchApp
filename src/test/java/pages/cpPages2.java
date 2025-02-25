package pages;


import commons.GenericMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import utilities.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


import static commons.BaseTest.getDriver;

public class cpPages2 {

    GenericMethods gm = new GenericMethods();
    private static final By cross = By.xpath("//div[contains(text(),'x')]");
    private static final By IAcceptBtn = By.xpath("//button[contains(text(),'I Accept')]");
    private static final By Shop = By.xpath("//nav[starts-with(@class,'_headerPrimaryMenu')]//li//a//span[contains(text(),'Shop')]");
    private static final By Mens = By.xpath("(//a[starts-with(@title,'Men')])[1]");
    private static final By allDepartmentItems = By.cssSelector("div[class='side-nav-facet-items allDepartmentsBoxes'] ul li a span");
    private static final By allDepartmentScrollView = By.cssSelector("div[class='side-nav-facet-items allDepartmentsBoxes']");
    private static final By verifyJacketIsSelected = By.xpath("//a[@aria-label='Remove Jackets filter']");
    private static final By jacketsRadioButton = By.xpath("//*[starts-with(@data-trk-id,'side-nav-jackets')]");
    private static final By jacketPrice = By.xpath("//span[@class='sr-only']");
    private static final By jacketTitle = By.cssSelector(".product-card-title a");
    private static final By popularJackets = By.xpath("//div[@class='product-grid-top-area']/following-sibling::div//span[@class='top-seller-vibrancy-message']/span");
    private static final By nextPageBtn = By.xpath("(//div[@class='pagination-container']/ul/li[starts-with(@class,'next-page')]//a)[1]");
    private static final By nextBtnDisabled = By.xpath("//div[@class='product-grid-top-area']//a[@aria-disabled='true']");
    private static final By jacketList=By.xpath("//div[@class='spacing']/parent::div");
    private static ExtentTest test;

    public cpPages2() {
        test = ExtentReportManager.startTest("cpPages2 Test", "Test logging actions for cpPages2 class");
    }

    public void hoverOnShop() {
        try {
            if (gm.isDisplayed(getDriver(), IAcceptBtn)) {
                gm.click(getDriver(), IAcceptBtn);
                gm.click(getDriver(), cross);
                gm.moveToElement(getDriver(), Shop);
                test.info("Hovered over the Shop section.");
            }
        } catch (TimeoutException ex) {
            gm.click(getDriver(), cross);
            gm.moveToElement(getDriver(), Shop);
           // test.error("Failed to hover over Shop section: " + e.getMessage());
        }catch (Exception e)
        {
            gm.click(getDriver(), cross);
            gm.moveToElement(getDriver(), Shop);
            test.error("Failed to hover over Shop section: " + e.getMessage());
        }
    }

    public void clickOnMens() {
        try {
            String parentTab = getDriver().getWindowHandle();
            gm.click(getDriver(), Mens);
            gm.switchToWindow(getDriver(), parentTab);
            test.info("Clicked on Mens section.");
        } catch (Exception e) {
            test.error("Failed to click on Mens section: " + e.getMessage());
        }
    }

    public void clickOnJackets() {
        try {
            gm.scrollToViewJS(getDriver(), allDepartmentScrollView);
            gm.click(getDriver(), jacketsRadioButton);
            test.info("Clicked on Jackets section.");
        } catch (TimeoutException e) {
            try{
                gm.scrollToViewJS(getDriver(), allDepartmentScrollView);
                gm.click(getDriver(), jacketsRadioButton);
                test.info("Clicked on Jackets section.");
            }catch (Exception exception)
            {
                gm.scrollToViewJS(getDriver(), allDepartmentScrollView);
                gm.click(getDriver(), jacketsRadioButton);
                test.error("Failed to click on Jackets section: " + exception.getMessage());
            }
        }
    }

    public void collectingJacketsPrice() {
        String value = "";
        String filePath = "/Users/nagadeepjiripurapu/launchApp/testResult.txt";
        List<WebElement> JacketPrice = getDriver().findElements(jacketPrice);
        for (int i = 0; i < JacketPrice.size(); i++) {
            String priceOfJacket = JacketPrice.get(i).getText();
            System.out.println(priceOfJacket);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.write(priceOfJacket);
                writer.newLine();
                writer.newLine();
            } catch (IOException e) {
                test.error("Error writing price to file: " + e.getMessage());
            }
        }
        List<WebElement> jacketDisc = getDriver().findElements(jacketTitle);
        for (int i = 0; i < jacketDisc.size(); i++) {
            String DiscOfJacket = jacketDisc.get(i).getText();
            System.out.println(DiscOfJacket);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.write(DiscOfJacket);
                writer.newLine();
                writer.newLine();
            } catch (IOException e) {
                test.error("Error writing description to file: " + e.getMessage());
            }
        }
        List<WebElement> jacketPopular = getDriver().findElements(popularJackets);
        for (int i = 0; i < jacketPopular.size(); i++) {
            String PopularJacket = jacketPopular.get(i).getText();
            System.out.println(PopularJacket);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.write(PopularJacket);
                writer.newLine();
                writer.newLine();
            } catch (IOException e) {
                test.error("Error writing popular jackets to file: " + e.getMessage());
            }
        }

        if (getDriver().findElement(By.xpath("(//div[@class='pagination-container']/ul/li[starts-with(@class,'next-page')]//a)[1]")).isEnabled()) {
            System.out.println("Next button is enabled");
            try {
                gm.click(getDriver(), nextPageBtn);
                collectingJacketsPrice();
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
        else {
            System.out.println("Next button is disabled.");
            test.info("Next button is disabled.");
        }
        ExtentReportManager.attachFileToReport(test, filePath);
    }


    public void collectingJacketsPrice1() {
        // String filePath = "/Users/nagadeepjiripurapu/launchApp/testResult.txt";
        File file = new File("jacketsDetails.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Jacket Price, Description, Most Popular");
            writer.newLine();
            writer.newLine();

            // Iterate through all pages
            boolean hasNextPage = true;
            while (hasNextPage) {
                // Locate all jackets on the current page
                List<WebElement> jList = getDriver().findElements(jacketList); // Adjust as per actual locator

                // Iterate through each jacket on the current page
                for (WebElement jacket : jList) {
                    // Extract jacket price
                    String price = jacket.findElement(jacketPrice).getText();

                    // Extract jacket description
                    String description = jacket.findElement(jacketTitle).getText();

                    // Check if "Most Popular" message is present
                    String mostPopular = "";
                    List<WebElement> popularMessages = jacket.findElements(popularJackets);
                    if (!popularMessages.isEmpty()) {
                        mostPopular = popularMessages.get(0).getText(); // Extract the actual text of the "Most Popular" message
                    } else {
                        mostPopular = "Not Popular"; // If no "Most Popular" message, mark it as "Not Popular"
                    }


                    // Write the details into the file
                    writer.write(price + ", " + description + ", " + mostPopular);
                    writer.newLine();
                }

                // Check if there is a next page
                if (isNextPageAvailable()) {
                    gm.click(getDriver(),nextPageBtn); // Click the "Next" button to go to the next page
                    Thread.sleep(2000); // Wait for the page to load (you can adjust this based on your page load time)
                } else {
                    hasNextPage = false; // Stop the loop if no next page is available
                }
            }

            System.out.println("Jacket details have been successfully written to the file.");
        } catch (Exception e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Check if the "Next" button is available and clickable
    private boolean isNextPageAvailable() {
        try {
            //WebElement nextButton = getDriver().findElement(nextPageBtn);
            return gm.isEnabled(getDriver(), nextPageBtn);
        } catch (Exception e) {
            return false; // No next page available
        }
    }
}
