package acceptancetests.pages;

import acceptancetests.utils.WaitHelper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReadyToWorkPage {
    private final WebDriver driver;

    private WaitHelper waitHelper;

    @FindBy(xpath = "//p[text()=\"ReadytoWork e-Learning Platform\"]")
    @CacheLookup
    WebElement readyToWork;

    @FindBy(xpath = "//span[text()=\" Sign in\"]")
    @CacheLookup
    WebElement signInButton;

    public ReadyToWorkPage(WebDriver driver) {
        this.driver = driver;
        waitHelper = new WaitHelper(driver);
        PageFactory.initElements(driver,this);
    }

    /**
     * @return true if ReadyToWork e-learning Platform is displayed from home page
     */
    public boolean isReadyToWorkELearningDisplayed() {
        return readyToWork.isDisplayed();
    }

    /**
     * clicking sign in button from Home page
     * user move to login page
     */
    public LoginPage clickOnSignInButtonHomePage() {
        waitHelper.WaitForElement(signInButton, 20);
        signInButton.click();
        return new LoginPage(driver);
    }
}
