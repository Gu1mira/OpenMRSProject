package Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Tools {

    public static void Wait(int sec) {

        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void JavaScriptClick(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) BaseDriver.driver;
        jse.executeScript("arguments[0].click();", element);
    }


    public static boolean ListContainsString(List<WebElement> list, String wordToSearch) {

        boolean foundIn = false;

        for (WebElement e : list) {

            if (e.getText().toUpperCase().contains(wordToSearch.toLowerCase()))
                foundIn = true;
        }
        return foundIn;
    }

    public static int randomGenerator(int limit) {
        return (int) (Math.random() * limit);
    }


}
