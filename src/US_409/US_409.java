package US_409;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class US_409 extends BaseDriver {
    @Test
    public void Test409(){
        US_409_Elements elems=new US_409_Elements();

        System.out.println("Login Test started");
        logKeeper.info("Login Test started");
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));

        WebElement email=driver.findElement(By.id("username"));
        email.sendKeys("admin");

        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("Admin123");

        // Locate all the option elements
        List<WebElement> options = driver.findElements(By.xpath("//*[@tabindex='0']"));

        // Generate a random index within the range of options size
        int randomIndex = new Random().nextInt(options.size());

        // Click on the option at the random index
        options.get(randomIndex).click();

        WebElement loginBtn=driver.findElement(By.id("loginButton"));
        loginBtn.click();

        wait.until(ExpectedConditions.titleIs("Home"));
        Assert.assertTrue(driver.getTitle().equals("Home"));
        System.out.println("Login is finished.");

        logKeeper.info("Log işlemi tamamlandı");



        elems.registerPatient.click();

    }
}
