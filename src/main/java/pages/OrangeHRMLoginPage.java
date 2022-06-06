package pages;

import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;

public class OrangeHRMLoginPage extends BasePage{
    private final By usernameField = By.id("txtUsername");
    private final By passwordField = By.xpath("//input[@id='txtPassword' and @type='password']");
    private final By loginBtn = By.xpath("//input[@name='Submit']");

    public OrangeHRMLoginPage writeUserName(String username){
        writeIn(username, usernameField, WaitStrategy.VISIBLE);
        return this;
    }
    public OrangeHRMLoginPage writePassword(String password){
        writeIn(password, passwordField, WaitStrategy.PRESENCE);
        return this;
    }
    public OrangeHRMHomePage clickOnLogin(){
        clickOn(loginBtn, WaitStrategy.ClICKABLE);
        return new OrangeHRMHomePage();
    }
    public OrangeHRMHomePage loginWith(String username, String password){
        writeUserName(username);
        writePassword(password);
        clickOnLogin();
        return new OrangeHRMHomePage();
    }
    public String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }
}
