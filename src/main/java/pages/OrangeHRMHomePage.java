package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMHomePage {
    private final By welcomeLink = By.id("welcome");
    private final By logoutLink = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickOnWelcome(){
        DriverManager.getDriver().findElement(welcomeLink).click();
        return this;
    }
    public OrangeHRMLoginPage logout(){
        new WebDriverWait(DriverManager.getDriver(), 10)
                .until(ExpectedConditions.elementToBeClickable(logoutLink));
        DriverManager.getDriver().findElement(logoutLink).click();
        return new OrangeHRMLoginPage();
    }
}
