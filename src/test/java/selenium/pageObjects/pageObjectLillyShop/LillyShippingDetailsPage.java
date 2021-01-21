package selenium.pageObjects.pageObjectLillyShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import selenium.regularElementsOfWebSitesUnderTest.shopLilly.LillyRegularsElements;

/**
 * this class represents the Shipping page of Lilly web shop site
 * class with predefined web elements with actions
 * and method set for the current test purposes
 */
public class LillyShippingDetailsPage extends LillyRegularsElements {


    Actions actions;
    Actions remoteAction;


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
     * by using the remote driver
     *
     * @param element passed WebElement class to be hovered
     */
    public void moveRemoteToElement(WebElement element) {
        remoteAction = new Actions(dockerDriver);
        remoteAction.moveToElement(element).build().perform();
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
     * using the remote driver that is set to connect and
     * use the docker standalone chrome/firefox container
     * the method is locating and clicking the ok button for
     * the usage of the cookies
     */
    public void clickRemoteCookies() {
        dockerDriver.findElement(By.xpath("//a[@class=\"v-button v-accept\"]")).click();
    }
}
