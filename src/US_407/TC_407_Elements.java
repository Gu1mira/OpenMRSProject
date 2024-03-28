package US_407;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC_407_Elements extends BaseDriver {
    public TC_407_Elements(){
        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(xpath = "//*[@id=\"Inpatient Ward\"]")
    public WebElement selectLocation;

    @FindBy(css = "[class='icon-search']")
    public WebElement findPatient;

    @FindBy(xpath = "//*[@id=\"patient-search\"]")
    public WebElement searchBox;

    @FindBy(css = "[class='recent-lozenge']")
    public WebElement searchResult;

    @FindBy(xpath = "//div[contains(text(),'Delete Patient')]")
    public WebElement deletePatient;

    @FindBy(xpath = "//div[contains(text(),'Delete Patient')]")
    public WebElement confirmButton;

}