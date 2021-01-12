package Selenium.pageObjects.pageObjectsEmag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Selenium.pageObjects.pManagerEmag.EmagRegularElements;
/**
 * this class represents the Login page of Emag web shop site
 * class with predefined web elements with actions
 * and method set for the current test purposes
 */
public class SearchInEmag extends EmagRegularElements {


    /**
     * using the local driver inhterited form EmagRegularElements
     * the method is locating and clicking
     * the search field in the landing page
     * and entering the passed string variable
     * @param search passed string variable that is used
     *               as the search criteria
     */
    public void enterInSearchField(String search) {
        WebElement searchField = driver.findElement(By.xpath("//input[@id=\"searchboxTrigger\"]"));
        searchField.click();
        searchField.sendKeys(search);
    }

    /**
     * using the remote driver inhterited form EmagRegularElements
     * that is set to connect and use the docker standalone chrome/firefox container
     * the method is locating and clicking
     * the search field in the landing page
     * and entering the passed string variable
     * @param search passed string variable that is used
     *               as the search criteria
     */
    public void enterInSearchFieldRemote(String search) {
        WebElement searchField = dockerDriver.findElement(By.xpath("//input[@id=\"searchboxTrigger\"]"));
        searchField.click();
        searchField.sendKeys(search);
    }

    /**
     * using the local driver the method is locating and clicking
     * the search button in order the search to be initiated
     */
    public void clickSearch() {
        WebElement searchButton = driver.findElement(By.xpath("//i[@class=\"em em-search\"]"));
        searchButton.click();
    }

    /**
     * using the remote driver that is set to connect and
     * use the docker standalone chrome/firefox container
     * the method is locating and clicking
     * using the local driver the method is locating and clicking
     * the search button in order the search to be initiated
     */
    public void clickSearchRemote() {
        dockerDriver.findElement(By.xpath("//i[@class=\"em em-close\"]")).click();
        WebElement searchButton = dockerDriver.findElement(By.xpath("//i[@class=\"em em-search\"]"));
        searchButton.click();
    }


    /**
     * method for getting the number of results after the search is done
     * @return string of text contained in the web element,
     * used for validating the search
     */
    public String remoteSearchResult() {
       return dockerDriver.findElement(By.xpath("//span[@class=\"title-phrasing title-phrasing-sm\"]")).getText();

    }
}
