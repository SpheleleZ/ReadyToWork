Feature: Ready To Work: Manage Profile Feature

  Background:
    Given browser is launched
    And ready to work "https://readytowork.absa.africa/login" page is open
    Then verify login page is open
    When user enters "sphelelez101@gmail.com" and "JumpyFact05"
    And user click on sign in button
    Then user logged in successfully
    And user click on manage profile button
    Then verify Manage Profile page is open

  @SmokeTest
  Scenario Outline:Test Ready To Work: Edit or Manage Profile

    When enters Personal Details <name> and <surname> follow by <contactNumber> also <category>
    And user enter Address Details <city> after <province> last <country>
    And user click on Submit form
    Then verify if profile details successfully updated
    And user click on logout button
    And close the browser
    Examples:
      | name  | surname | contactNumber | category   | city    | province | country      |
      | Thabo | Mbhele  | 0831234567    | unemployed | Florida | Gauteng  | South Africa |


  Scenario: Test Ready To Work: Reset Password

    And user click on manage account button
    And user click on reset button
    When enters current "JumpyFact04" new "JumpyFact05" and confirm "JumpyFact05" Password
    And chick on change password button
    Then verify password is changed successfully
    And close the browser


