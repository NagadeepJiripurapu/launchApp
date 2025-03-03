package stepDefs;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import commons.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.cpPages;
import pages.cpPages2;
import pages.dp1Pages;
import pages.dp2Pages;
import utilities.ConfigReader;
import utilities.ExtentReportManager;

import static utilities.ConfigReader.prop;

public class stepDefinitions extends BaseTest {

    private static ExtentTest extentTest;

    // This will initialize the ExtentTest object from your ExtentReportManager
    static {
        extentTest = ExtentReportManager.startTest("Cucumber Test", "Running the cucumber tests with ExtentReports");
    }

    cpPages cpP = new cpPages();
    dp2Pages dp2P = new dp2Pages();
    cpPages2 cpP2 = new cpPages2();
    dp1Pages dp1P = new dp1Pages();

    @Given("User navigates to core product test url")
    public void user_navigates_to_core_product_test_url() {
        try {
            ConfigReader.loadProperties();
            launchApp(prop.getProperty("cBrowser"), prop.getProperty("url1"));
            extentTest.log(Status.INFO, "Navigated to core product test URL");
        } catch (Exception e) {
            extentTest.log(Status.ERROR, "Failed to navigate to core product test URL: " + e.getMessage());
        }
    }

    @Given("User hovers on 3dots")
    public void user_hovers_on_3dots() {
        try {
            cpP.hoverOnThreeDots();
            extentTest.log(Status.INFO, "Hovered on 3 dots successfully.");
        } catch (Exception e) {
            extentTest.log(Status.ERROR, "Error while hovering on 3 dots: " + e.getMessage());
        }
    }

    @Then("User navigates to New&Features page")
    public void user_navigates_to_new_features_page() {
        try {
            cpP.navigateToNewFeaturesPage();
            extentTest.log(Status.INFO, "Navigated to New & Features page.");
        } catch (Exception e) {
            extentTest.log(Status.ERROR, "Failed to navigate to New & Features page: " + e.getMessage());
        }
    }

    @Then("Counting all the videos who's uploaded date is more than three days")
    public void counting_all_the_videos_who_s_uploaded_date_is_more_than_days() {
        try {
            cpP.countVideosUploadedMoreThan();
            extentTest.log(Status.INFO, "Counted all the videos uploaded more than 3 days ago.");
        } catch (Exception e) {
            extentTest.log(Status.ERROR, "Failed to count videos: " + e.getMessage());
        }
    }

    // Derived Product 1

    @Given("User navigates to derived product1 test url")
    public void user_navigates_to_derived_product1_test_url() {
        try {
            ConfigReader.loadProperties();
            launchApp(prop.getProperty("cBrowser"), prop.getProperty("url2"));
            extentTest.log(Status.INFO, "Navigated to derived product1 test URL.");
        } catch (Exception e) {
            extentTest.log(Status.ERROR, "Failed to navigate to derived product1 test URL: " + e.getMessage());
        }
    }

    @When("User Counting number of slides present under Tickets menu")
    public void user_counting_number_of_slides_present_under_tickets_menu() {
        try {
            dp1P.countNoOfSlidesPresent();
            extentTest.log(Status.INFO, "Counted the number of slides present under the Tickets menu.");
        } catch (Exception e) {
            extentTest.log(Status.ERROR, "Failed to count slides under the Tickets menu: " + e.getMessage());
        }
    }

    @Then("Getting title of each slide and validate with expected test data")
    public void getting_title_of_each_slide_and_validate_with_expected_test_data() {
        try {
            dp1P.validatingTitleOfEachSlide();
            extentTest.log(Status.INFO, "Validated the titles of each slide.");
        } catch (Exception e) {
            extentTest.log(Status.ERROR, "Failed to validate slide titles: " + e.getMessage());
        }
    }

    @Then("Count how much time each slide is playing and validate with the expected duration")
    public void count_how_much_time_each_slide_is_playing_and_validate_with_the_expected_duration() {
        try {
            dp1P.checkTheDurationOfEachSlide();
            extentTest.log(Status.INFO, "Checked and validated the duration of each slide.");
        } catch (Exception e) {
            extentTest.log(Status.ERROR, "Failed to check the duration of slides: " + e.getMessage());
        }
    }

    // Derived Product 2
    @Given("User navigates to derived product2 test url")
    public void user_navigates_to_derived_product2_test_url() {
        try {
            ConfigReader.loadProperties();
            launchApp(prop.getProperty("cBrowser"), prop.getProperty("url3"));
            extentTest.log(Status.INFO, "Navigated to derived product2 test URL.");
        } catch (Exception e) {
            extentTest.log(Status.ERROR, "Failed to navigate to derived product2 test URL: " + e.getMessage());
        }
    }

    @When("User scrolled down to the bottom of the page")
    public void user_scrolled_down_to_the_bottom_of_the_page() {
        try {
            dp2P.scrollDownToFooter();
            extentTest.log(Status.INFO, "Scrolled down to the footer of the page.");
        } catch (Exception e) {
            extentTest.log(Status.ERROR, "Failed to scroll down to the footer: " + e.getMessage());
        }
    }

    @Then("Storing all the links in a file and report the status of any duplicate link")
    public void stroing_all_the_links_in_a_file_and_report_the_status_of_any_duplicate_link() {
        try {
            dp2P.storingAllFooterLinks();
            extentTest.log(Status.INFO, "Stored all the footer links and reported any duplicate links.");
        } catch (Exception e) {
            extentTest.log(Status.ERROR, "Failed to store footer links or report duplicates: " + e.getMessage());
        }
    }

    // Core Product Test 1

    @Then("User hovering on shop menu and navigating Mens Section")
    public void User_hovering_on_Shop_menu_and_navigating_Mens_Section() {
        try {
            cpP2.hoverOnShop();
            extentTest.log(Status.INFO, "Hovered on Shop menu and navigated to Mens section.");
        } catch (Exception e) {
            extentTest.log(Status.ERROR, "Error while navigating to Mens section: " + e.getMessage());
        }
    }

    @Then("User select the jackets from all department section")
    public void User_select_the_jackets_from_all_department_section() {
        try {
            cpP2.clickOnMens();
            cpP2.clickOnJackets();
            extentTest.log(Status.INFO, "Selected jackets from the Men's section.");
        } catch (Exception e) {
            extentTest.log(Status.ERROR, "Error while selecting jackets: " + e.getMessage());
        }
    }

    @And("User collected all the Jackets Price title and Most popular jackets text into a text file")
    public void User_collected_all_the_Jackets_Price_title_and_Most_popular_jackets_text_into_a_text_file() {
        try {
            cpP2.collectingJacketsPrice();
            extentTest.log(Status.INFO, "Collected jackets prices and most popular jackets text into a text file.");
        } catch (Exception e) {
            extentTest.log(Status.ERROR, "Error while collecting jacket details: " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        try {
            quitDriver();
            extentTest.log(Status.INFO, "Browser closed successfully after test execution.");
        } catch (Exception e) {
            extentTest.log(Status.ERROR, "Failed to close the browser: " + e.getMessage());
        }
    }
}
