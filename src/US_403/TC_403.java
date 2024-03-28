package US_403;

import Utilities.BaseDriver;
import Utilities.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_403 extends BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver.get("https://openmrs.org/");
        Tools.Bekle(3);

        WebElement demo=driver.findElement(By.cssSelector("a[class='zak-button']"));
        demo.click();

        WebElement demo2=driver.findElement(By.xpath("//span[@class='elementor-button-text'])[2]"));
        demo2.click();

    }

    @Test(priority = 1)
    public void testLogin() {
        // Login sayfasına git
        driver.findElement(By.linkText("Login")).click();

        // Kullanıcı adı ve şifreyi gir
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("Admin123");

        //Location tikla
        driver.findElement(By.id("Inpatient Ward")).click();

        // Giriş yap butonuna tıkla
        driver.findElement(By.id("loginButton")).click();

        // Başarılı girişi kontrol et
        Assert.assertTrue(driver.findElement(By.id("logoutButton")).isDisplayed(), "Kullanıcı başarılı bir şekilde giriş yapmalıdır.");
    }

    @Test(priority = 2, dependsOnMethods = "testLogin")
    public void testLocation() {
        // Giriş yapıldıktan sonra location'ı kontrol et
        Assert.assertTrue(driver.findElement(By.id("location")).isDisplayed(), "Kullanıcı giriş yaptığı sayfada location'ı görebilmelidir.");
    }

    @Test(priority = 3, dependsOnMethods = "testLogin")
    public void testLogout() {
        // Logout butonunu bul ve tıkla
        driver.findElement(By.id("logoutButton")).click();

        // Logout işleminin başarılı olduğunu kontrol et
        Assert.assertEquals(driver.getCurrentUrl(), "https://openmrs.org/login.htm", "Kullanıcı güvenli bir şekilde logout olabilmelidir.");
    }

    @AfterClass
    public void closebrowser() {
        // Tarayıcıyı kapat
        driver.quit();
    }


}



