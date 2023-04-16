package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Logs;
import webElements.single.$;

public class AccountMainPage extends BasePage {

    private final $ continueButton = $(By.xpath("//a[text()='Continue']"));
    private final $ emailUser = $(By.id("input-email"));
    private final $ passwordUser = $(By.id("input-password"));
    private final $ buttonLogin = $(By.cssSelector("input[type='submit']"));

    public AccountMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(continueButton, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(continueButton.isDisplayed());
        softAssert.assertAll();
    }

    public void continueClick() {
        Logs.info("Clicking on continue");
        continueButton.click();
    }

    public void registerAccount(String user, String password) {
        Logs.debug("Writing user email");
        emailUser.sendKeys(user);
        Logs.debug("Writing password");
        passwordUser.sendKeys(password);
        Logs.debug("clicking Login Button");
        buttonLogin.click();
    }
}
