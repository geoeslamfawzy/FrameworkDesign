package pages;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BasePage {
    protected void clickOn(By locator, WaitStrategy waitStrategy){
        WebElement element =  ExplicitWaitFactory.performExplicitWait(waitStrategy, locator);
        element.click();
    }

    protected void writeIn(String text, By locator, WaitStrategy waitStrategy){
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, locator);
        element.sendKeys(text);
    }

    protected String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }
}
