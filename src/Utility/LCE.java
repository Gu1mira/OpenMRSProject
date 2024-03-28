package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LCE {
    public LCE() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "//a[@class='zak-button']")
    public WebElement demoButton;

    @FindBy(xpath = "//div[@class='gt-selected']")
    public WebElement selectLanguage;

    @FindBy(xpath = "//div[@class='gt-current-lang']//img")
    public WebElement flagImg;

    @FindBy(xpath = "//a[@data-gt-lang='en']")
    public WebElement choiceLanguage;

    @FindBy(xpath = "//span[text()='Explore OpenMRS 2']/../..")
    public WebElement exploreMRS2Button;

    @FindBy(xpath = "//span[text()='Enter the OpenMRS 2 Demo']/../..")
    public WebElement demoMRS2Button;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement userName;


    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@id='sessionLocation']/li")
    public List<WebElement> sessionLocation;


    @FindBy(xpath = "//input[@id='loginButton']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@id='content']//h4")
    public WebElement loggedMsg;

}
