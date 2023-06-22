package acceptancetests.pages;

import acceptancetests.utils.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyLearningPage {

    private final WebDriver driver;
    private final WaitHelper waitHelper;

    @FindBy(xpath = "//div[text()=\"My Learning\"]")
    @CacheLookup
    WebElement myLearning;

    @FindBy(tagName = "h3")
    @CacheLookup
    WebElement welcomeBack;

    @FindBy(xpath = "//span[text()=\" Logout\"]")
    @CacheLookup
    WebElement signoutButton;


    public MyLearningPage(WebDriver driver) {
        this.driver = driver;
        waitHelper = new WaitHelper(driver);
        PageFactory.initElements(driver,this);
    }

    /**
     * @return true if welcome back is displayed
     */
    public boolean isWelcomeBackDisplayed() {
        waitHelper.WaitForElement(welcomeBack,20);
        return welcomeBack.isDisplayed();
    }

    /**
     * @return true if My Learning option is displayed
     */
    public boolean isMyLearningDisplayed(){
        return myLearning.isDisplayed();
    }

    /**
     * clicking logout button from My learning page
     */
    public void clickOnSignOutButton(){
        waitHelper.WaitForElement(signoutButton,20);
        signoutButton.click();
    }
}
