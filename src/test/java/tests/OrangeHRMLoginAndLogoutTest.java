package tests;

import dataProvider.DataProviderTest;
import helpers.JsonHelper;
import org.assertj.core.api.Assertions;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;

import java.io.IOException;
import java.util.HashMap;

public final class OrangeHRMLoginAndLogoutTest extends BaseTest{
    private OrangeHRMLoginAndLogoutTest(){}

    @Test(dataProviderClass = DataProviderTest.class, dataProvider = "jsonDataaaa")
    public void testLoginAndLogout(String username, String password){
        String title = new OrangeHRMLoginPage()
                .writeUserName(username).writePassword(password).clickOnLogin()
                .clickOnWelcome().logout()
                .getPageTitle();
        Assertions.assertThat(title)
                .as("Title is null").isNotNull()
                .isEqualTo("OrangeHRM");
    }

    @Test(dataProviderClass = DataProviderTest.class, dataProvider = "loginDataFromJson")
    public void testLoginAndLogoutFromJson(HashMap<String, String> credentials) {
        String title = new OrangeHRMLoginPage()
                .writeUserName(credentials.get("username"))
                .writePassword(credentials.get("password"))
                .clickOnLogin()
                .clickOnWelcome()
                .logout()
                .getPageTitle();

        Assertions.assertThat(title)
                .as("Title is null")
                .isNotNull()
                .isEqualTo("OrangeHRM");
    }

//    @DataProvider(name = "test data")
//    public Object[][] getLoginData() {
//        return new Object[][]{
//                {"Admin", "admin123"}git
//        };
//    }

}



