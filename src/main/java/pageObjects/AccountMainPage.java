package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Logs;
import webElements.single.$;

public class AccountMainPage extends BasePage {

    private final $ continueButton = $(By.xpath("//a[text()='Continue']"));

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
}
