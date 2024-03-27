package US_405;

import TC_409.Utilities.BaseDriver;
import org.testng.annotations.Test;

public class US_405 extends BaseDriver {

    @Test
    public void US_405_Test() {
        // US_405_Elements sınıfını başlat
        US_405_Elements elements = new US_405_Elements();

        // admin ve myAccount öğelerine erişerek işlemleri gerçekleştir
        elements.admin.click();
        elements.myAccount.click();
        elements.changePassword.click();
        elements.passCancel.click();// password değiştirme cancel etme
        elements.languageChange.click();
        elements.getLanguageChangeCancel.click(); // language değiştirme cancel etme
    }
}
