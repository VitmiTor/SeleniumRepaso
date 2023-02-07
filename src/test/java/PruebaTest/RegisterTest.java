package PruebaTest;

import base.BaseTest;
import data.DataGiver;
import model.UserRegister;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.RegisterAccountPage;
import pageObjects.VerifyRegisterPage;

import static data.DataGiver.invalidInfoDPName;

public class RegisterTest extends BaseTest {

    private RegisterAccountPage registerAccount;
    private VerifyRegisterPage verifyRegisterPage;

    @BeforeMethod
    public void goToAccount() {
        commonFlows.goToRegisterAccount();
    }

    @Test
    public void creatingAccount() {
        final var userRegister = new UserRegister();
        registerAccount.fillingData(userRegister.getFirstName(), userRegister.getLastName(), userRegister.getEmail(),
                userRegister.getTelephone(), userRegister.getPassword(), userRegister.getConfirmPassword());

        verifyRegisterPage.waitPageToLoad();
        verifyRegisterPage.verifyPage();
    }

    @Test(dataProvider = invalidInfoDPName, dataProviderClass = DataGiver.class)
    public void unhappyPath(String firstName, String lastName, String email, String telephone, String password,
                            String confirmPassword, String errorMessage) {

        registerAccount.fillingData(firstName, lastName, email, telephone, password, confirmPassword);
        registerAccount.verifyErrorMessage(errorMessage);
    }

    @Override
    protected void initPages(WebDriver driver) {
        registerAccount = new RegisterAccountPage(driver);
        verifyRegisterPage = new VerifyRegisterPage(driver);
    }
}
