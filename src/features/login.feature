Feature: Ready To Work login Feature

  @SmokeTest
  Scenario Outline: Test ReadyToWork login with valid credentials
    #Login Feature
    Given browser is launched
    And ready to work home page is open
    And  user click on sign in button
    Then verify login page is open
    When user enters <email> and <password>
    And user click on sign in button
    Then user logged in successfully
    And verify My learning page is open
    And user click on logout button
    Then verify login page is open
    And close the browser
    Examples:
      | email                  | password   |
      | sphelelez101@gmail.com | Nok2lasphe |

