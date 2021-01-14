package selenium.steps.remoteShopLillyStepDefinitions;

import selenium.mastePageManager.MasterManager;
import selenium.pageObjects.pageObjectLillyShop.LillyHomeProductsListsPage;
import selenium.pageObjects.pageObjectLillyShop.LillyShippingDetailsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;

public class LillyShippingDetailsRemoteSteps {

    LillyHomeProductsListsPage lillyHomeProducts;
    LillyShippingDetailsPage shippingDetails;
    @Given("the user is in Home products {string}")
    public void productsShoppingList(String shoppingListLink) {
        lillyHomeProducts = MasterManager.getMasterManager().lillyPageManager().lillyHomeProductsListsPage();
        try {
            lillyHomeProducts.remoteConnect(shoppingListLink, "chrome");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String title = lillyHomeProducts.getRemotePageTitle();
        Assert.assertEquals("Лили Дрогерие онлайн магазин | Лили Дрогерие", title);

    }

    @When("he clicks Home products from the left had menu")
    public void goToHomeProducts() {

        lillyHomeProducts.selectRemoteAllProductSubMenuElement("Продукти за дома");
    }

    @Given("add items to the user basket")
    public void addItemsToBasket() {

        try {
            lillyHomeProducts.clickRemoteFirstItemOfList();
            Thread.sleep(7000);

            lillyHomeProducts.clickRemoteSecondItemOfList();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @When("opens the basket")
    public void enterBasket() {
        lillyHomeProducts.openRemoteCart();
    }

    @Given("and clicks checkout")
    public void clickCheckOut() {
        LillyHomeProductsListsPage cartPage = MasterManager.getMasterManager().lillyPageManager().lillyHomeProductsListsPage();
        cartPage.createRemoteWait(10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title=\"Към завършване\"]/span")));
        cartPage.clickRemoteCheckOut();
    }

    @When("user fill the necessary Data {string},{string},{string},{string},{string} and {string}")
    public void fillNecessaryData(String name, String lastName, String phone, String city, String email, String office) {

        shippingDetails = MasterManager.getMasterManager().lillyPageManager().lillyShippingDetailsPage();
        shippingDetails.createRemoteWait(5).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class=\"step-title\"]")));
        shippingDetails.createRemoteWait(15).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@class=\"v-button v-accept\"]")));
        shippingDetails.clickRemoteCookies();
        shippingDetails.enterRemoteEmailToRegister(email);
        shippingDetails.fieldRemoteFirstName(name);
        shippingDetails.fieldRemoteLastName(lastName);
        shippingDetails.fieldRemotePhone(phone);
        shippingDetails.enterRemoteCity(city);
        WebElement elementCity = shippingDetails.createRemoteWait(5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@data-select2-id=\"11\"]")));
        shippingDetails.moveRemoteToElement(elementCity);
        shippingDetails.clickElement(elementCity);
        shippingDetails.enterRemoteAddressShipmentOffice(office);
        WebElement elementOffice = shippingDetails.createRemoteWait(5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@data-select2-id=\"23\"]")));
        shippingDetails.moveRemoteToElement(elementOffice);
        shippingDetails.clickElement(elementOffice);


    }

    @When("pres submit button")
    public void pressContinue() {
//        shippingDetails.moveToElement(shippingDetails.getStepTitle());
        WebElement radioShipping = shippingDetails.createRemoteWait(5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value=\"extensaspeedy_speedy_505\"]")));
        shippingDetails.clickElement(radioShipping);
        shippingDetails.clickRemoteContinue();
    }

    @Then("the user is redirected to the payment page")
    public void redirectedToPaymentPage() {
        String title = shippingDetails.getRemotePageTitle();
        Assert.assertEquals("Поръчай | Лили Дрогерие",title);
        shippingDetails.quitRemoteBrowser();
    }
}
