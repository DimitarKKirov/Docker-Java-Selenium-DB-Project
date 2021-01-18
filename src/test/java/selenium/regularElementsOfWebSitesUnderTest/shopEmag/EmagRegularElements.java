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


    /**
     * using the remote driver that is set to connect and
     * use the docker standalone chrome/firefox container
     * the method is locating and returning the web element of
     * shop logo for validation
     *
     * @return WebElement of Emag logo
     */
    public WebElement getMsgRemote() {
        return dockerDriver.findElement(By.xpath("//img[@alt=\"eMAG\"]"));
    }


    /**
     * using the remote driver build in method
     * for quiting the current browser
     */
    public void quitRemoteBrowser() {
        dockerDriver.quit();
    }

}
