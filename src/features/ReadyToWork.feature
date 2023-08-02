Feature: Ready to Work:Home page feature
  Background:
    Given browser is launched
    And ready to work "https://readytowork.absa.africa/" page is open

  @SmokeTest
  Scenario: ReadyToWork home page launching
    Then Ready to Work e-learning platform is displayed
    And close the browser