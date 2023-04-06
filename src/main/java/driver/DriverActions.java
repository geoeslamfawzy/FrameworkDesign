package driver;

import constants.FrameworkConstants;
import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.PropertyUtils;
import utils.SimplePropertyFileReader;

import java.util.Objects;

public final class DriverActions {

    public static void initDriver() throws Exception {
        if (Objects.isNull(DriverManager.getDriver())){
            System.out.println(Thread.currentThread().getName());
            WebDriverManager.chromedriver().setup();
            DriverManager.setDriver(new ChromeDriver());
            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
            DriverManager.getDriver().manage().window().maximize();
        }
    }

    public static void quitDriver() {
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload(); //clean after quit the driver
        }
    }
}
