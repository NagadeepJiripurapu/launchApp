package stepDefs;

import commons.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.cpPages;
import pages.dp2Pages;
import utilities.ConfigReader;

import static utilities.ConfigReader.prop;



public class stepDefinitions extends BaseTest {


    cpPages cpP = new cpPages();
    dp2Pages dp2P = new dp2Pages();

    @After
    public void tearDown() {
    getDriver().quit();
    }
    @Given("User navigates to core product test url")
    public void user_navigates_to_core_product_test_url() {
        ConfigReader.loadProperties();
        launchApp(prop.getProperty("browser"), prop.getProperty("url1"));
    }

        @Given("User hovers on 3dots")
    public void user_hovers_on_3dots() {
        cpP.hoverOnThreeDots();
    }
    @Then("User navigates to New&Features page")
    public void user_navigates_to_new_features_page() {
    cpP.navigateToNewFeaturesPage();
    }
    @Then("Counting all the videos who's uploaded date is more than three days")
    public void counting_all_the_videos_who_s_uploaded_date_is_more_than_days() {
    cpP.countVideosUploadedMoreThan();
    }

    //Derived Product 1

    @Given("User navigates to derived product1 test url")
    public void user_navigates_to_derived_product1_test_url() {
        ConfigReader.loadProperties();
        launchApp(prop.getProperty("browser"), prop.getProperty("url2"));
    }
    @When("User Counting number of slides present under Tickets menu")
    public void user_counting_number_of_slides_present_under_tickets_menu() {

    }
    @Then("Getting title of each slide and validate with expected test data")
    public void getting_title_of_each_slide_and_validate_with_expected_test_data() {


    }
    @Then("Count how much time each slide is playing and validate with the expected duration")
    public void count_how_much_time_each_slide_is_playing_and_validate_with_the_expected_duration() {

    }
    // Derived Product 2
    @Given("User navigates to derived product2 test url")
    public void user_navigates_to_derived_product2_test_url() {
        ConfigReader.loadProperties();
        launchApp(prop.getProperty("browser"), prop.getProperty("url3"));
    }
    @When("User scrolled down to the bottom of the page")
    public void user_scrolled_down_to_the_bottom_of_the_page() {
        dp2P.scrollDownToFooter();
    }
    @Then("Storing all the links in a file and report the status of any duplicate link")
    public void stroing_all_the_links_in_a_file_and_report_the_status_of_any_duplicate_link() {
        dp2P.storingAllFooterLinks();
    }


}
