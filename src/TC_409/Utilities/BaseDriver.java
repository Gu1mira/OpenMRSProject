package TC_409.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.time.Duration;

public class BaseDriver {
    public static Logger logTutma = LogManager.getLogger(); // Logları ekleyeceğim nesneyi başlattım.

    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeClass
    public void BaslangicIslemleri(){ // TearStart
       // System.out.println("başlangıç işlemleri yapılıyor"); //driver oluşturma, wait işlemleri,

        driver=new ChromeDriver();

        //driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // 20 sn mühlet: elementi bulma mühleti
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        src.Utilities.Tools.Bekle(2);
        LoginTest();
    }

    public void LoginTest(){
        System.out.println("Login Test başladı");
        logTutma.info("Log işlemi başladı");
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        src.Utilities.Tools.Bekle(2);

        WebElement email=driver.findElement(By.id("input-email"));
        email.sendKeys("testng1@gmail.com");

        WebElement password=driver.findElement(By.id("input-password"));
        password.sendKeys("123qweasd");

        WebElement loginBtn=driver.findElement(By.xpath("//input[@type='submit']")); //By.cssSelector("[value='Login']")
        loginBtn.click();

        wait.until(ExpectedConditions.titleIs("My Account"));
        Assert.assertTrue(driver.getTitle().equals("My Account"));
        System.out.println("Login Test bitti");

        logTutma.info("Log işlemi tamamlandı"); // normal bir bilgi

        //legonun kapanması için- butonlar altına kalınca tıklatma yapılamıyor
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.className("bitnami-corner-image"))).perform();
        driver.findElement(By.id("bitnami-close-banner-button")).click();
    }

    @AfterClass
    public void KapanisIslemleri(){  // TearDown
        //System.out.println("kapanış işlemleri yapılıyor"); //BekleKapat

        //logout
        src.Utilities.Tools.Bekle(3);
        driver.quit();

        logTutma.info("Driver kapatıldı");
    }

    @BeforeMethod
    public void BeforeMetod(){
         logTutma.info("Metod başladı");

         logTutma.warn("WARN : Metod başladı, hata oluşmuş olsa idi");
    }

    @AfterMethod
    public void AfterMetod(ITestResult sonuc){ // tesin sonuç ve isim bilgisini olduğu değişkeni
        logTutma.info(sonuc.getName()+  " Metod bitti "+ (sonuc.getStatus() ==1 ? "Passed" : "failed"));

        logTutma.warn("WARN : Metod bitti, hata oluşmuş olsa idi");
    }


}


