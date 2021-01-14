package selenium.pageObjects.pageObjectLillyShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import selenium.regularElementsOfWebSitesUnderTest.shopLilly.LillyRegularsElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * this class represents the Products page of Lilly web shop site
 * class with predefined web elements with actions
 * and method set for the current test purposes
 */
public class LillyHomeProductsListsPage extends LillyRegularsElements {



    /**
     * using the local driver inherited from class LillyRegularsElements
     * the method is locating the first available item on the list with items
     * hovering over and clicking the buy button of the item
     */
    public void clickFirstItemOfList() {
        WebElement buy = driver.findElement(By.cssSelector("button.action.tocart.primary"));
        Actions action = new Actions(driver);
        action.moveToElement(buy).moveByOffset(3, 5).build().perform();
        buy.click();
    }

    /**
     * using the remote driver inherited from class LillyRegularsElements
     * that is set to connect and use the docker standalone chrome/firefox container
     * is locating the first available item on the list with items
     * hovering over and clicking the buy button of the item
     */
    public void clickRemoteFirstItemOfList() {
        Actions actions = new Actions(dockerDriver);
       List<WebElement> buy = dockerDriver.findElements(By.xpath("//li[@class=\"item product product-item\"]//div[@class=\"actions-primary\"]//form"));
       for (int i=0;i<buy.size();i++){
           WebElement item = buy.get(i);
           if (i==0){
               actions.moveToElement(item).build().perform();
               item.click();
           }
       }
    }

    /**
     * using the local driver inherited from class LillyRegularsElements
     * the method is locating the second available item on the list with items
     * hovering over and clicking the buy button of the item
     */
    public void clickSecondItemOfList() {
        WebElement buy2 = driver.findElement(By.xpath("//li[@class=\"item product product-item\"]//div[@class=\"actions-primary\"]" +
                "//form[contains(@action,\"https://shop.lillydrogerie.bg/checkout/cart/add/uenc/" +
                "aHR0cHM6Ly9zaG9wLmxpbGx5ZHJvZ2VyaWUuYmcvcHJvZHVrdGktemEtZG9tYQ%2C%2C/product/77926/\")]"));
        Actions action = new Actions(driver);
        action.moveToElement(buy2).build().perform();
        buy2.click();
    }

    /**
     * using the remote driver inherited from class LillyRegularsElements
     * that is set to connect and use the docker standalone chrome/firefox container
     * is locating the second available item on the list with items
     * hovering over and clicking the buy button of the item
     */
    public void clickRemoteSecondItemOfList() {
        Actions actions = new Actions(dockerDriver);
        List<WebElement> buy = dockerDriver.findElements(By.xpath("//li[@class=\"item product product-item\"]//div[@class=\"actions-primary\"]//form"));
        for (int i=0;i<buy.size();i++){
            WebElement item = buy.get(i);
            if (i==1){
                actions.moveToElement(item).build().perform();
                item.click();
            }
        }
    }

    /**
     * using the local driver inherited from class LillyRegularsElements
     * the method is locatingthe total price next to the cart icon in the top right corner
     *
     * @return the web element for assertion and
     * further use if needed
     */
    public WebElement getPriceOfCart() {
        Actions actions = new Actions(driver);
        WebElement price = driver.findElement(By.xpath("//span[@class=\"showcart-price\"]//span[@class=\"price\"]"));
        actions.moveToElement(price).build().perform();
        return  price;
    }

    /**
     * using the remote driver inherited from class LillyRegularsElements
     * that is set to connect and use the docker standalone chrome/firefox container
     * the method is locating the total price next to the cart icon in the top right corner
     *
     * @return the web element for assertion and
     *      * further use if needed
     */
    public String getRemotePriceOfCart() {
        dockerDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement price = dockerDriver.findElement(By.xpath("//*[@data-bind=\"text: getValue()\"]"));
        return price.getText();
    }

    /**
     * using the local driver inherited from class LillyRegularsElements
     * the method is locating button for opening the cart and its clicking on it
     * and redirecting to the cart page
     */
    public void openCart() {
        WebElement cart = driver.findElement(By.xpath("//span[text()=\"Количка\"]"));
        Actions action = new Actions(driver);
        action.moveToElement(cart).build().perform();
        cart.click();
    }

    /**
     * using the remote driver inherited from class LillyRegularsElements
     * that is set to connect and use the docker standalone chrome/firefox container
     * the method is locating button for opening the cart and its clicking on it
     * resulting in redirection to the cart page
     */
    public void openRemoteCart() {
        WebElement cart = dockerDriver.findElement(By.xpath("//a[@class=\"action showcart\"]"));
        Actions action = new Actions(dockerDriver);
        cart.click();
    }

    /**
     * using the local driver inherited from class LillyRegularsElements
     * the method is locating button for checking out the items in the cart
     * and its clicking on it resulting in redirection to the next page
     */
    public void clickCheckOut() {
        Actions actions = new Actions(driver);
        WebElement checkOut = driver.findElement(By.xpath("//button[@title=\"Към завършване\"]/span"));
        actions.moveToElement(checkOut).build().perform();
        checkOut.click();
    }


    /**
     * using the remote driver inherited from class LillyRegularsElements
     * that is set to connect and use the docker standalone chrome/firefox container
     * the method is locating button for checking out the items in the cart
     * and its clicking on it
     */
    public void clickRemoteCheckOut() {
        Actions actions = new Actions(dockerDriver);
        WebElement checkOut = dockerDriver.findElement(By.xpath("//button[@title=\"Към завършване\"]/span"));
        actions.moveToElement(checkOut).build().perform();
        checkOut.click();
    }
}
