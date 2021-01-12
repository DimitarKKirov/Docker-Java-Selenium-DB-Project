package Selenium.pageObjects.pageObjectsEmag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import Selenium.pageObjects.pManagerEmag.EmagRegularElements;
/**
 * this class represents the Login page of Emag web shop site
 * class with predefined web elements with actions
 * and method set for the current test purposes
 */
public class LoginToEmag extends EmagRegularElements {



    /**
     * using the local driver inherited from EmagRegularElements
     * the method is locating and clicking
     * the user icon button at the landing page
     */
    public void login(){
        Actions action = new Actions(driver);
        WebElement userIcon = driver.findElement(By.xpath("//i[@class=\"em em-user2 navbar-icon\"]"));
            action.moveToElement(userIcon).build().perform();
            userIcon.click();
    }


    /**
     * using the local driver inherited from EmagRegularElements
     * the method is locating the filed for entering the email address of the user
     * and entering the passed string in the field
     * @param email passed string variable that is used
     *              for login to the web site,
     *              it holds the user Email
     */
    public void enterEmail(String email){
      WebElement userEmailField =  driver.findElement(By.xpath("//input[@id=\"user_login_email\"]"));
      userEmailField.click();
      userEmailField.sendKeys(email);
    }


    /**
     * using the local driver inherited from EmagRegularElements
     * the method is locating and clicking
     * the button continue at the login page
     */
    public void clickContinue(){
        WebElement continueButton = driver.findElement(By.xpath("//button[@id=\"user_login_continue\"]"));
        continueButton.click();
    }


    /**
     * using the local driver inherited from EmagRegularElements
     * the method is locating and clicking
     * the filed for entering the user password
     * and entering the passed string in the field
     * @param pass passed string variable that is used
     *             for login to the web site,
     *             it holds the user Password
     */
    public void enterPass(String pass){
        WebElement passField = driver.findElement(By.xpath("//input[@name=\"user_login[password]\"]"));
        passField.click();
        passField.sendKeys(pass);
    }
}
