package selenium.steps.remoteShopLillyStepDefinitions;

import selenium.mastePageManager.MasterManager;
import selenium.pageObjects.pageObjectLillyShop.LillyHomePage;
import selenium.pageObjects.pageObjectLillyShop.LillyHomeProductsListsPage;
import selenium.pageObjects.pageObjectLillyShop.LillyLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;

public class LillyHomeProductsListRemoteSteps {

    LillyHomeProductsListsPage lillyHomeProducts;

    @Given("the user is on the {string}")
    public void homePage(String homePage) {
        lillyHomeProducts = MasterManager.getMasterManager().lillyPageManager().lillyHomeProductsListsPage();
        try {
            lillyHomeProducts.remoteConnect(homePage, "chromeheadless");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String title = lillyHomeProducts.getRemotePageTitle();
        Assert.assertEquals("Лили Дрогерие онлайн магазин | Лили Дрогерие", title);
    }
    @Given("the user is logged in with {string} and {string}")
    public void loggedIn(String email, String pass) {
        LillyHomePage home = MasterManager.getMasterManager().lillyPageManager().lillyHomePage();
        LillyLoginPage lillyLogIn = MasterManager.getMasterManager().lillyPageManager().lillyLoginPage();
        home.clickRemoteCookies();
        home.clickRemoteLogin();
        lillyLogIn.createRemoteWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name=\"login[username]\"]")));
        lillyLogIn.emailRemoteField(email);
        lillyLogIn.passRemoteField(pass);
        lillyLogIn.clickRemoteLogin();
    }

    @When("the user clicks Home products from the left had menu")
    public void goToHomeProducts() {

        lillyHomeProducts.selectRemoteAllProductSubMenuElement("Продукти за дома");
    }

    @Then("the user is redirected to the shop list with the corresponding items")
    public void enterShopListHomeItemsPage() {
        String title = lillyHomeProducts.getRemotePageTitle();
        Assert.assertEquals("Продукти за дома | Лили Дрогерие", title);
        lillyHomeProducts.createRemoteWait(7000);
        lillyHomeProducts.quitRemoteBrowser();
    }

    @Given("user is in Home products {string}")
    public void productsShoppingList(String shoppingListLink) {
        lillyHomeProducts = MasterManager.getMasterManager().lillyPageManager().lillyHomeProductsListsPage();
        try {
            lillyHomeProducts.remoteConnect(shoppingListLink, "chromeheadless");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String title = lillyHomeProducts.getRemotePageTitle();
        Assert.assertEquals("Лили Дрогерие онлайн магазин | Лили Дрогерие", title);


    }

    @Given("add items to the basket")
    public void addItemsToBasket() {

        try {
            lillyHomeProducts.clickRemoteFirstItemOfList();
        Thread.sleep(7000);

        lillyHomeProducts.clickRemoteSecondItemOfList();
    }catch (InterruptedException e){
        e.printStackTrace();
        }
    }

    @Given("the total price is calculated correctly for the items in the basket")
    public void basketTotalPriceIsCorrect() {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String price = lillyHomeProducts.getRemotePriceOfCart();
        Assert.assertEquals("56,68 лв.",price);
    }

    @When("the user clicks the basket")
    public void enterBasket() {
        lillyHomeProducts.openRemoteCart();
    }

    @Then("the user is redirected to the shopping cart")
    public void redirectedToShoppingCart() {
        String title = lillyHomeProducts.getRemotePageTitle();
       Assert.assertEquals("Вашата количка | Лили Дрогерие",title);
        lillyHomeProducts.quitRemoteBrowser();
    }
}
