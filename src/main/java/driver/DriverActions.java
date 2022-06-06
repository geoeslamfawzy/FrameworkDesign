package driver;

import constants.FrameworkConstants;
import enums.ConfigProperties;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.PropertyUtils;
import utils.SimplePropertyFileReader;

import java.util.Objects;

public final class DriverActions {

    public static void initDriver() throws Exception {
        if (Objects.isNull(DriverManager.getDriver())){
            System.out.println(Thread.currentThread().getName());
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromePath());
            DriverManager.setDriver(new ChromeDriver()); //This to use the driver-thread child
            //run your test using SimplePropertyFileReader (simple cases)
            //DriverManager.getDriver().get(SimplePropertyFileReader.getValue("url"));

            //open the browser using PropertyReaderUsingMap (good for parallel execution, when use multiple url
            DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
        }
    }

    public static void quitDriver() {
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload(); //clean after quit the driver
        }
    }
}
