package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader {

    public static String stringvalue ="";

    public static String getPropertyValue(String key, String fileName) {
        try {
            Properties prop = new Properties();
            String file = System.getProperty("user.dir") + "/src/test/resources/" +fileName+ "";
            FileInputStream fis = new FileInputStream(file);
            prop.load(fis);
            stringvalue = prop.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringvalue;
    }
}
