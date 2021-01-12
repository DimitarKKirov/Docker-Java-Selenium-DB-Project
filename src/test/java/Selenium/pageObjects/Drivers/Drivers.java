package Selenium.pageObjects.Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Class used for creating WebDrivers for the requested web browser
 * this driver class is used only for local testing and
 * uses the requested web browser exe file
 */
public class Drivers implements DriverSwitchBrowser {


    private WebDriver driver;
    private static String browserName;
    private static String browserDriverPath;
    private static String browserProperty;


    private void setDriver(WebDriver driver) {
        this.driver = driver;
    }

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



    /**
     * method for initialization of a web driver
     * before the driver is created
     * the driver properties are loaded based on the name of the browser
     * that is checked in the changeBrowser method
     * this is only for exe web drivers
     *
     * @param url this parameter hold the passed url String from where
     *            the method is used, after the driver is instantiated
     *            the url is opened on the particular browser instance
     * @param browserName hold the String name of the browser that needs to be open
     *                    and its used for a guide to the needed driver instance
     *                    ant its parameters
     *
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
}
