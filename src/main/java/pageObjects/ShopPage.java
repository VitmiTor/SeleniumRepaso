package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Logs;
import webElements.single.$;

public class ShopPage extends BasePage {

    private final $ itemsBox = $(By.cssSelector("div[class='entry-content content-products order-4 order-md-3']"));

    private $ getItemTitle(String name) {
        return $(By.xpath(String.format("//h4[@class='title']//a[text()='%s']", name)));
    }

    public ShopPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(itemsBox, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(itemsBox.isDisplayed());
        softAssert.assertAll();
    }

    public void clickOnItems(String itemName) {
        Logs.info("Clicking on Item");
        getItemTitle(itemName).click();
    }
}
