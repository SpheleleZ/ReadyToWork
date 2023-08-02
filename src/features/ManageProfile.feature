Feature: Ready To Work: Manage Profile Feature

  Background:
    Given browser is launched
    And ready to work "https://readytowork.absa.africa/login" page is open
    Then verify login page is open

  @SmokeTest
  Scenario Outline:Test Ready To Work: Edit or Manage Profile
    When user enters <email> and <password>
    And user click on sign in button
    Then user logged in successfully
    And user click on manage profile button
    Then verify Manage Profile page is open
    When enters Personal Details <name> and <surname> follow by <contactNumber> also <category>
    And user enter Address Details <city> after <province> last <country>
    And user click on Submit form
    Then verify if profile details successfully updated
    And user click on logout button
    And close the browser
    Examples:
      | email                  | password   | name  | surname | contactNumber | category   | city    | province | country      |
      | sphelelez101@gmail.com | Nok2lasphe | Thabo | Mbhele  | 0831234567    | unemployed | Florida | Gauteng  | South Africa |