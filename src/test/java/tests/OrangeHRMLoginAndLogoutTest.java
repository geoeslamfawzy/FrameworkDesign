package tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;

import java.io.IOException;

public final class OrangeHRMLoginAndLogoutTest extends BaseTest{
    private OrangeHRMLoginAndLogoutTest(){}

    @Test(dataProvider = "LoginData")
    public void testLoginAndLogout(String username, String password){
        String title = new OrangeHRMLoginPage()
                .writeUserName(username).writePassword(password).clickOnLogin()
                .clickOnWelcome().logout()
                .getPageTitle();
        Assertions.assertThat(title)
                .as("Title is null").isNotNull()
                .isEqualTo("OrangeHRM");
    }

    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() {
        return new Object[][]{
                {"Admin", "admin123"}
        };
    }
}
