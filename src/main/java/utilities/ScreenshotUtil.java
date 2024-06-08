package utilities;

import basepackage.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.poi.common.usermodel.PictureType;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import javax.swing.text.DateFormatter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class ScreenshotUtil extends TestBase {

    public static String screenshotPath;
    public static String screenshotName;

    public static void captureSnapshot() {
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE); //somewhere in memory
            Date date = new Date();
            screenshotPath = System.getProperty("user.dir") + "//screenshots//";
            screenshotName =  "Screenshot-" + date.toString().replace(":","-").replace(" ","_") + ".jpg";
            File targetFile = new File(screenshotPath + screenshotName);
            FileUtils.copyFile(source, targetFile);
            InputStream fis = new FileInputStream(targetFile);
            run.addBreak();
            run.addPicture(fis, XWPFDocument.PICTURE_TYPE_JPEG, screenshotName, Units.toEMU(450), Units.toEMU(350));
            fis.close();
            targetFile.delete();
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
    }

}
