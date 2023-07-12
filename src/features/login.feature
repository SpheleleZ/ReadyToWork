Feature: Ready To Work:Login Feature

  @SmokeTest
  Scenario Outline: Test ReadyToWork login with invalid credentials
    #Login scenario with invalid credentials
    Given browser is launched
    And ready to work home page is open
    And  user click on sign in link
    Then verify login page is open
    When user enters <email> and <password>
    And user click on sign in button
    Then message display no active account with the given credentials
    And close the browser

    Examples:
      | email                  | password      |
      | sphelelez101@gmail.com | Nok2lasphe123 |

  @SmokeTest
  Scenario Outline: Test ReadyToWork login with valid credentials
    #Login scenario with valid credentials
    Given browser is launched
    And ready to work home page is open
    And  user click on sign in link
    Then verify login page is open
    When user enters <email> and <password>
    And user click on sign in button
    Then user logged in successfully
    And verify My learning page is open
    And user click on logout button
    And close the browser
    Examples:
      | email                  | password   |
      | sphelelez101@gmail.com | Nok2lasphe |

  @SmokeTest
  Scenario: Forgot Password with valid email or account
  #Forgot Password with valid email or account
    Given browser is launched
    And ready to work home page is open
    And  user click on sign in link
    Then verify login page is open
    And user click on forgot password button
    And verify forgot password is open
    When user enters email "sphelelez101@gmail.com"
    And user click on reset Password button
    Then Alert display email sent please check your inbox
    And click on okay button
    And  close the browser

  @SmokeTest
  Scenario: Forgot Password with invalid email or account
  #Forgot Password with invalid email or account
    Given browser is launched
    And ready to work home page is open
    And  user click on sign in link
    Then verify login page is open
    And user click on forgot password button
    And verify forgot password is open
    When user enters email "sphelelez103331@gmail.co"
    And user click on reset Password button
    Then Alert display there is no associated with email address
    And click on close button
    And  close the browser
