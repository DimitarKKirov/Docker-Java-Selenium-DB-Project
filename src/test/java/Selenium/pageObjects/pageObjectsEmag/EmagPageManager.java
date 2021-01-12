package Selenium.pageObjects.pageObjectsEmag;
/**
 * Singleton initialization of classes
 * EmagPageManager class is class that can be called after the MasterManager class
 * used for instantiating and accessing classes in the project
 * that represents the web pages of Emag web site
 * https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
 */
public class EmagPageManager {


    private LoginToEmag loginToEmag;
    private SearchInEmag searchInEmag;

    /**
     * if there is no instance of class LoginToEmag
     * the method is creating one and returning it
     * otherwise is returning the instance of the class
     * @return LoginToEmag instance
     */
    public LoginToEmag loginToEmag(){
        if (loginToEmag==null){
            loginToEmag = new LoginToEmag();
            return loginToEmag;

        }return loginToEmag;
    }
    /**
     * if there is no instance of class SearchInEmag
     * the method is creating one and returning it
     * otherwise is returning the instance of the class
     * @return SearchInEmag instance
     */
    public SearchInEmag searchInEmag(){
        if (searchInEmag==null){
            searchInEmag = new SearchInEmag();
            return searchInEmag;

        }return searchInEmag;
    }

}
