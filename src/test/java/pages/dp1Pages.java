package pages;

import commons.BaseTest;
import commons.GenericMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static commons.BaseTest.getDriver;

public class dp1Pages {
    GenericMethods gm = new GenericMethods();
    private static ExtentTest test;

    public static final By noOfSlidesPresent= By.xpath("//div[@role='tablist']/button");
    public static final By titlesOfSlides=By.xpath("//div[@role='tablist']//button//div[starts-with(@class,'TileHeroStories_tileHeroStoriesButtonTitle')]");
    public static final By timeOfSlide=By.xpath("//div[@role='tablist']//button");


    public dp1Pages() {
        test = ExtentReportManager.startTest("dp1Pages Test", "Test logging actions for dp1Pages class");
    }


    public void countNoOfSlidesPresent() {
        try {
            List<WebElement> slides = getDriver().findElements(noOfSlidesPresent);
            System.out.println("The number of slides present are: " + slides.size());
            test.info("The number of slides present are: " + slides.size());
        } catch (Exception e) {
            test.error("Error while counting the number of slides: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void validatingTitleOfEachSlide() {
        try {
            List<String> expectedTitles = Arrays.asList(
                    "Sixers Host Bulls Tonight in South Philly",
                    "76ers Welcome Alex Reese with Two-Way Contract",
                    "David Roddy Signs Two-Way Contract with 76ers",
                    "76ers Sign Lonnie Walker IV",
                    "76ers Celebrate Dikembe Mutombo"
            );
            List<String> actualTitle = gm.getListOfVisibleText(getDriver(), titlesOfSlides);
            for (int i = 0; i < expectedTitles.size(); i++) {
                if (actualTitle.get(i).equals(expectedTitles.get(i))) {
                    System.out.println("Slide " + (i) + " title is correct: " + actualTitle.get(i));
                    test.info("Slide " + (i) + " title is correct: " + actualTitle.get(i));
                } else {
                    System.out.println("Slide " + (i) + " title is incorrect. Expected: " + expectedTitles.get(i) + " but got: " + actualTitle.get(i));
                    test.warning("Slide " + (i) + " title is incorrect. Expected: " + expectedTitles.get(i) + " but got: " + actualTitle.get(i));
                }
            }
        } catch (Exception e) {
            test.error("Error while validating the title of each slide: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void checkTheDurationOfEachSlide() {
        try {
            List<WebElement> slides = getDriver().findElements(timeOfSlide);
            List<Integer> expectedDurations = Arrays.asList(10, 10, 10, 10, 10);
            for (int i = 0; i < slides.size(); i++) {
                WebElement slide = slides.get(i);
                long startTime = System.currentTimeMillis();
                long endTime = 0;


                new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(
                        ExpectedConditions.attributeToBe(slide, "aria-selected", "true"));
                startTime = System.currentTimeMillis();


                new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(
                        ExpectedConditions.attributeToBe(slide, "aria-selected", "false"));
                endTime = System.currentTimeMillis();

                long actualDuration = TimeUnit.MILLISECONDS.toSeconds(endTime - startTime);


                if (actualDuration == expectedDurations.get(i)) {
                    System.out.println("Slide " + (i + 1) + " duration is correct: " + actualDuration + " seconds");
                    test.info("Slide " + (i + 1) + " duration is correct: " + actualDuration + " seconds");
                } else {
                    System.out.println("Slide " + (i + 1) + " duration is incorrect. Expected: "
                            + expectedDurations.get(i) + " seconds, but got: " + actualDuration + " seconds");
                    test.warning("Slide " + (i + 1) + " duration is incorrect. Expected: "
                            + expectedDurations.get(i) + " seconds, but got: " + actualDuration + " seconds");
                }
            }
        } catch (Exception e) {
            test.error("Error while checking the duration of each slide: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
