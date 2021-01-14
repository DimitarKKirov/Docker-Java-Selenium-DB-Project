package Selenium.pManagers.shopLilly;


import Selenium.pageObjects.Drivers.DriverSwitchBrowser;
import Selenium.pageObjects.Drivers.Drivers;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Class used for creating WebDrivers for the requested web browser
 * this driver class is used for local, remote testing and
 * uses the requested web browser exe file and
 * Maven library selenium-remote-driver
 */
public abstract class LillyRegularsElements extends Drivers implements DriverSwitchBrowser {

    /*
    instantiation of singleton page classes, inheritance of methods of:
    1:MainMenu method for selecting from all products menu
    2:Wait method for all inheriting classes
    3:searching and returning current page title
    4:close tab and close browser methods
    */


    /**
     * using the local driver
     * the method is instantiating a WebDriver wait class
     * that can be use in every
     * page object class of the current Emag test project if need
     * that extends this class
     */

    public WebDriverWait createWait(int timeOut) {
        return new WebDriverWait(driver, timeOut);
    }

    /**
     * using the remote web driver
     * the method is instantiating a WebDriver wait class
     * that can be use in every
     * page object class of the current Emag test project if need
     * that extends this class
     */
    public WebDriverWait createRemoteWait(int timeOut) {
        return new WebDriverWait(dockerDriver, timeOut);
    }

    /**
     * using the local driver
     * the method is locating and clicking
     * on to left hand menu category
     * that is set from passed String variable
     */
    public void selectAllProductSubMenuElement(String name) {
        driver.findElement(By.xpath("//span[text()=\"" + name + "\"]")).click();

    }

    /**
     * using the remote web driver
     * the method is locating and clicking
     * on to left hand menu category
     * that is set from passed String variable
     */
    public void selectRemoteAllProductSubMenuElement(String name) {
        dockerDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement mainMenu = dockerDriver.findElement(By.xpath("//div[@class=\"menu-block\"]"));
        mainMenu.click();
        List<WebElement> subMenu = dockerDriver.findElements(By.xpath("//div[@class=\"menu-block\"]//li/a[@class=\"level-top ui-corner-all\"]"));
        for (int i = 0; i < subMenu.size(); i++) {

            WebElement subm = subMenu.get(i);
            String nameSu = subm.getAttribute("innerHTML");
            if (nameSu.contentEquals("<span class=\"ui-menu-icon ui-icon ui-icon-carat-1-e\"></span><span>" + name + "</span>")) {
                subm.click();
                break;
            }

        }

    }

    /**
     * using the local driver the method
     * is locating and returning a String of
     * the page title that the driver is currently on
     */
    public String getPageTitle() {

        return driver.getTitle();
    }

    /**
     * using the remote web driver the method
     * is locating and returning a String of
     * the page title that the driver is currently on
     */
    public String getRemotePageTitle() {
        return dockerDriver.getTitle();
    }

    /**
     * using the local driver build in method
     * we are quiting it
     * by doing so we are closing the current browser
     */
    public void quitBrowser() {
        driver.quit();
    }

    /**
     * using the remote driver build in method
     * we are closing the connection to the container instance
     */
    public void quitRemoteBrowser() {
        dockerDriver.close();
    }

    /**
     * Agrees to the cookies policy
     */
    public void clickRemoteCookies() {
        dockerDriver.findElement(By.xpath("//a[@class=\"v-button v-accept\"]")).click();
    }
}
