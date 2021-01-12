package Selenium.steps.webShopEmag;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Selenium.mastePageManager.MasterManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import Selenium.pageObjects.pageObjectsEmag.LoginToEmag;
import Selenium.pageObjects.pageObjectsEmag.SearchInEmag;

import java.net.MalformedURLException;
import java.util.Set;

public class EmagSearchForItems {

    LoginToEmag emagLoginPage;
    SearchInEmag searchEmag;

    @Given("the user is on in {string}")
    public void the_user_is_logged_in_emag(String link) {
        emagLoginPage = MasterManager.getMasterManager().emagPageManager().loginToEmag();
        try {
            emagLoginPage.remoteConnect(link, "firefox");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        WebElement logo = emagLoginPage.getMsgRemote();
        Assert.assertTrue(logo.isDisplayed());
    }

    @When("user enters search criteria {string}")
    public void userEntersSearchCriteria(String name) {
        searchEmag = MasterManager.getMasterManager().emagPageManager().searchInEmag();
        searchEmag.enterInSearchFieldRemote(name);
        searchEmag.clickSearchRemote();
    }

    @Then("the user can see the results {string}")
    public void the_user_can_see_the_results(String expected) {
        String result = searchEmag.remoteSearchResult();
        Assert.assertEquals(expected, result);


    }
}
