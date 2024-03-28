package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;
//other basedriver

public class GWD {

    public static WebDriver driver1;

    public static WebDriverWait wait1;

    @BeforeClass
    public void initialisationProcess() {

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        driver1 = new ChromeDriver();

        driver1.manage().window().maximize();
        driver1.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        wait1 = new WebDriverWait(driver1, Duration.ofSeconds(20));

    }

    @AfterClass
    public void closingProcess() {
        Tools.Wait(2);

        driver1.quit();
    }


}
