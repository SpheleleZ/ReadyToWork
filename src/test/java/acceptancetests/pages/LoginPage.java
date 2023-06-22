package acceptancetests.pages;

import acceptancetests.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final WebDriver driver;

    private WaitHelper waitHelper;

    @FindBy(id = "formBasicEmail")
    @CacheLookup
    WebElement emailInputField;

    @FindBy(id = "formBasicPassword")
    @CacheLookup
    WebElement passwordInputField;

    @FindBy(xpath = "//button[text()=\"Sign In\"]")
    @CacheLookup
    WebElement signInButton;

    @FindBy(xpath = "//h3[text()=\"Sign In\"]")
    @CacheLookup
    WebElement signInPage;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        waitHelper = new WaitHelper(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * set up email for login email input field
     *
     * @param email address for user
     */
    public void setEmailInputField(String email) {
        emailInputField.clear();
        emailInputField.sendKeys(email);
    }

    /**
     * set up password for login password input field
     *
     * @param password for user
     */
    public void setPasswordInputField(String password) {
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
    }

    /**
     * clicking sign in button for user to login
     * User move to my-learning page
     */
    public MyLearningPage clickOnSignInButton() {
        waitHelper.WaitForElement(signInButton, 20);
        signInButton.click();
        return new MyLearningPage(driver);
    }

    /**
     * @return sign in text from sign in page
     */
    public String verifyLoginPage(){
        return signInPage.getText();
    }
}
