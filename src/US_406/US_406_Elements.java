package US_406;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class US_406_Elements extends BaseDriver {

    @FindBy(xpath = "//a[contains(@href, 'coreapps.findPatient')]")
    public WebElement FindPatient;


    @FindBy(xpath = "//input[@id=\"patient-search\"]")
    public WebElement FindPatientSearch;

    @FindBy(xpath = "//td[text()='Michael Taylor']")
    public WebElement PatientName;

    public static final String NO_MATCH_LOCATOR = "//td[@class='dataTables_empty' and text()='No matching records found']";


    public US_406_Elements() {
        // PageFactory ile öğeleri başlat
        PageFactory.initElements(BaseDriver.driver, this);

    }
}
