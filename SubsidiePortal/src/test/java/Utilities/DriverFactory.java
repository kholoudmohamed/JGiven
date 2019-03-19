package Utilities;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    /**/

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverFactory.driver = driver;
    }

    //public static void CloseDriver()
    //{
     //   driver.close();
    //}
}
