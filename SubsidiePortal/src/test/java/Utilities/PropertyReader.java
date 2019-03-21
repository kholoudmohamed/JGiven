package Utilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    static Properties properties;

    InputStream inputStream = null;

    public PropertyReader() {
        properties = new Properties();
        loadProperties();
    }

    private void loadProperties() {
        try {
            inputStream = new FileInputStream("src/test/resources/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.print("Unable to load config.properties");
            e.printStackTrace();
        }
    }

    public static String readProperty(String key) {
        return properties.getProperty(key);
    }


    //Return values
    public String getSubsidieBaseUrl () {
        return readProperty("SubsidieBaseURL");
    }

    public static String getBrowser () {
        return readProperty("browser");
    }
    public static Boolean IsChromeHeadless () {
        return Boolean.parseBoolean(readProperty("chromeHeadless"));
    }
    public static String getChromeDriverPath () {
        return System.getProperty("user.dir")+readProperty("chromeDriverpath");
    }
    public static String getfirefoxDriverPath () {
        return System.getProperty("user.dir")+readProperty("firefoxDriverpath");
    }

    public static String getScreenSize () {
        return readProperty("screenSize");
    }
    public static String getScreenSizeHeight () {
        return readProperty("screenSizeHeight");
    }
    public static String getScreenSizeWidth () {
        return readProperty("screenSizeWidth");
    }

    public static String getScreenShotsLocation () {
        return readProperty( "screenShotsLocation");}
    public static String getCsvDataFile () {
        return readProperty("csvFilepath");
    }


}
