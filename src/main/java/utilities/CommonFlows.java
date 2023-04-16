package utilities;

import data.DataGiver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.AccountHomePage;
import pageObjects.AccountMainPage;
import pageObjects.RegisterAccountPage;
import pageObjects.TopBarPage;

public class CommonFlows {
    private final WebDriver driver;

    public CommonFlows(WebDriver driver) {
        this.driver = driver;
    }

    @Step("go to My Account")
    public void goToRegisterAccount() {
        final var topBar = new TopBarPage(driver);
        final var account = new AccountMainPage(driver);
        final var registerAccount = new RegisterAccountPage(driver);
        topBar.waitPageToLoad();
        topBar.clickOnAccount();

        account.waitPageToLoad();
        account.continueClick();

        registerAccount.waitPageToLoad();
    }

    @Step("Login")
    public void loginUser(String user, String password) {
        final var topBar = new TopBarPage(driver);
        final var account = new AccountMainPage(driver);
        final var accountHomePage = new AccountHomePage(driver);
        topBar.waitPageToLoad();
        topBar.clickOnAccount();

        account.waitPageToLoad();
        account.registerAccount(user, password);

        accountHomePage.waitPageToLoad();
        topBar.waitPageToLoad();
    }

    public void loginValidUser() {
        final var credentials = new DataGiver().getValidCredentials();
        loginUser(credentials.getEmail(), credentials.getPassword());
    }

}
