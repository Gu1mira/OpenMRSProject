package US_409;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.ILoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class US_409 extends BaseDriver {
    @Test
    public void Test409(){
        US_409_Elements elems=new US_409_Elements();

        LoginProcesses();

    }
}
