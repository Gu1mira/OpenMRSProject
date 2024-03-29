package US_409;

import Utilities.BaseDriver;
import Utilities.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class US_409 extends BaseDriver {
    @Test
    public void TestLogin() {
        US_409_Elements elems = new US_409_Elements();

        System.out.println("Login Test started");
        logKeeper.info("Login Test started");
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));

        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("admin");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Admin123");

        // Locate all the option elements
        List<WebElement> options = driver.findElements(By.xpath("//*[@tabindex='0']"));

        // Generate a random index within the range of options size
        int randomIndex = new Random().nextInt(options.size());

        // Click on the option at the random index
        options.get(randomIndex).click();

        WebElement loginBtn = driver.findElement(By.id("loginButton"));
        loginBtn.click();

        wait.until(ExpectedConditions.titleIs("Home"));
        Assert.assertTrue(driver.getTitle().equals("Home"));
        System.out.println("Login is finished.");

        logKeeper.info("Log işlemi tamamlandı");


        elems.registerPatient.click();
    }

    @Test(dataProvider = "patientData")
    public void patientRegister1(String name, String surname, String day, String year, String address) {
        US_409_Elements elems1 = new US_409_Elements();
        elems1.name.sendKeys(name);
        Tools.Bekle(2);
        elems1.surname.sendKeys(surname);
        Tools.Bekle(2);
        elems1.nextButton.click();
        Tools.Bekle(2);
        elems1.Male.click();
        Tools.Bekle(2);
        elems1.nextButton.click();
        Tools.Bekle(2);
        elems1.birthdayDay.sendKeys(day);
        Tools.Bekle(2);
        elems1.birthdayMonth.click();
        Tools.Bekle(2);
        elems1.birthdayYear.sendKeys(year);
        Tools.Bekle(2);
        elems1.nextButton.click();
        Tools.Bekle(2);
        elems1.address.sendKeys(address);
        Tools.Bekle(2);
        elems1.nextButton.click();
        Tools.Bekle(2);
        elems1.nextButton.click();
        Tools.Bekle(2);
        elems1.submit.click();
        Tools.Bekle(2);
        String id1=elems1.id.getText();
    }


    @Test(dataProvider = "patientData")
    public void patientRegister2(String name, String surname, String day, String year, String address) {
        US_409_Elements elems2 = new US_409_Elements();
        elems2.homePage.click();
        elems2.registerPatient.click();
        elems2.name.sendKeys(name);
        Tools.Bekle(2);
        elems2.surname.sendKeys(surname);
        Tools.Bekle(2);
        elems2.nextButton.click();
        Tools.Bekle(2);
        elems2.Male.click();
        Tools.Bekle(2);
        elems2.nextButton.click();
        Tools.Bekle(2);
        elems2.birthdayDay.sendKeys(day);
        Tools.Bekle(2);
        elems2.birthdayMonth.click();
        Tools.Bekle(2);
        elems2.birthdayYear.sendKeys(year);
        Tools.Bekle(2);
        elems2.nextButton.click();
        Tools.Bekle(2);
        elems2.address.sendKeys(address);
        Tools.Bekle(2);
        elems2.nextButton.click();
        Tools.Bekle(2);
        elems2.nextButton.click();
        Tools.Bekle(2);
        elems2.submit.click();
        Tools.Bekle(2);
        String id1=elems2.id.getText();
    }


    @DataProvider(name = "patientData")
    public static Object[][] patientData() {
        return new Object[][]{
                {"Michael", "Johnson", "12", "1980", "Mustamae tee, 123-4, Tallinn, Estonia"},
                {"Peter", "Lee", "1", "1870", "Money str, 000-2, Tallinn, Estonia"},
        };


    }
}

