package Utilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    Properties properties;

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

    public String readProperty(String key) {
        return properties.getProperty(key);
    }


    //Return values
    public String getSubsidieBaseUrl () {
        return readProperty("SubsidieBaseURL");
    }

    public String getBrowser () {
        return readProperty("browser");
    }
    public Boolean IsChromeHeadless () {
        return Boolean.parseBoolean(readProperty("chromeHeadless"));
    }
    public String getChromeDriverPath () {
        return System.getProperty("user.dir")+readProperty("chromeDriverpath");
    }
    public String getfirefoxDriverPath () {
        return System.getProperty("user.dir")+readProperty("firefoxDriverpath");
    }

    public String getScreenSize () {
        return readProperty("screenSize");
    }
    public String getScreenSizeHeight () {
        return readProperty("screenSizeHeight");
    }
    public String getScreenSizeWidth () {
        return readProperty("screenSizeWidth");
    }

    public String getScreenShotsLocation () {
        return readProperty( "screenShotsLocation");}



}
