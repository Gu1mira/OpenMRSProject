package TC_409;

import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC_409_Elements {
    public TC_409_Elements(){
        PageFactory.initElements(BaseDriver.driver,this);
    }


    @FindBy(xpath = "//div[@class='logo']")
    public WebElement homePage;
    @FindBy(xpath = "//*[@class='icon-user']")
    public WebElement registerPatient;

    @FindBy(id = "username")
    public WebElement loginEmail;

    @FindBy(id = "password")
    public WebElement loginPassword;

    @FindBy(id = "loginButton")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@name='givenName']")
    public WebElement name;

    @FindBy(xpath = "//input[@name='familyName']")
    public WebElement surname;

    @FindBy(id = "next-button")
    public WebElement nextButton;

    @FindBy(xpath = "(//*[@id='gender-field']/option)[1]")
    public WebElement male;

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

    @FindBy(xpath = "//*[contains(@id,'datamanagement')]")
    public WebElement dataManagement;

    @FindBy(xpath = "//*[contains(@id, 'mergePatients')]")
    public WebElement mergePatients;

    @FindBy(id = "patient1-text")
    public WebElement fieldID1;

    @FindBy(id = "patient2-text")
    public WebElement fieldID2;

    @FindBy(xpath = "//*[@class='confirm']")
    public WebElement mergeConfirm;

    @FindBy(id = "first-patient")
    public WebElement firstPatientChoose;

    @FindBy(xpath = "//input[@value='Yes, continue']")
    public WebElement yesMerge;

























}
