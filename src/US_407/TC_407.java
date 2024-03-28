package US_407;

import Utility.BaseDriver;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Random;

public class TC_407 extends BaseDriver {
    @Test
    public void TC_407(){

        TC_407_Elements TTT=new TC_407_Elements();

        SoftAssert _softAssert=new SoftAssert();

        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));

        WebElement email=driver.findElement(By.id("username"));
        email.sendKeys("admin");

        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("Admin123");
        TTT.selectLocation.click();

        WebElement loginBtn=driver.findElement(By.id("loginButton"));
        loginBtn.click();

        wait.until(ExpectedConditions.titleIs("Home"));
        System.out.println("Login is finished.");

        wait.until(ExpectedConditions.titleIs("Home"));
        wait.until(ExpectedConditions.elementToBeClickable(TTT.findPatient));
        TTT.findPatient.click();
        wait.until(ExpectedConditions.elementToBeClickable(TTT.searchBox));
        TTT.searchBox.sendKeys("100K18" + Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(TTT.searchResult));
        TTT.searchResult.click();
        wait.until(ExpectedConditions.elementToBeClickable(TTT.deletePatient));
        TTT.deletePatient.click();

        TTT.deleteReason.sendKeys("Canım Öyle İstiyor");

        TTT.deleteConfirm.click();
        _softAssert.assertAll();






    }
}