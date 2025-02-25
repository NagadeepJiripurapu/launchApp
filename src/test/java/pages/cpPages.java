package pages;

import commons.GenericMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;

import java.util.List;
import java.util.NoSuchElementException;

import static commons.BaseTest.getDriver;

public class cpPages {

    public static final By threedots = By.xpath("//a[@rel='noreferrer']//span[contains(text(),'...')]");
    public static final By newFeaturesPage = By.xpath("(//a[contains(text(),'News & Features')])[1]");
    public static final By videos = By.cssSelector("css_selector_for_videos");
    public static final By cross = By.xpath("//div[contains(text(),'x')]");
    public static final By IAcceptBtn = By.xpath("//button[contains(text(),'I Accept')]");
    public static final By threedaysOlder = By.xpath("//h3[contains(text(),'VIDEOS')]/parent::div/following-sibling::div//li//time//span[contains(text(),'3d')]");
    public static final By lastuploadedtime = By.xpath("(//h3[contains(text(),'VIDEOS')]/parent::div/following-sibling::div//li//time//span)[22]");
    GenericMethods gm = new GenericMethods();

    private static ExtentTest test; // Declare ExtentTest object

    public cpPages() {
        // Initialize the ExtentTest object at the start of the class
        test = ExtentReportManager.startTest("cpPages Test", "Test logging actions for cpPages class");
    }

    // Method to hover over the 3 dots and accept the prompt
    public void hoverOnThreeDots() {
        try {
            if (gm.isDisplayed(getDriver(), IAcceptBtn)) {
                gm.click(getDriver(), IAcceptBtn);
                gm.click(getDriver(), cross);
                gm.moveToElement(getDriver(), threedots);
                test.info("Hovered over the 3 dots and clicked the 'I Accept' button.");
            }
        } catch (Exception e) {
            gm.click(getDriver(), cross);
            gm.moveToElement(getDriver(), threedots);
            test.error("Error while hovering over the 3 dots: " + e.getMessage());
        }
    }

    // Method to navigate to the New Features page
    public void navigateToNewFeaturesPage() {
        try {
            gm.scrollToViewJS(getDriver(), newFeaturesPage);
            gm.click(getDriver(), newFeaturesPage);
            test.info("Navigated to the New Features page.");
        } catch (Exception e) {
            test.error("Error while navigating to New Features page: " + e.getMessage());
        }
    }

    // Method to count the number of videos uploaded more than 3 days ago
    public void countVideosUploadedMoreThan() {
        int n = 0, count = 0;
        try {
            List<WebElement> olderList = getDriver().findElements(threedaysOlder);
            int i = olderList.size();
            String lastuploaded = gm.getVisibleText(getDriver(), lastuploadedtime);
            int lastUploadedDay = Integer.parseInt(lastuploaded.substring(0, 1));
            System.out.println("The last uploaded video is " + lastUploadedDay + " days old");
            test.info("The last uploaded video is " + lastUploadedDay + " days old.");
            if (i >= 1) {
                for (int day = 3; day <= lastUploadedDay; day++) {
                    String dynamicExpression = "//h3[contains(text(),'VIDEOS')]/parent::div/following-sibling::div//li//time[contains(@aria-label,'" + day + " days ago')]";
                    List<WebElement> duration = getDriver().findElements(By.xpath(dynamicExpression));
                    n = duration.size();
                    count += n;
                }
            }
            System.out.println("The count of videos uploaded time >= 3 days is: " + count);
            test.info("The count of videos uploaded time >= 3 days is: " + count);
        } catch (NoSuchElementException e) {
            List<WebElement> olderList = getDriver().findElements(threedaysOlder);
            int i = olderList.size();
            String lastuploaded = getDriver().findElement(lastuploadedtime).getText();
            int lastUploadedDay = Integer.parseInt(lastuploaded.substring(0, 1));
            System.out.println("The last uploaded video is " + lastUploadedDay + " days old");
            test.info("The last uploaded video is " + lastUploadedDay + " days old.");
            if (i >= 1) {
                for (int day = 3; day <= lastUploadedDay; day++) {
                    String dynamicExpression = "//h3[contains(text(),'VIDEOS')]/parent::div/following-sibling::div//li//time[contains(@aria-label,'" + day + " days ago')]";
                    List<WebElement> duration = getDriver().findElements(By.xpath(dynamicExpression));
                    n = duration.size();
                    count += n;
                }
            }
            System.out.println("The count of videos uploaded time >= 3 days is: " + count);
            test.info("The count of videos uploaded time >= 3 days is: " + count);
        }catch (Exception e) {
            e.printStackTrace();
            test.error("Error while counting videos uploaded more than 3 days ago: " + e.getMessage());
        }
    }
}
