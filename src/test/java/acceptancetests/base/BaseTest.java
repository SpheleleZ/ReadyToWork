package acceptancetests.base;

import acceptancetests.pages.LoginPage;
import acceptancetests.pages.MyLearningPage;
import acceptancetests.pages.ReadyToWorkPage;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    public WebDriver driver;
    public ReadyToWorkPage readyToWorkPage;

    public LoginPage loginPage;

    public MyLearningPage myLearningPage;

    public String getPageTitle(){
       return driver.getPageSource();
    }
}
