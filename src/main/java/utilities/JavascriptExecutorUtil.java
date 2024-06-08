package utilities;

import basepackage.ActionBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavascriptExecutorUtil extends ActionBase {

    public static JavascriptExecutor js = (JavascriptExecutor) driver;;

    public static void highLighter(WebElement element) {
        js.executeScript("arguments[0].style.background='yellow'", element);
    }


}
