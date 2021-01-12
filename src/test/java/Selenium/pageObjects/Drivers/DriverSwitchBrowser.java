package Selenium.pageObjects.Drivers;

import java.io.File;

/**
 * initialization of path variables for the two web driver properties
 * the properties files load the driver property and
 * the path to the driver exe file
 */
public interface DriverSwitchBrowser {


    File chr= new File("src\\test\\java\\Selenium\\resources\\properties\\Chrome.properties");
    File fF=new File("src\\test\\java\\Selenium\\resources\\properties\\FireFox.properties");
    String chrome = chr.getAbsolutePath();
    String fireFox = fF.getAbsolutePath();
}
