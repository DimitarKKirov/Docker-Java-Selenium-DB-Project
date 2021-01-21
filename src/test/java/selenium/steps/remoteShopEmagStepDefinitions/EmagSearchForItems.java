package selenium.steps.remoteShopEmagStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import selenium.mastePageManager.MasterManager;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import selenium.pageObjects.pageObjectsEmag.LoginToEmag;
import selenium.pageObjects.pageObjectsEmag.SearchInEmag;

import java.net.MalformedURLException;

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
        searchEmag.quitRemoteBrowser();


    }
}
