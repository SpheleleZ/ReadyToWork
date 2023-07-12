Feature: Ready to Work:Home page feature

  @SmokeTest
  Scenario: ReadyToWork home page launching
    Given browser is launched
    And ready to work home page is open
    Then ReadytoWork e-learning platform is displayed
    And close the browser