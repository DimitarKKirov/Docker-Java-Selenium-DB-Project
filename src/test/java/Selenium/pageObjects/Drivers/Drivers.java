package Selenium.pageObjects.Drivers;

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

/**
 * Class used for creating WebDrivers for the requested web browser
 * this driver class is used only for local testing and
 * uses the requested web browser exe file
 */
public class Drivers implements DriverSwitchBrowser {


    public WebDriver driver;
    public static WebDriver dockerDriver;
    private static String browserName;
    private static String browserDriverPath;
    private static String browserProperty;

    public WebDriver getDriver() {
        return driver;
    }

    public static WebDriver getDockerDriver() {
        return dockerDriver;
    }

    public static void setDockerDriver(WebDriver dockerDriver) {
        Drivers.dockerDriver = dockerDriver;
    }

    private void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    /*
     * depending on the name the method choose which
     * driver properties to load
     */

    /**
     * depending on the name the method choose which
     * driver properties to load
     *
     * @param s comes from the method startBrowser
     *          its holding the name of the browser that
     *          is passed to the startBrowser method
     */
    private void changeBrowser(String s) {
        String path;
        try {
            if (s.equalsIgnoreCase("Chrome")) {
                path = chrome;
            } else {
                path = fireFox;
            }
            Properties tempProp = new Properties();
            tempProp.load(new FileInputStream(path));
            browserName = tempProp.getProperty("browserName");
            browserDriverPath = tempProp.getProperty("browserDriverPath");
            browserProperty = tempProp.getProperty("browserProps");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    /*
     method for initialization of a web driver
     before the driver is created
     the driver properties are loaded based on the name of the browser
     that is checked in the changeBrowser method
     this is only for exe web drivers
    */

    /**
     * method for initialization of a web driver
     * before the driver is created
     * the driver properties are loaded based on the name of the browser
     * that is checked in the changeBrowser method
     * this is only for executable web drivers
     *
     * @param url         this parameter hold the passed url String from where
     *                    the method is used, after the driver is instantiated
     *                    the url is opened on the particular browser instance
     * @param browserName hold the String name of the browser that needs to be open
     *                    and its used for a guide to the needed driver instance
     *                    ant its parameters
     * @return the method returns the instantiated driver for further use
     * with his build in methods
     */
    public WebDriver startBrowser(String url, String browserName) {

        changeBrowser(browserName);

        if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty(browserProperty, browserDriverPath);
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("FireFox")) {
            System.setProperty(browserProperty, browserDriverPath);
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chromeHeadless")) {
            System.setProperty(browserProperty, browserDriverPath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
        driver.get(url);
        setDriver(driver);
        return driver;

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
     * @throws MalformedURLException
     */
    public WebDriver remoteConnect(String url, String browserName) throws MalformedURLException {


        if (browserName.equalsIgnoreCase("Chrome")) {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setPlatform(Platform.LINUX);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("PlatformName", "Linux");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");
            URL dockerURL = new URL("http://localhost:4445/wd/hub");
            dockerDriver = new RemoteWebDriver(dockerURL, options);


        } else if (browserName.equalsIgnoreCase("FireFox")) {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setPlatform(Platform.LINUX);
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");
            URL dockerURL = new URL("http://localhost:4444/wd/hub");
            dockerDriver = new RemoteWebDriver(dockerURL, options);


        } else if (browserName.equalsIgnoreCase("chromeHeadless")) {
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setPlatform(Platform.LINUX);
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
