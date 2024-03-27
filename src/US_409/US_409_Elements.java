package US_409;

import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_409_Elements {
    public US_409_Elements(){
        PageFactory.initElements(BaseDriver.driver,this);
    }


    @FindBy(xpath = "//*[@class='icon-user']")
    public WebElement registerPatient;
}
