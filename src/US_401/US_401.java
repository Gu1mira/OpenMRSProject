package US_401;

import Utilities.BaseDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_401 extends BaseDriver {

    @Test(dataProvider = "userData")
    public void testLogin(String userName, String password) {

        driver.get("https://openmrs.org/");

        WebElement demoButton1 = driver.findElement(By.cssSelector("[class='zak-button']"));
        demoButton1.click();

        WebElement exploreopenMRS2 = driver.findElement(By.xpath("//a[contains(@href,'#openmrs2')]/span/span"));
        exploreopenMRS2.click();

        WebElement enterOpenMRS2Demo = driver.findElement(By.xpath("//a[contains(@href,'openmrs/login.htm')]/span/span"));
        enterOpenMRS2Demo.click();


        WebElement username = driver.findElement(By.id("//*[@id=username]"));
        username.sendKeys(userName);

        WebElement password1 = driver.findElement(By.id("//*[@id=password]"));
        password1.sendKeys(password);


        WebElement inpatientWard = driver.findElement(By.xpath("//li[@id='Inpatient Ward']"));
        inpatientWard.click();


        WebElement errormessage = driver.findElement(By.id("[id='sessionLocationError']"));
        Assert.assertTrue(errormessage.isDisplayed());
    }


    @DataProvider
    public Object[][] userData() {
        Object[][] data1 = {
                {"", ""},
                {"admin", ""},
                {"", "Admin12345"},
                {"name2", "Admin123"},
                {"admin", "password5"},
                {"3", "password4"},
                {"admin", "Admin123"}

        };
        return data1;
    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }


}