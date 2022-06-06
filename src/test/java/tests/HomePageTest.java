package tests;
import driver.DriverActions;
import driver.DriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

public final class  HomePageTest extends BaseTest{
    private HomePageTest(){}
    /*
        -   Validate whether the title contains google.search
        -   Validate whether the title is not null and the length of title is greater than 15 and less than 100
        -   Check  for the links in the pages --> "Fawzy"
        -   Check if the number of pages is exactly 10 or 15
     */
    @Test
    public void test2(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
    }
    @Test
    public void test3(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Eslam Fawzy", Keys.ENTER);
        String title = DriverManager.getDriver().getTitle();
        Assertions.assertThat(title)
                        .as("The title is null").isNotNull()
                        .as("the title is" + title).containsIgnoringCase("google")
                        .as("the size = "+title.length()).hasSizeBetween(15, 100)
                        .matches("\\w.*"+"google"); //[a-zA-Z0-9]

        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h3/span"));
        Assertions.assertThat(elements)
                        .as("the number of elements = "+elements.size()).hasSizeBetween(5, 15)
                        .extracting(e-> e.getText())
                                .contains("Fawzy");
    }
}
