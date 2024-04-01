package US_402;

import Utilities.BaseDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class TC_402 extends BaseDriver {


 @Test(dataProvider = "userData")
    public void testLogin(String username, String password) {

        driver.get("https://openmrs.org/");

        WebElement demoButton = driver.findElement(By.xpath("(//a[contains(text(),'Demo')])[2]"));
        demoButton.click();

        WebElement exploreButton = driver.findElement(By.xpath("//*[text()='Explore OpenMRS 2']"));
        exploreButton.click();

        WebElement enterDemoButton = driver.findElement(By.linkText("Enter the OpenMRS 2 Demo"));
        enterDemoButton.click();


        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);

        List<WebElement> options = driver.findElements(By.xpath("//*[@tabindex='0']"));
        int randomIndex = new Random().nextInt(options.size());
        options.get(randomIndex).click();

        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        if(driver.getTitle().equals("Login")){
            driver.get("https://openmrs.org/");
     }

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "expectedUrlAfterLogin");

        WebElement errorElement = driver.findElement(By.id("error-message"));
        Assert.assertTrue(errorElement.isDisplayed());
    }


    @DataProvider
    public Object[][] userData() {
        Object[][] data = {
                {"", ""},
                {"admin", ""},
                {"", "Admin123"},
                {"name1", "Admin123"},
                {"admin", "password5"},
                {"3", "password6"},
                {"admin", "Admin123"}

        };
        return data;
    }

        @AfterClass
        public void tearDown() {
            driver.quit();

        }


    }





