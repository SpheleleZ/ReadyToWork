package acceptancetests.steps;

import acceptancetests.base.BaseTest;
import acceptancetests.pages.LoginPage;
import acceptancetests.pages.MyLearningPage;
import acceptancetests.pages.ReadyToWorkPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class ReadyToWorkSteps extends BaseTest {

    /**
     * Steps definition for Ready to work home page ReadyToWork.Feature
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
        Assert.assertTrue(readyToWorkPage.isReadyToWorkELearningDisplayed());
    }

    @And("^close the browser$")
    public void close_the_browser() {
        driver.quit();
    }


    /**
     * Steps definition for Ready to work Login.Feature
     */
    @And("^user click on sign in button$")
    public void user_click_on_sign_in_button() {
        readyToWorkPage = new ReadyToWorkPage(driver);
        loginPage = new LoginPage(driver);
        loginPage = readyToWorkPage.clickOnSignInButtonHomePage();
    }

    @Then("^verify login page is open$")
    public void verify_login_page_is_open() {
        assertEquals("Sign In", loginPage.verifyLoginPage());
    }

    @When("^user enters (.*) and (.*)$")
    public void user_enters_and(String email, String password) {
        loginPage.setEmailInputField(email);
        loginPage.setPasswordInputField(password);
    }

    @Then("^user logged in successfully$")
    public void user_logged_in_successfully() {
        myLearningPage = new MyLearningPage(driver);
        myLearningPage = loginPage.clickOnSignInButton();
        assertTrue(myLearningPage.isWelcomeBackDisplayed());
    }

    @And("^verify My learning page is open$")
    public void verify_my_learning_page_is_open() {
        assertTrue(myLearningPage.isMyLearningDisplayed());
    }

    @And("^user click on logout button$")
    public void user_click_on_logout_button() {
        myLearningPage.clickOnSignOutButton();
    }
}
