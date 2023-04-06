package pages;

import base.UIActions;
import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;

public class OrangeHRMLoginPage extends UIActions {
    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginBtn = By.xpath("//button[contains(@type, 'submit')]");

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
