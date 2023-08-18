Feature: Ready To Work:Login Feature

  Background:
    Given browser is launched
    And ready to work "https://readytowork.absa.africa/login" page is open
    Then verify login page is open


  @SmokeTest
  Scenario: Test ReadyToWork: login with invalid credentials
    #Login scenario with invalid credentials
    When user enters "sphelelez101@gmail.com" and "JumpyFact04"
    And user click on sign in button
    Then message display no active account with the given credentials
    And close the browser


  @SmokeTest
  Scenario: Test ReadyToWork: login with valid credentials
    #Login scenario with valid credentials
    When user enters "sphelelez101@gmail.com" and "JumpyFact05"
    And user click on sign in button
    Then user logged in successfully
    And verify My learning page is open
    And user click on logout button
    And close the browser


  Scenario: Test Ready To Work: Forgot Password with valid email or account
  #Forgot Password with valid email or account
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
    And user click on forgot password button
    And verify forgot password is open
    When user enters email "sphelelez103331@gmail.co"
    And user click on reset Password button
    Then Alert display there is no associated with email address
    And click on close button
    And  close the browser