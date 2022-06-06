package tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.OrangeHRMLoginPage;

public final class OrangeHRMLoginAndLogoutTest extends BaseTest{
    private OrangeHRMLoginAndLogoutTest(){}

    @Test
    public void testLoginAndLogout() throws InterruptedException{
        String title = new OrangeHRMLoginPage()
                .writeUserName("Admin").writePassword("admin123").clickOnLogin()
                .clickOnWelcome().logout()
                .getPageTitle();
        Assertions.assertThat(title)
                .as("Title is null").isNotNull()
                .isEqualTo("OrangeHRM");
    }
}
