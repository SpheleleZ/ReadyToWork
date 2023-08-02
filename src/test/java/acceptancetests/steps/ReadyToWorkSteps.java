package acceptancetests.steps;

import acceptancetests.base.BaseTest;
import acceptancetests.pages.*;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.*;

public class ReadyToWorkSteps extends BaseTest {

    ReadyToWorkPage readyToWorkPage;
    LoginPage loginPage;
    MyLearningPage myLearningPage;
    ForgotPasswordPage forgotPasswordPage;
    EditProfilePage editProfilePage;

    /*
     * Steps definition for Ready to work:Home page ReadyToWork.Feature
     */

    @Given("^browser is launched$")
    public void browser_is_launched() {
        setUpMethod();
    }

    @And("ready to work {string} page is open")
    public void ready_to_work_page_is_open(String url) {
        openPage(url);
    }

    @Then("^Ready to Work e-learning platform is displayed$")
    public void Ready_To_Work_e_learning_platform_is_displayed() {
        readyToWorkPage = new ReadyToWorkPage(driver);
        assertTrue(readyToWorkPage.isReadyToWorkELearningDisplayed(),
                "ReadyToWork e-learning platform is not displayed");
    }

    @And("^close the browser$")
    public void close_the_browser() {
        tearDownMethod();
    }

    /*
     * Steps definition for Ready to work:Login with valid credentials
     */

    @Then("^verify login page is open$")
    public void verify_login_page_is_open() {
        loginPage = new LoginPage(driver);
        assertEquals(loginPage.verifyLoginPage(), "Sign In",
                "Login page is not open");
    }

    @When("^user enters (.*) and (.*)$")
    public void user_enters_and(String email, String password) {
        loginPage.setEmailInputField(email);
        loginPage.setPasswordInputField(password);
    }

    @And("user click on sign in button")
    public void user_click_on_sign_in_button() {
        myLearningPage = new MyLearningPage(driver);
        myLearningPage = loginPage.clickOnSignInButton();
    }

    @Then("^user logged in successfully$")
    public void user_logged_in_successfully() {
        assertTrue(myLearningPage.isWelcomeBackDisplayed(),
                "User login unsuccessful");
    }

    @And("^verify My learning page is open$")
    public void verify_my_learning_page_is_open() {
        assertTrue(myLearningPage.isMyLearningDisplayed(),
                "My learning page is not open");
    }

    @And("^user click on logout button$")
    public void user_click_on_logout_button() {
        myLearningPage.clickOnSignOutButton();
    }


    /*
     * Step definition for Ready to work: Login with invalid credentials
     */

    @Then("^message display no active account with the given credentials$")
    public void message_display_no_active_account_with_the_given_credentials() {
        assertTrue(loginPage.isLoginAlertDisplayed(),
                "login alert did not display");
    }

    /*
     * Step definition for Ready to Work:Forgot Password with Valid email or account
     */

    @And("^user click on forgot password button$")
    public void user_click_on_forgot_password_button() {
        forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage = loginPage.clickOnForgotPassword();
    }

    @And("verify forgot password is open")
    public void verify_forgot_password_is_open() {
        assertTrue(forgotPasswordPage.isForgotPasswordPageOpen(),
                "Forgot password page is no open");
    }

    @When("user enters email {string}")
    public void user_enters_email(String email) {
        forgotPasswordPage.setEmailField(email);
    }

    @And("^user click on reset Password button$")
    public void user_click_on_reset_password_button() {
        forgotPasswordPage.clickOnResetPasswordButton();
    }

    @Then("^Alert display email sent please check your inbox$")
    public void alert_display_email_sent_please_check_your_inbox() {
        assertTrue(forgotPasswordPage.isRestLinkDisplayed(),
                "Alert did not display");
    }

    @And("^click on okay button$")
    public void click_on_okay_button() {
        forgotPasswordPage.setClickOnOkayButton();
    }

    /*
     * Step definition for Ready to Work:Forgot Password with inValid email or account
     */

    @Then("^Alert display there is no associated with email address$")
    public void alert_display_there_is_no_associated_with_email_address() {
        assertTrue(forgotPasswordPage.isAlertForWrongEmailDisplayed(),
                "alert for wrong email or account did not display");
    }

    @Then("^click on close button$")
    public void click_on_close_button() {
        forgotPasswordPage.setCloseButton();
    }

    /*
     * Step definition for Ready To Work : Manage Profile feature
     */

    @Then("^user click on manage profile button$")
    public void user_click_on_manage_profile_button() {
        editProfilePage = new EditProfilePage(driver);
        editProfilePage = myLearningPage.setManageProfileButton();
    }

    @Then("^verify Manage Profile page is open$")
    public void verify_manage_profile_page_is_open() {
        assertTrue(editProfilePage.setManageProfilePage(),
                "Manage Profile Page is not open");
    }

    @When("^enters Personal Details (.*) and (.*) follow by (.*) also (.*)$")
    public void enters_Personal_Details_and_follow_by_also(String firstName, String lastName, String contactNumber, String category) {
        editProfilePage.setFirstNameInputField(firstName);
        editProfilePage.setLastNameInputField(lastName);
        editProfilePage.setContactNumber(contactNumber);
        editProfilePage.setCategory(category);
    }

    @And("^user enter Address Details (.*) after (.*) last (.*)$")
    public void user_enter_Address_Details_after_last(String city, String province, String country) {
        editProfilePage.setCity(city);
        editProfilePage.setProvince(province);
        editProfilePage.setCountry(country);
    }

    @And("^user click on Submit form$")
    public void user_click_on_submit_form() {
        editProfilePage.setSubmitButton();
    }

    @Then("^verify if profile details successfully updated$")
    public void verify_if_profile_details_successfully_updated() {
        assertTrue(editProfilePage.setSuccessfulAlert().contains("Profile details succefully updated"),
                "profile details unsuccessfully updated");
    }
}
