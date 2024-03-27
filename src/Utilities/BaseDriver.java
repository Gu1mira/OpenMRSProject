package src.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BaseDriver {
    public static Logger logKeeper = LogManager.getLogger();

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void BaslangicIslemleri() {


        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // 20 sn mühlet: elementi bulma mühleti
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));



        LoginTest();
    }

    public void LoginTest() {
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
    }

        @AfterClass
        public void KapanisIslemleri() {  // TearDown
            System.out.println("kapanış işlemleri yapılıyor"); //BekleKapat

            //logout

            TC_409.Utilities.Tools.Bekle(3);
            driver.quit();

            logKeeper.info("Driver kapatıldı");
        }

        @BeforeMethod
        public void BeforeMetod () {
            logKeeper.info("Metod başladı");

            logKeeper.warn("WARN : Metod başladı, hata oluşmuş olsa idi");
        }

        @AfterMethod
        public void AfterMetod (ITestResult sonuc){ // tesin sonuç ve isim bilgisini olduğu değişkeni
            logKeeper.info(sonuc.getName() + " Metod bitti " + (sonuc.getStatus() == 1 ? "Passed" : "failed"));

            logKeeper.warn("WARN : Metod bitti, hata oluşmuş olsa idi");
        }


    }


