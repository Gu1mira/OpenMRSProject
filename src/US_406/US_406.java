package US_406;

import TC_409.Utilities.BaseDriver;
import US_405.US_405_Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_406 extends BaseDriver {

    @Test
    public void US_406_Test() {

        US_406_Elements elements = new US_406_Elements();

        elements.FindPatient.click();
        elements.FindPatientSearch.sendKeys("Michael Taylor");
        elements.PatientName.click(); //
    }


    @Test
    public void US_406_Negative() {
        // US_406_Elements sınıfını başlat
        US_406_Elements elements = new US_406_Elements();

        // Hasta aramasını gerçekleştir
        elements.FindPatient.click();
        elements.FindPatientSearch.sendKeys("Elcin Burak");


        WebElement noMatchElement = driver.findElement(By.xpath(US_406_Elements.NO_MATCH_LOCATOR));

        Assert.assertNotNull(noMatchElement);//mesajı doğrulamak
    }
}
