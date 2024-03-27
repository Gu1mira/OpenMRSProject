package US_405;

import TC_409.Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class US_405_Elements extends BaseDriver {

    @FindBy(xpath = "//*[@class='icon-user small']")
    public WebElement admin;

    @FindBy(xpath = "//a[@href='/openmrs/adminui/myaccount/myAccount.page' and normalize-space()='My Account']")
    public WebElement myAccount;

    @FindBy(xpath = "//a[@class='button app big' and contains(@href, 'changePassword.page')]")
    public WebElement changePassword;

    @FindBy(xpath = "//input[@id='cancel-button' and @class='cancel' and @value='Cancel']")
    public WebElement passCancel;

    @FindBy(xpath = "//a[@class='button app big' and contains(@href, '/openmrs/adminui/myaccount/changeDefaults.page')]")
    public WebElement languageChange;

    @FindBy(xpath = "//input[@id='cancel-button' and @class='cancel']")
    public WebElement getLanguageChangeCancel;

    public US_405_Elements() {
        // PageFactory ile öğeleri başlat
        PageFactory.initElements(BaseDriver.driver, this);
    }
}
