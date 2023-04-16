package PruebaTest;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjects.AccountMainPage;
import pageObjects.TopBarPage;

public class LoginTest extends BaseTest {

    private TopBarPage topBarPage;
    private AccountMainPage accountMainPage;

    @Test(groups = {smoke})
    public void loginUser() {
        var credentials = dataGiver.getValidCredentials();
        commonFlows.loginUser(credentials.getEmail(), credentials.getPassword());
    }

    @Override
    protected void initPages(WebDriver driver) {
        topBarPage = new TopBarPage(driver);
        accountMainPage = new AccountMainPage(driver);
    }
}
