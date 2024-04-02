package US_410;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginContent extends HomePageContent {
    public LoginContent() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(css = "a[class='zak-button']")
    public WebElement demoButton;

    @FindBy(xpath = "(//span[@class='elementor-button-text'])[2]")
    public WebElement exploreOpenMRS2;

    @FindBy(xpath = "//*[text()='Enter the OpenMRS 2 Demo']")
    public WebElement exploreOpenMRS2Demo;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(css = "ul[id='sessionLocation']>li")
    public List<WebElement> locations;

    @FindBy(id = "loginButton")
    public WebElement logInButton;

    @FindBy(id = "sessionLocationError")
    public WebElement LocationAlert;

    @FindBy(id = "error-message")
    public WebElement credentialsAlert;
}
