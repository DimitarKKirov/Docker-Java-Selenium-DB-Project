package Selenium.pageObjects.pageObjectLillyShop;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Selenium.pManagers.shopLilly.LillyRegularsElements;

/**
 * this class represents the Home page of Lilly web shop site
 * class with predefined web elements with actions
 * and method set for the current test purposes
 */
public class LillyHomePage extends LillyRegularsElements {


    /**
     * this method finds and clicks the login button
     * that is located on the home page
     * using the local driver class that uses the exe driver file
     */
    public void clickLogin() {
        driver.findElement(By.xpath("//li[@class=\"authorization-link\"]/a")).click();

    }

    /**
     * this method finds and clicks the login button
     * that is located on the home page
     * using the remote driver that is set to connect and
     * use the docker standalone chrome/firefox container
     * class that uses the Maven dependency
     * selenium-remote-driver
     */
    public void clickRemoteLogin() {
        dockerDriver.findElement(By.xpath("//a[@href=\"https://shop.lillydrogerie.bg/customer/account/login/referer/aHR0cHM6Ly9zaG9wLmxpbGx5ZHJvZ2VyaWUuYmcv/\"]")).click();

    }


}


