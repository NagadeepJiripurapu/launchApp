Feature: Derived Product Test1 feature
  Scenario: Count how much duration each slide is playing
    Given User navigates to derived product1 test url
    When User Counting number of slides present under Tickets menu
    Then Getting title of each slide and validate with expected test data
    Then Count how much time each slide is playing and validate with the expected duration