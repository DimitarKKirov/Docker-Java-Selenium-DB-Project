package Selenium.pageObjects.pageObjectLillyShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import Selenium.pManagers.shopLilly.LillyRegularsElements;

/**
 * this class represents the Shipping page of Lilly web shop site
 * class with predefined web elements with actions
 * and method set for the current test purposes
 */
public class LillyShippingDetailsPage extends LillyRegularsElements {


    Actions actions;
    Actions remoteAction;


    /**
     * using the local driver the method is locating
     * the email field and types the passed String variable
     *
     * @param userEmail passed string variable that is used
     *                  to fill order details and
     *                  it holds the entry of user Email
     */
    public void enterEmailToRegister(String userEmail) {
        WebElement email = driver.findElement(By.xpath("//input[@id=\"customer-email\"]"));
        email.click();
        email.sendKeys(userEmail);
    }

    /**
     * using the remote driver that is set to connect and
     * use the docker standalone chrome/firefox container
     * is locating the email field and types the passed String variable
     *
     * @param userEmail passed string variable that is used
     *                  to fill order details and
     *                  it holds the entry of user Email
     */
    public void enterRemoteEmailToRegister(String userEmail) {
        WebElement email = dockerDriver.findElement(By.xpath("//input[@id=\"customer-email\"]"));
        email.click();
        email.sendKeys(userEmail);
    }

    /**
     * using the local driver the method is locating
     * the Firs Name field and types the passed String variable
     *
     * @param firstName passed string variable that is used
     *                  to fill order details and
     *                  it holds the entry of user First Name
     */
    public void fieldFirstName(String firstName) {
        WebElement name = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
        Actions actions = new Actions(dockerDriver);
        actions.moveToElement(name).build().perform();
        name.click();
        name.sendKeys(firstName);
    }

    /**
     * using the remote driver that is set to connect and
     * use the docker standalone chrome/firefox container
     * is locating the Firs Name field and types the passed String variable
     *
     * @param firstName passed string variable that is used
     *                  to fill order details and
     *                  it holds the entry of user First Name
     */
    public void fieldRemoteFirstName(String firstName) {
        WebElement name = dockerDriver.findElement(By.xpath("//input[@name=\"firstname\"]"));
        name.click();
        name.sendKeys(firstName);
    }

    /**
     * using the local driver the method is locating
     * the Last Name field and types the passed String variable
     *
     * @param lastName passed string variable that is used
     *                 to fill order details and
     *                 it holds the entry of user Last Name
     */
    public void fieldLastName(String lastName) {
        WebElement lastN = driver.findElement(By.xpath("//input[@name=\"lastname\"]"));
        lastN.click();
        lastN.sendKeys(lastName);
    }

    /**
     * using the remote driver that is set to connect and
     * use the docker standalone chrome/firefox container
     * is locating the Last Name field and types the passed String variable
     *
     * @param lastName passed string variable that is used
     *                 to fill order details and
     *                 it holds the entry of user Last Name
     */
    public void fieldRemoteLastName(String lastName) {
        WebElement lastN = dockerDriver.findElement(By.xpath("//input[@name=\"lastname\"]"));
        lastN.click();
        lastN.sendKeys(lastName);
    }

    /**
     * using the local driver the method is locating
     * the Phone field and types the passed String variable
     *
     * @param phoneNumber passed string variable that is used
     *                    to fill order details and
     *                    it holds the entry of user Phone number
     */
    public void fieldPhone(String phoneNumber) {
        WebElement phone = driver.findElement(By.xpath("//input[@name=\"telephone\"]"));
        phone.click();
        phone.sendKeys(phoneNumber);

    }

    /**
     * using the remote driver that is set to connect and
     * use the docker standalone chrome/firefox container
     * is locating the Phone field and types the passed String variable
     *
     * @param phoneNumber passed string variable that is used
     *                    to fill order details and
     *                    it holds the entry of user Phone number
     */
    public void fieldRemotePhone(String phoneNumber) {
        WebElement phone = dockerDriver.findElement(By.xpath("//input[@name=\"telephone\"]"));
        phone.click();
        phone.sendKeys(phoneNumber);

    }


    /**
     * using the local driver the method is locating and clicking
     * the first radio button for shipping the order to a office of Speedy couriers
     */
    public void shippingToOffice() {
        driver.findElement(By.xpath("//input[@name=\"stenik_addrcarrier_method\"]")).click();
    }

    /**
     * using the local driver the method is locating and clicking
     * the second radio button for shipping the order to a home address using Speedy couriers
     */
    public void shippingToHome() {
        driver.findElement(By.xpath("//input[@value=\"speedy_door\"]")).click();
    }

    /**
     * using the local driver the method is locating and clicking
     * dropdown menu for the City that the order will be shipped to
     * and is clicking the second text box
     * and typing the passed string for City name
     *
     * @param city passed string variable that is used
     *             to fill order details and
     *             it holds the entry of user City
     */
    public void enterCity(String city) {

        WebElement cityDrop = driver.findElement(By.xpath("//span[@data-select2-id=\"2\"]"));
        cityDrop.click();
        WebElement cityField = driver.findElement(By.xpath("//input[@class=\"select2-search__field\"]"));
        cityField.click();
        cityField.sendKeys(city);

    }

    /**
     * using the remote driver that is set to connect and
     * use the docker standalone chrome/firefox container
     * the method is locating and clicking
     * dropdown menu for the City that the order will be shipped to
     * and is clicking the second text box
     * and typing the passed string dor City name
     *
     * @param city passed string variable that is used
     *             to fill order details and
     *             it holds the entry of user City
     */
    public void enterRemoteCity(String city) {

        WebElement cityDrop = dockerDriver.findElement(By.xpath("//span[@data-select2-id=\"2\"]"));
        cityDrop.click();
        WebElement cityField = dockerDriver.findElement(By.xpath("//input[@class=\"select2-search__field\"]"));
        cityField.click();
        cityField.sendKeys(city);

    }

    /**
     * using the local driver the method is locating and returning the web element of
     * City dropdown of the page that is with given ID from the xpath
     *
     * @return the method is returning a web element of
     * the search in dropdown City
     */
    public WebElement resultOfCitySearch() {
        return driver.findElement(By.xpath("//li[@data-select2-id=\"11\"]"));
    }

    /**
     * using the local driver the method is locating and returning the web element of
     * Offices dropdown of the page that is with given ID from the xpath
     *
     * @return the method is returning a web element of
     * the search in dropdown Offices
     */
    public WebElement resultOfCityOffice() {
        return driver.findElement(By.xpath("//li[@data-select2-id=\"23\"]"));
    }

    /**
     * using the local driver the method is locating the City dropdown and Address field
     * in the City dropdown is selecting predefined by xpath city
     * and after that is moving to the Address of the field and
     * enters the string value that is passed to the method
     *
     * @param deliveryServiceOffice passed string variable that is used
     *                              to fill order details and
     *                              it holds the entry of
     *                              delivery office address
     */
    public void enterAddressShipmentOffice(String deliveryServiceOffice) {

        WebElement dropDown = driver.findElement(By.xpath("//span[@data-select2-id=\"4\"]"));
        dropDown.click();
        WebElement officeField = driver.findElement(By.xpath("//input[@class=\"select2-search__field\"]"));
        officeField.click();
        officeField.sendKeys(deliveryServiceOffice);

    }

    /**
     * using the remote driver that is set to connect and
     * use the docker standalone chrome/firefox container
     * the method is locating the City dropdown and Address field
     * in the City dropdown is selecting predefined by xpath city
     * and after that is moving to the Address of the field and
     * enters the string value that is passed to the method
     *
     * @param deliveryServiceOffice passed string variable that is used
     *                              to fill order details and
     *                              it holds the entry of
     *                              delivery office address
     */
    public void enterRemoteAddressShipmentOffice(String deliveryServiceOffice) {

        WebElement dropDown = dockerDriver.findElement(By.xpath("//span[@data-select2-id=\"4\"]"));
        dropDown.click();
        WebElement officeField = dockerDriver.findElement(By.xpath("//input[@class=\"select2-search__field\"]"));
        officeField.click();
        officeField.sendKeys(deliveryServiceOffice);

    }


    /**
     * the method receives variable of type web element and clicks it
     *
     * @param element passed WebElement class to be clicked
     */
    public void clickElement(WebElement element) {
        element.click();
    }

    /**
     * the method receives variable of type web element and hovers over it
     * by using the local driver
     *
     * @param element passed WebElement class to be hovered
     */
    public void moveToElement(WebElement element) {
        actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    /**
     * the method receives variable of type web element and hovers over it
     * by using the remote driver
     *
     * @param element passed WebElement class to be hovered
     */
    public void moveRemoteToElement(WebElement element) {
        remoteAction = new Actions(dockerDriver);
        remoteAction.moveToElement(element).build().perform();
    }

    /**
     * using the local driver the method is locating
     * the button continue at the bottom of the page
     * and clicks on it
     */
    public void clickContinue() {

        WebElement buttonContinue = driver.findElement(By.xpath("//button[@class=\"button action continue primary\"]"));
        buttonContinue.click();

    }

    /**
     * using the remote driver that is set to connect and
     * use the docker standalone chrome/firefox container
     * the method is locating the button continue at the bottom of the page
     * and clicks on it
     */
    public void clickRemoteContinue() {

        WebElement buttonContinue = dockerDriver.findElement(By.xpath("//button[@class=\"button action continue primary\"]"));
        buttonContinue.click();

    }

    /**
     * using the local driver the method is locating and returning the web element of
     * the title on top of the fields and dropdowns
     * this title describes what is expected of the client to fill in this page
     *
     * @return the returned WebElement is the title of the shipping step
     * that the user is tacking currently, this method
     * can be used for verification of driver page positioning
     */
    public WebElement getStepTitle() {
        return driver.findElement(By.xpath("//div[@class=\"step-title\"]"));
    }


    /**
     * using the remote driver that is set to connect and
     * use the docker standalone chrome/firefox container
     * the method is locating and returning the web element of
     * the title on top of the fields and dropdowns
     * this title describes what is expected of the client to fill in this page
     *
     * @return the returned WebElement is the title of the shipping step
     * that the user is tacking currently, this method
     * can be used for verification of driver page positioning
     */
    public WebElement getRemoteStepTitle() {
        return dockerDriver.findElement(By.xpath("//div[@class=\"step-title\"]"));
    }

    /**
     * using the local driver the method is locating and returning the web element of
     * delivery service and price for validation
     * @return WebElement
     */
    public WebElement getTypeOfShipping() {
        return driver.findElement(By.xpath("//td[@id=\"label_method_speedy_505_extensaspeedy\"]"));
    }


    /**
     * using the remote driver that is set to connect and
     * use the docker standalone chrome/firefox container
     * the method is locating and clicking the ok button for
     * the usage of the cookies
     */
    public void clickRemoteCookies() {
        dockerDriver.findElement(By.xpath("//a[@class=\"v-button v-accept\"]")).click();
    }
}
