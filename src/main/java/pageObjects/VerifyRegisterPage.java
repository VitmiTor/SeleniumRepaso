package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.single.$;

public class VerifyRegisterPage extends BasePage {

    private final $ succesfulMessage = $(By.xpath("//h1[text()=' Your Account Has Been Created!']"));

    public VerifyRegisterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(succesfulMessage, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(succesfulMessage.isDisplayed());
        softAssert.assertAll();
    }
}
