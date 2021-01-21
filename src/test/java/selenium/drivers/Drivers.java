package selenium.drivers;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class used for creating WebDrivers for the requested web browser
 * this driver class is used only for local testing and
 * uses the requested web browser exe file
 */
public class Drivers implements DriverSwitchBrowser {


    public WebDriver driver;
    public static WebDriver dockerDriver;


    public WebDriver getDriver() {
        return driver;
    }

    public static void setDockerDriver(WebDriver dockerDriver) {
        Drivers.dockerDriver = dockerDriver;
    }



    /*
       method for initialization of a remote web driver
       which driver will be created is based on the passed string for browser name
       after that check of the String browserName is passed the driver is created
       with the needed options,then the method returns the created driver and makes
       connection with the container via the docker url variable and opens the passed
       String variable for Url
    */

    /**
     * method for initialization of a remote web driver
     * which driver will be created is based on the passed string for browser name
     * after that check of the String browserName is passed the driver is created
     * with the needed options,then the method returns the created driver and makes
     * connection with the container via the docker url variable and opens the passed
     * String variable for Url
     *
     * @param url         this parameter hold the passed url String from where
     *                    the method is used, after the driver is instantiated
     *                    the url is opened on the particular browser instance
     * @param browserName hold the String name of the browser that needs to be open
     *                    and its used for a guide to the needed driver instance
     *                    ant its parameters
     * @return the method returns the instantiated driver for further use
     * with his build in methods
     *
     */
    public WebDriver remoteConnect(String url, String browserName) throws MalformedURLException {
        Logger.getLogger("org.openqa.selenium.remote").setLevel(Level.WARNING);

        if (browserName.equalsIgnoreCase("Chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("PlatformName", "Linux");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            URL dockerURL = new URL("http://localhost:4445/wd/hub");
            dockerDriver = new RemoteWebDriver(dockerURL, options);


        } else if (browserName.equalsIgnoreCase("FireFox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            URL dockerURL = new URL("http://localhost:4444/wd/hub");
            dockerDriver = new RemoteWebDriver(dockerURL, options);


        } else if (browserName.equalsIgnoreCase("chromeHeadless")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("PlatformName", "Linux");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--start-maximized");
            options.addArguments("--headless");
            URL dockerURL = new URL("http://localhost:4445/wd/hub");
            dockerDriver = new RemoteWebDriver(dockerURL, options);
        }
        setDockerDriver(dockerDriver);
        dockerDriver.manage().window().maximize();
        dockerDriver.get(url);
        return dockerDriver;

    }
}
