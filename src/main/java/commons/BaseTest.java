package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.ConfigReader;

import java.time.Duration;



public class BaseTest {
    public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();


    public WebDriver launchApp(String browser, String url)
    {

        if (browser.equalsIgnoreCase("chrome"))
        {
            //System.setProperty(CHROMEWebdriver, System.getProperty("user.dir")+"/src/chromedriver");
            WebDriverManager.chromedriver().setup();
            threadDriver.set(new ChromeDriver());

        }
        else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
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

    public static WebDriver getDriver()
    {
        return threadDriver.get();
    }
    public void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            threadDriver.remove();
        }
    }

}