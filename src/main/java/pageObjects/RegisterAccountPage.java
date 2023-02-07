package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.Logs;
import webElements.single.$;

public class RegisterAccountPage extends BasePage {

    private final $ firstNameInput = $(By.id("input-firstname"));
    private final $ lastnameInput = $(By.id("input-lastname"));
    private final $ emailInput = $(By.id("input-email"));
    private final $ phoneInput = $(By.id("input-telephone"));
    private final $ passwordInput = $(By.id("input-password"));
    private final $ confirmPassword = $(By.id("input-confirm"));
    private final $ privacyCheckButton = $(By.cssSelector("label[for='input-agree']"));
    private final $ continueButton = $(By.cssSelector("input[type='submit']"));
    private final $ errorMessage = $(By.className("text-danger"));

    public RegisterAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(firstNameInput, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(firstNameInput.isDisplayed());
        softAssert.assertAll();
    }

    public void fillingData(String name, String lastname, String email, String phoneNumber, String password,
                            String confirmPass) {
        Logs.info("Writing name");
        firstNameInput.sendKeys(name);
        Logs.info("Writing lastname");
        lastnameInput.sendKeys(lastname);
        Logs.info("Writing email");
        emailInput.sendKeys(email);
        Logs.info("Writing cellphone number");
        phoneInput.sendKeys(phoneNumber);
        Logs.info("Writing password");
        passwordInput.sendKeys(password);
        Logs.info("Confirm password");
        confirmPassword.sendKeys(confirmPass);

        Logs.info("Agreeing terms and services");
        privacyCheckButton.click();
        Logs.info("clicking Continue button");
        continueButton.click();
    }

    public void verifyErrorMessage(String error) {
        Logs.info("Verifying error Message");
        errorMessage.waitForVisibility();
        Assert.assertEquals(errorMessage.getText(), error);
    }
}