package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.ConfigReader;

import java.time.Duration;



public class BaseTest {
    public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    private static final String CHROMEWebdriver= "webdriver.chrome.driver";
    private static final String FIREFOXWebdriver= "webdriver.gecko.driver";

    public WebDriver launchApp(String browser, String url)
    {
        ConfigReader.loadProperties();

        if (browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty(CHROMEWebdriver, System.getProperty("user.dir")+"/src/chromedriver");

            threadDriver.set(new ChromeDriver());
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty(FIREFOXWebdriver, System.getProperty("user.dir")+"/src/firefoxdriver");
            threadDriver.set(new FirefoxDriver());
        }
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        System.out.println("****" + browser.toUpperCase() + " Application Launching with URL :: " + url + " *****");
        getDriver().get(url);
        System.out.println("Application Launched Successfully with :" + getDriver().getTitle());
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return getDriver();
    }

    public static synchronized WebDriver getDriver()
    {
        return threadDriver.get();
    }
}