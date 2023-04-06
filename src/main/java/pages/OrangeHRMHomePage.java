package pages;

import base.UIActions;
import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMHomePage {
    UIActions ui = new UIActions();
    private final By welcomeLink = By.xpath("//p[contains(@class, 'oxd-userdropdown-name')]");
    private final By logoutLink = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickOnWelcome() {
        ui.clickOn(welcomeLink, WaitStrategy.ClICKABLE);
        return this;
    }
    public OrangeHRMLoginPage logout(){
        ui.clickOn(logoutLink, WaitStrategy.ClICKABLE);
        return new OrangeHRMLoginPage();
    }
}
