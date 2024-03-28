package src.US_402;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Utility.BaseDriver;

public class TC_402 extends BaseDriver {

    WebDriver driver;

 @Test(dataProvider = "userData")
    public void testLogin(String username, String password) {

        driver.get("https://openmrs.org/");

        WebElement demoButton = driver.findElement(By.xpath("//button[contains(text(),'DEMO')]"));
        demoButton.click();

        WebElement exploreButton = driver.findElement(By.xpath("//button[contains(text(),'Explore OpenMRS 2')]"));
        exploreButton.click();

        WebElement enterDemoButton = driver.findElement(By.xpath("//button[contains(text(),'Enter the OpenMRS 2 Demo')]"));
        enterDemoButton.click();

        driver.get("https://openmrs.org/");

        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'loginButton')]"));
        loginButton.click();

        WebElement locationButton = driver.findElement(By.xpath("//button[contains(text(),'Location')]"));
        locationButton.click();

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





