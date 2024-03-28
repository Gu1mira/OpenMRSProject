package US_404;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class TC_404 {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // WebDriver'ı başlat
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://openmrs.org/");
    }

    @Test(priority = 1)
    public void testLogin() {
        // Rastgele olarak Location butonuna tıkla
        clickRandomLocationButton();
        // Kullanıcı girişi yap
        login("your_username", "your_password");

        // Başarılı girişin kontrolü
        Assert.assertTrue(isLoggedIn(), "Başarılı bir şekilde giriş yapılamadı.");
    }

    @Test(priority = 2)
    public void testPatientRegistration() {
        // Register a patient butonuna tıkla
        driver.findElement(By.linkText("Register a patient")).click();

        // Customer data girilir (Demographics / Contact Info / Relationships)
        // Burada gerekli alanlara veri girişi yapılır

        // Confirm butonuna tıkla
        driver.findElement(By.id("confirmButton")).click();

        // Hasta sayfasına yönlendirildiğini ve hasta ismi ve ID'sinin göründüğünü doğrula
        Assert.assertTrue(isOnPatientPage(), "Hasta sayfasına yönlendirilemedi veya hasta ismi ve ID'si görüntülenemedi.");
    }

    @AfterClass
    public void tearDown() {
        // WebDriver'ı kapat
        driver.quit();
    }

    private void clickRandomLocationButton() {
        List<WebElement> locationButtons = driver.findElements(By.className("location-button"));
        Random random = new Random();
        int randomIndex = random.nextInt(locationButtons.size());
        locationButtons.get(randomIndex).click();
    }

    private void login(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    private boolean isLoggedIn() {
        return !driver.findElements(By.id("error-message")).isEmpty();
    }

    private boolean isOnPatientPage() {
        return driver.getCurrentUrl().contains("patient") && driver.getPageSource().contains("Patient Name") && driver.getPageSource().contains("Patient ID");
    }
}