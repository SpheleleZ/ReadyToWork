package acceptancetests.steps;

import acceptancetests.base.BaseTest;
import acceptancetests.pages.ForgotPasswordPage;
import acceptancetests.pages.LoginPage;
import acceptancetests.pages.MyLearningPage;
import acceptancetests.pages.ReadyToWorkPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class ReadyToWorkSteps extends BaseTest {

    /*
     * Steps definition for Ready to work:Home page ReadyToWork.Feature
     */

    @Given("^browser is launched$")
    public void browser_is_launched() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @And("^ready to work home page is open$")
    public void ready_to_work_home_page_is_open() {
        String url = "https://readytowork.absa.africa/";
        driver.get(url);
    }

    @Then("^ReadytoWork e-learning platform is displayed$")
    public void readyto_work_e_learning_platform_is_displayed() {
        readyToWorkPage = new ReadyToWorkPage(driver);
        assertTrue(readyToWorkPage.isReadyToWorkELearningDisplayed(), "ReadyToWork e-learning platform is not displayed");
    }

    @And("^close the browser$")
    public void close_the_browser() {
        driver.quit();
    }

    /*
     * Steps definition for Ready to work:Login with valid credentials
     */
    @And("^user click on sign in link$")
    public void user_click_on_sign_in_link() {
        readyToWorkPage = new ReadyToWorkPage(driver);
        loginPage = new LoginPage(driver);
        loginPage = readyToWorkPage.clickOnSignInLinkHomePage();
    }

    @Then("^verify login page is open$")
    public void verify_login_page_is_open() {
        assertEquals(loginPage.verifyLoginPage(), "Sign In", "Login page is not open");
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
        assertTrue(myLearningPage.isWelcomeBackDisplayed(), "User login unsuccessful");
    }

    @And("^verify My learning page is open$")
    public void verify_my_learning_page_is_open() {
        assertTrue(myLearningPage.isMyLearningDisplayed(), "My learning page is not open");
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
        assertTrue(loginPage.isLoginAlertDisplayed(), "login alert did not display");
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
        assertTrue(forgotPasswordPage.isForgotPasswordPageOpen(), "Forgot password page is no open");
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
        assertTrue(forgotPasswordPage.isRestLinkDisplayed(), "Alert did not display");
    }

    @And("click on okay button")
    public void click_on_okay_button() {
        forgotPasswordPage.setClickOnOkayButton();
    }

    /*
     * Step definition for Ready to Work:Forgot Password with inValid email or account
     */

    @Then("Alert display there is no associated with email address")
    public void alert_display_there_is_no_associated_with_email_address() {
      assertTrue(forgotPasswordPage.isAlertForWrongEmailDisplayed(),"alert for wrong email or account did not display");
    }

    @Then("click on close button")
    public void click_on_close_button() {
       forgotPasswordPage.setCloseButton();
    }
}
