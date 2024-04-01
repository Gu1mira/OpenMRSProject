package US_409;

import Utilities.BaseDriver;
import Utilities.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class US_409 extends BaseDriver {
    @Test (groups = {"Regression", "PatientManagement"})
    public void TestLogin() {
        US_409_Elements elems=new US_409_Elements();
        List<String> patientIDs = new ArrayList<>();

        driver.get("https://demo.openmrs.org/openmrs/login.htm");
        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/login.htm"));
        Tools.mySendKeys(elems.loginEmail, "admin");
        Tools.mySendKeys(elems.loginPassword, "Admin123");
        List<WebElement> options = driver.findElements(By.xpath("//*[@tabindex='0']"));
        int randomIndex = new Random().nextInt(options.size());
        options.get(randomIndex).click();
        Tools.myClick(elems.loginButton);
        wait.until(ExpectedConditions.titleIs("Home"));
        Assert.assertEquals("Home", driver.getTitle());
        Tools.myClick(elems.registerPatient);

        Tools.mySendKeys(elems.name, "Michael");
        Tools.mySendKeys(elems.surname,"Johnson");
        Tools.myClick(elems.nextButton);
        Tools.myClick(elems.male);
        Tools.myClick(elems.nextButton);
        Tools.mySendKeys(elems.birthdayDay,"12");
        Tools.myClick(elems.birthdayMonth);
        Tools.mySendKeys(elems.birthdayYear,"1980");
        Tools.myClick(elems.nextButton);
        Tools.mySendKeys(elems.address,"Mustamae tee, 123-4, Tallinn, Estonia");
        Tools.myClick(elems.nextButton);
        Tools.myClick(elems.nextButton);
        Tools.myClick(elems.submit);
        patientIDs.add(elems.id.getText());
        System.out.println("Patient1 id= "+patientIDs.get(0));

        Tools.myClick(elems.homePage);
        Tools.myClick(elems.registerPatient);

        Tools.mySendKeys(elems.name, "Peter");
        Tools.mySendKeys(elems.surname,"Lee");
        Tools.myClick(elems.nextButton);
        Tools.myClick(elems.male);
        Tools.myClick(elems.nextButton);
        Tools.mySendKeys(elems.birthdayDay,"1");
        Tools.myClick(elems.birthdayMonth);
        Tools.mySendKeys(elems.birthdayYear,"1970");
        Tools.myClick(elems.nextButton);
        Tools.mySendKeys(elems.address,"Money str, 000-2, Tallinn, Estonia");
        Tools.myClick(elems.nextButton);
        Tools.myClick(elems.nextButton);
        Tools.myClick(elems.submit);
        patientIDs.add(elems.id.getText());
        System.out.println("Patient1 id= "+patientIDs.get(1));

        Tools.myClick(elems.homePage);
        Tools.myClick(elems.dataManagement);
        Tools.myClick(elems.mergePatients);
        Tools.mySendKeys(elems.fieldID1, patientIDs.get(0));
        Tools.mySendKeys(elems.fieldID2, patientIDs.get(1)+ Keys.ENTER);
        Tools.myClick(elems.mergeConfirm);
        Tools.myClick(elems.firstPatientChoose);
        Tools.myClick(elems.yesMerge);







    }





}


