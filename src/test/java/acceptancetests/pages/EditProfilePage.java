package acceptancetests.pages;

import acceptancetests.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditProfilePage {
    protected WebDriver driver;
    WaitHelper waitHelper;

    @FindBy(id = "first_name")
    @CacheLookup
    WebElement firstNameInputField;

    @FindBy(id = "last_name")
    @CacheLookup
    WebElement lastNameInputField;

    @FindBy(id = "contact_number")
    @CacheLookup
    WebElement contactNumber;

    @FindBy(id = "category")
    @CacheLookup
    WebElement category;

    @FindBy(id = "town")
    @CacheLookup
    WebElement city;

    @FindBy(id = "state")
    @CacheLookup
    WebElement province;

    @FindBy(id = "country")
    @CacheLookup
    WebElement country;

    @FindBy(xpath = "//h3[text()=\"Manage Profile\"]")
    @CacheLookup
    WebElement manageProfilePage;

    @FindBy(xpath = "//button[text()=\"Submit form\"]")
    @CacheLookup
    WebElement submitButton;

    @FindBy(xpath = "//div[text()=\"Profile details succefully updated\"]")
    @CacheLookup
    WebElement successfulAlert;

    @FindBy(id = "left-tabs-example-tab-password")
    @CacheLookup
    WebElement manageAccountButton;

    @FindBy(xpath = "//a[text()=\"Reset  \"]")
    @CacheLookup
    WebElement resetButton;

    @FindBy(id = "currentPassword")
    @CacheLookup
    WebElement currentPassword;

    @FindBy(id = "newPassword")
    @CacheLookup
    WebElement newPassword;

    @FindBy(id = "confirmPassword")
    @CacheLookup
    WebElement confirmPassword;

    @FindBy(xpath = "//button[text()=\" Change Password\"]")
    @CacheLookup
    WebElement changePasswordButton ;

    @FindBy(xpath = "//div[text()=\"Password successfully changed\"]")
    @CacheLookup
    WebElement passwordAlertUpdated;

    public EditProfilePage(WebDriver driver) {
        this.driver = driver;
        waitHelper = new WaitHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public void setFirstNameInputField(String firstName){
        waitHelper.WaitForElement(firstNameInputField,20);
        firstNameInputField.clear();
        firstNameInputField.sendKeys(firstName);
    }

    public void setLastNameInputField(String lastName){
        waitHelper.WaitForElement(lastNameInputField,20);
        lastNameInputField.clear();
        lastNameInputField.sendKeys(lastName);
    }

    public void setContactNumber(String number){
        waitHelper.WaitForElement(contactNumber,20);
        contactNumber.clear();
        contactNumber.sendKeys(number);
    }

    public void setCategory(String cat){
        waitHelper.WaitForElement(category,20);
        Select select = new Select(category);
        select.selectByValue(cat);
    }

    public void setCity(String c){
        waitHelper.WaitForElement(city,20);
        city.clear();
        city.sendKeys(c);
    }

    public void setProvince(String pro){
        waitHelper.WaitForElement(province,20);
        province.clear();
        province.sendKeys(pro);
    }

    public void setCountry(String co){
        waitHelper.WaitForElement(country,20);
        country.clear();
        country.sendKeys(co);
    }

    public void setSubmitButton(){
        waitHelper.WaitForElement(submitButton,20);
        submitButton.click();
    }

    public String setSuccessfulAlert(){
        waitHelper.WaitForElement(successfulAlert,20);
       return successfulAlert.getText();
    }

    public boolean setManageProfilePage(){
        waitHelper.WaitForElement(manageProfilePage,20);
       return manageProfilePage.isDisplayed();
    }

    public void setManageAccountButton(){
        waitHelper.WaitForElement(manageAccountButton,20);
        manageAccountButton.click();
    }

    public void setResetButton(){
        waitHelper.WaitForElement(resetButton,20);
        resetButton.click();
    }

    public void setCurrentPassword(String current){
        waitHelper.WaitForElement(currentPassword,20);
        currentPassword.sendKeys(current);
    }

    public void setNewPassword(String newPass){
        waitHelper.WaitForElement(newPassword,20);
        newPassword.sendKeys(newPass);
    }

    public void setConfirmPassword(String confirm){
        waitHelper.WaitForElement(confirmPassword,20);
        confirmPassword.sendKeys(confirm);
    }

    public void setChangePasswordButton(){
        waitHelper.WaitForElement(changePasswordButton,20);
        changePasswordButton.click();
    }

    public String passwordAlertUpdated(){
        waitHelper.WaitForElement(passwordAlertUpdated,20);
        return passwordAlertUpdated.getText();
    }
}
