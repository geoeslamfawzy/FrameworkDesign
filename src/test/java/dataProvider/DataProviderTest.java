package dataProvider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.FrameworkConstants;
import helpers.ExcelHelper;
import helpers.JsonHelper;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

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
    @DataProvider(name = "loginDataFromJson")
    public Object[][] getData() throws IOException {
        JsonHelper jsonHelper = new JsonHelper("loginData");
        return jsonHelper.getJsonArrayData("userLogins");
    }

}
