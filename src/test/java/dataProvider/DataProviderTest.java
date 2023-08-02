package dataProvider;

import helpers.ExcelHelper;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviderTest {
    @DataProvider(name="loginData_happyScenario")
    public Object[][] getLoginData() throws IOException
    {
        ExcelHelper xl=new ExcelHelper("loginData");
        return xl.getDataFromExcel("Sheet1");
    }

    @DataProvider(name = "loginData_falsePositive")
    public Object[][] loginWithInvalidData() throws IOException {
        ExcelHelper xl = new ExcelHelper("loginData");
        return xl.getDataFromExcel("falsePositive");
    }

}
