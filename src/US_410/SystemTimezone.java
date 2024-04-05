package US_410;

import Utility.*;
import TC_409.TC_409_Elements;
import Utility.BaseDriver;
import Utility.GWD;
import Utility.LCE;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import US_410.HomePageContent;
import US_410.LoginContent;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.*;

import static Utilities.Tools.*;

public class SystemTimezone extends BaseDriver {
    // The Robot class codes are written in a manner compatible with Windows and switch between GMT+0 and GMT+3 time zones.
    @Test(groups = {"Regression", "Appointment", "DependsOn"}, dependsOnMethods = {"US_402.PerformLoginInTheSystem.TC_PerformLoginInTheSystem"}, priority = 10)
    public void TC_SystemTimezone() throws AWTException {
        LCE lc = new LCE();
        TC_409_Elements hc = new TC_409_Elements();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Robot rb = new Robot();
        ZonedDateTime timeUTC = ZonedDateTime.now(ZoneOffset.UTC);
        LocalTime timeLocal = LocalTime.now();
        boolean timeCondition = timeLocal.getHour() == timeUTC.getHour();
        //LCE(lc.demoButton);
        //LCE(lc.exploreOpenMRS2);
        //LCE(lc.exploreOpenMRS2Demo);
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.openmrs.org/openmrs/login.htm", "User couldn't land on the login page of Demo OpenMRS");
        //mySendKeys(lc.username, "admin");
        mySendKeys(lc.password, "Admin123");
        //myClick(lc.locations.getFirst());
        //myClick(lc.logInButton);
        //langCheck();
        //myClick(hc.findPatientRecord);
        //String ID = hc.patientRecordList.getFirst().findElement(By.cssSelector("td")).getText().substring(0, 6);
        driver.navigate().back();
        StringSelection gmt0 = new StringSelection("tzutil /s \"GMT Standard Time\"");
        StringSelection gmt3 = new StringSelection("tzutil /s \"Turkey Standard Time\"");
        StringSelection exit = new StringSelection("exit");
        StringSelection cmd = new StringSelection("cmd");
        for (int i = 0; i < 2; i++) {
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(cmd, null);
          //  myClick(hc.schedulingButton);
          //  myClick(hc.manageAppointments);
           // mySendKeys(hc.patientSearch, ID + Keys.ARROW_DOWN + Keys.ENTER);
            wait.until(ExpectedConditions.elementToBeClickable(hc.submit));
            if (!timeCondition) {
                Assert.assertNotNull(hc.homePage.equals(timeLocal), "Error message couldn't be displayed!");
            } else {
                Assert.assertNotNull(hc.homePage.getLocation(), "Error message displayed!");
            }
            rb.keyPress(KeyEvent.VK_WINDOWS);
            rb.keyRelease(KeyEvent.VK_WINDOWS);
            Utilities.Tools.Bekle(1);

           // ParentPage.roboPaste();
            Utilities.Tools.Bekle(1);

            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            Utilities.Tools.Bekle(3);

            if (!timeCondition) {
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(gmt0, null);
                timeCondition = true;
            } else {
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(gmt3, null);
                timeCondition = false;
            }
            Utilities.Tools.Bekle(1);

            // ParentPage.roboPaste();
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            Utilities.Tools.Bekle(1);

            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(exit, null);
            // ParentPage.roboPaste();
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
        //    if (i != 1)
        //     myClick(hc.homeButton);
        }
    }
}