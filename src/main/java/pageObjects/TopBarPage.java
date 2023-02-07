package pageObjects;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Logs;
import webElements.single.$;

public class TopBarPage extends BasePage {

    private final $ account = $(By.xpath
            ("//ul[@class='navbar-nav horizontal']//span[contains(text(),'My account')]"));


    public TopBarPage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting Page to load")
    @Override
    public void waitPageToLoad() {
        waitPage(account, this.getClass().getSimpleName());
    }
    
    @Override
    public void verifyPage() {
        softAssert.assertTrue(account.isDisplayed());
        softAssert.assertAll();
    }

    public void clickOnAccount() {
        Logs.info("Clicking on Account Bar");
        account.click();
    }
}
