package Selenium.mastePageManager;


import Selenium.pageObjects.pageObjectLillyShop.LillyPageManager;
import Selenium.pageObjects.pageObjectsEmag.EmagPageManager;
/**
 * Singleton initialization of classes
 * MasterManager class is static class that can be called freely
 * used for instantiating and accessing classes in the project
 * https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
 */
public class MasterManager {

    // Singleton initialization of classes
    // https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples

    private static MasterManager masterManager= new MasterManager();
    private LillyPageManager lillyPageManager;
    private EmagPageManager emagPageManager;

    public static MasterManager getMasterManager() {
        return masterManager;
    }

    /**
     * if there is no instance of class LillyPageManager
     * the method is creating one and returning it
     * otherwise is returning the instance of the class
     * @return LillyPageManager instance
     */
    public LillyPageManager lillyPageManager(){
        if (lillyPageManager==null){
            lillyPageManager = new LillyPageManager();
            return lillyPageManager;
        }return lillyPageManager;
    }

    /**
     * if there is no instance of class EmagPageManager
     * the method is creating one and returning it
     * otherwise is returning the instance of the class
     * @return EmagPageManager instance
     */
    public EmagPageManager emagPageManager(){
        if (emagPageManager==null){
            emagPageManager = new EmagPageManager();
            return emagPageManager;
        }return emagPageManager;
    }
}
