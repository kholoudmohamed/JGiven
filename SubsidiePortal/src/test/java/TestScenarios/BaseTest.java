package TestScenarios;

import Actions.GivenSomeState;
import Actions.ThenSomeOutcome;
import Actions.WhenSomeAction;
import Utilities.PropertyReader;
import com.tngtech.jgiven.junit5.ScenarioTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest extends ScenarioTest<GivenSomeState, WhenSomeAction, ThenSomeOutcome> {
    private static PropertyReader data = new PropertyReader();
    public static WebDriver webDriver;

    @BeforeAll
    public static void InitializeTest()
    {
        String browserName= data.getBrowser();
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", data.getChromeDriverPath());
                if (data.IsChromeHeadless())
                {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("headless");
                    chromeOptions.addArguments("window-size=1440x900");
                    webDriver = new ChromeDriver(chromeOptions);
                }
                else {
                    webDriver = new ChromeDriver();
                }

                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", data.getfirefoxDriverPath());
                webDriver = new FirefoxDriver();
                break;
            default:
                System.out.println("Invalid browser name from properties file");
                break;
        }
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        if (data.getScreenSize().equals("custom")){
            Dimension d = new Dimension(Integer.parseInt(data.getScreenSizeHeight()),Integer.parseInt(data.getScreenSizeWidth()));
            webDriver.manage().window().setSize(d);
        }else{
            webDriver.manage().window().maximize();
        }
        //DriverFactory.setDriver(webDriver);

        //PageFactory.initElements(webDriver, UsersAndOrganizationsPage.class);
        //PageFactory.initElements(webDriver, WorkFlowTasksPage.class);
        //PageFactory.initElements(webDriver, HomePage.class);
        //PageFactory.initElements(webDriver, LoginPage.class);
        //PageFactory.initElements(webDriver, ApplicationFormPage.class);

    }

    @AfterEach
    public void TearDown()
    {
        webDriver.quit();

    }

    public static void CloseDriver()
    {
        webDriver.close();
    }

    //@AfterAll
    //public static void QuitDriver()
    //{
        //webDriver.quit();
    //}



}
