package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.single.$;

public class AccountHomePage extends BasePage {


    public final $ editAccountButton = $(By.xpath("//a[text()=' Edit your account information']"));

    public AccountHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(editAccountButton, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(editAccountButton.isDisplayed());
        softAssert.assertAll();
    }
    
}
