package Selenium.pageObjects.pageObjectLillyShop;
/**
 * Singleton initialization of classes
 * LillyPageManager class is class that can be called after the MasterManager class
 * used for instantiating and accessing classes in the project
 * that represents the web pages of Lilly web site
 * https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
 */
public class LillyPageManager {


    private LillyHomePage lillyHomePage;
    private LillyLoginPage lillyLoginPage;
    private LillyHomeProductsListsPage lillyHomeProductsListsPage;
    private LillyShippingDetailsPage lillyShippingDetailsPage;


    /**
     * if there is no instance of class LillyHomePage
     * the method is creating one and returning it
     * otherwise is returning the instance of the class
     * @return LillyHomePage instance
     */
    public LillyHomePage lillyHomePage(){
        if (lillyHomePage==null){
            lillyHomePage=new LillyHomePage();
            return lillyHomePage;
        }return lillyHomePage;
    }

    /**
     * if there is no instance of class LillyLoginPage
     * the method is creating one and returning it
     * otherwise is returning the instance of the class
     * @return LillyLoginPage instance
     */
    public LillyLoginPage lillyLoginPage(){
        if (lillyLoginPage==null){
            lillyLoginPage= new LillyLoginPage();
            return lillyLoginPage;
        }return lillyLoginPage;
    }

    /**
     * if there is no instance of class LillyShippingDetailsPage
     * the method is creating one and returning it
     * otherwise is returning the instance of the class
     * @return LillyShippingDetailsPage instance
     */
    public LillyShippingDetailsPage lillyShippingDetailsPage(){
        if (lillyShippingDetailsPage==null){
            lillyShippingDetailsPage= new LillyShippingDetailsPage();
            return lillyShippingDetailsPage;
        }return lillyShippingDetailsPage;
    }
    /**
     * if there is no instance of class LillyHomeProductsListsPage
     * the method is creating one and returning it
     * otherwise is returning the instance of the class
     * @return LillyHomeProductsListsPage instance
     */
    public LillyHomeProductsListsPage lillyHomeProductsListsPage(){
        if (lillyHomeProductsListsPage==null){
            lillyHomeProductsListsPage= new LillyHomeProductsListsPage();
            return lillyHomeProductsListsPage;
        }return lillyHomeProductsListsPage;
    }
}
