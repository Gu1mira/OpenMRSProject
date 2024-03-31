package US_401;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_401Elements extends GWD {
    public US_401Elements() {
        PageFactory.initElements(GWD.driver1, this);
    }

    @FindBy(css = "[class='zak-button']")
    public WebElement demoButton1;


    @FindBy(xpath = "//a[contains(@href,'#openmrs2')]/span/span")
    public WebElement exploreopenMRS2;

    @FindBy(xpath = "//a[contains(@href,'openmrs/login.htm')]/span/span")
    public WebElement enterOpenMRS2Demo;

    @FindBy(xpath = "//*[@id=username]")
    public WebElement userName;

    @FindBy(xpath = "//*[@id=password]")
    public WebElement password;

    @FindBy(xpath = "//li[@id='Inpatient Ward']")
    public WebElement inpatientWard;

    @FindBy(css = "[id='sessionLocationError']")
    public WebElement errorMesaj;

    @FindBy(xpath = "//*[@id='loginButton']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id='error-message']")
    public WebElement errorMesaj2;
}
