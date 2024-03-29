package US_409;

import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_409_Elements {
    public US_409_Elements(){
        PageFactory.initElements(BaseDriver.driver,this);
    }


    @FindBy(xpath = "//div[@class='logo']")
    public WebElement homePage;
    @FindBy(xpath = "//*[@class='icon-user']")
    public WebElement registerPatient;

    @FindBy(xpath = "//input[@name='givenName']")
    public WebElement name;

    @FindBy(xpath = "//input[@name='familyName']")
    public WebElement surname;

    @FindBy(id = "next-button")
    public WebElement nextButton;

    @FindBy(xpath = "(//*[@id='gender-field']/option)[1]")
    public WebElement Male;

    @FindBy(id = "birthdateDay-field")
    public WebElement birthdayDay;

    @FindBy(xpath = "(//*[@id='birthdateMonth-field']/option)[2]")
    public WebElement birthdayMonth;

    @FindBy(xpath = "//*[@id='birthdateYear-field']")
    public WebElement birthdayYear;

    @FindBy(xpath = "//*[@id='address1']")
    public WebElement address;

    @FindBy(xpath = "//*[@id='submit']")
    public WebElement submit;


    @FindBy(xpath = "//*[@class='float-sm-right']/span")
    public WebElement id;















}
