Feature: VeevaSystems Automation coding Assessment
    As a QA Engineer, I want to automate the test cases for the VeevaSystems website so that I can validate the functionality of the website.
  Scenario: Successful Implementation of core product test cases
    Given User navigates to core product test url
    When User hovers on 3dots
    And User navigates to New&Features page
    Then Counting all the videos who's uploaded date is more than three days

  Scenario: Successful implementation of test case1
    Given User navigates to core product test url
    Then User hovering on shop menu and navigating Mens Section
    Then User select the jackets from all department section
    And User collected all the Jackets Price title and Most popular jackets text into a text file

  Scenario: Count how much duration each slide is playing
    Given User navigates to derived product1 test url
    When User Counting number of slides present under Tickets menu
    Then Getting title of each slide and validate with expected test data
    Then Count how much time each slide is playing and validate with the expected duration

  Scenario: Derived Product Test2 scenario
    Given User navigates to derived product2 test url
    When User scrolled down to the bottom of the page
    And Storing all the links in a file and report the status of any duplicate link
