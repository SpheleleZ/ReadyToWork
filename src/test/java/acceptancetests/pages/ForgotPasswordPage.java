package acceptancetests.pages;

import acceptancetests.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

    protected final WebDriver driver;
    private final WaitHelper waitHelper;

    @FindBy(xpath = "//h3[text()=\"Reset Password\"]")
    @CacheLookup
    WebElement forgotPasswordPage;

    @FindBy(id = "formBasicEmail")
    @CacheLookup
    WebElement emailField;

    @FindBy(xpath = "//button[text()=\"Reset Password\"]")
    @CacheLookup
    WebElement resetPasswordButton;

    @FindBy(xpath = "//div[text()=\"Email sent. Please check your inbox for further instructions.\"]")
    @CacheLookup
    WebElement resetLink;

    @FindBy(xpath = "//button[text()=\"Ok\"]")
    @CacheLookup
    WebElement clickOnOkayButton;

    @FindBy(xpath = "//div[@role=\"alert\"]")
    @CacheLookup
    WebElement alertWrongEmail;

    @FindBy(xpath = "//button[text()=\"Close\"]")
    @CacheLookup
    WebElement closeButton;

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
        waitHelper = new WaitHelper(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean isForgotPasswordPageOpen(){
        waitHelper.WaitForElement(forgotPasswordPage,20);
        return forgotPasswordPage.isDisplayed();
    }

    public void setEmailField(String email){
        waitHelper.WaitForElement(emailField,20);
        emailField.sendKeys(email);
    }

    public void clickOnResetPasswordButton(){
        waitHelper.WaitForElement(resetPasswordButton,20);
        resetPasswordButton.click();
    }

    public boolean isRestLinkDisplayed(){
        waitHelper.WaitForElement(resetLink,20);
        return resetLink.isDisplayed();
    }

    public void setClickOnOkayButton(){
        waitHelper.WaitForElement(clickOnOkayButton,20);
        clickOnOkayButton.click();
    }

    public boolean isAlertForWrongEmailDisplayed(){
        waitHelper.WaitForElement(alertWrongEmail,20);
        return alertWrongEmail.isDisplayed();
    }

    public void setCloseButton(){
        waitHelper.WaitForElement(closeButton,20);
        closeButton.click();
    }
}
