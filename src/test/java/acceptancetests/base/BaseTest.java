package acceptancetests.base;

import acceptancetests.pages.ForgotPasswordPage;
import acceptancetests.pages.LoginPage;
import acceptancetests.pages.MyLearningPage;
import acceptancetests.pages.ReadyToWorkPage;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;
    protected ReadyToWorkPage readyToWorkPage;
    protected LoginPage loginPage;
    protected MyLearningPage myLearningPage;
    protected ForgotPasswordPage forgotPasswordPage;

    public String getPageTitle(){
       return driver.getPageSource();
    }
}
