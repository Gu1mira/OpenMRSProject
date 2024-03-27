package Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    public void BaslangicIslemleri(){


        driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // 20 sn mühlet: elementi bulma mühleti
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Tools.Bekle(2);
    }



    @AfterClass
    public void KapanisIslemleri(){  // TearDown
        //System.out.println("kapanış işlemleri yapılıyor"); //BekleKapat

        //logout
        Tools.Bekle(3);
        driver.quit();

        logKeeper.info("Driver kapatıldı");
    }

    @BeforeMethod
    public void BeforeMetod(){
         logKeeper.info("Metod başladı");

         logKeeper.warn("WARN : Metod başladı, hata oluşmuş olsa idi");
    }

    @AfterMethod
    public void AfterMetod(ITestResult sonuc){ // tesin sonuç ve isim bilgisini olduğu değişkeni
        logKeeper.info(sonuc.getName()+  " Metod bitti "+ (sonuc.getStatus() ==1 ? "Passed" : "failed"));

        logKeeper.warn("WARN : Metod bitti, hata oluşmuş olsa idi");
    }


}


