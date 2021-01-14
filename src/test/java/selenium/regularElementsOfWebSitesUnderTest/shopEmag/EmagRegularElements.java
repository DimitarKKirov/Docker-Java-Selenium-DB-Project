package selenium.regularElementsOfWebSitesUnderTest.shopEmag;


import selenium.drivers.Drivers;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.drivers.DriverSwitchBrowser;

/**
 * Class used for creating WebDrivers for the requested web browser
 * this driver class is used for local, remote testing and
 * uses the requested web browser exe file and
 * Maven library selenium-remote-driver
 */
public class EmagRegularElements extends Drivers implements DriverSwitchBrowser {

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
     * @param timeOut integer parameter representing the seconds that
     *                the driver will wait
     *
     * @return returning class WebDriverWait for the usage of
     * the build in functionality of the class
     */
    public WebDriverWait createWait(int timeOut) {
        return new WebDriverWait(driver, timeOut);
    }

    /**
     * using the local driver the method is locating and returning the web element of
     * shop logo for validation
     *
     * @return WebElement of Emag logo
     */
    public WebElement getMsg() {
        return driver.findElement(By.xpath("//img[@alt=\"eMAG\"]"));
    }

    /**
     * using the remote driver that is set to connect and
     * use the docker standalone chrome/firefox container
     * the method is locating and returning the web element of
     * shop logo for validation
     * @return WebElement of Emag logo
     */
    public WebElement getMsgRemote() {
        return dockerDriver.findElement(By.xpath("//img[@alt=\"eMAG\"]"));
    }

    /**
     * using the local driver the method is locating and returning a String of
     * the page title that the driver is currently on
     * @return String of the name of page title that the driver
     * is currently on
     */
    public String getPageTitle() {

        return driver.getTitle();
    }


    /**
     * using the local driver the method returning
     * a web element that is corresponding to the passed
     * String argument of an xpath
     * @param xpath xpath for the element that need to be found and returned
     * @return found WebElement returned for further usage
     */
    public WebElement getPageTitleElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    /**
     * using the local driver build in method
     * for quiting the current browser
     */
    public void quitBrowser() {
        driver.quit();
    }

    /**
     * using the remote driver build in method
     * closing the connection to the container instance
     */
    public void remoteClose() {
        dockerDriver.close();
    }


    /**
     * using the remote driver build in method
     * for quiting the current browser
     */
    public void quitRemoteBrowser() {
        dockerDriver.quit();
    }

}
