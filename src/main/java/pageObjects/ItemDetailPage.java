package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Logs;
import webElements.single.$;

public class ItemDetailPage extends BasePage {

    private final $ addItem = $(By.xpath("//div[@class='entry-row row align-items-start ']" +
            "//button[@title='Add to Cart']"));
    private final $ increaseItem = $(By.xpath("//div[@class='entry-row row align-items-start ']" +
            "//button[@aria-label='Increase quantity']"));
    private final $ cartNumber = $(By.xpath("//span[text()='1']"));

    public $ getCartNumber(int i) {
        var a = String.valueOf(i);
        return $(By.xpath(String.format("//span[text()='%s']", a)));
    }

    public ItemDetailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(addItem, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(addItem.isDisplayed());
        softAssert.assertAll();
    }

    public void clickOnAddToCart() {
        Logs.info("Clicking on add to cart button");
        addItem.click();
    }

    public void clickOnMoreQuantity(int itemNumber) {
        for (var i = 0; i < itemNumber; i++) {
            increaseItem.click();
        }
    }

    public void verifyCartNumber(int i) {
        getCartNumber(i).waitForVisibility();
        getCartNumber(i).isDisplayed();
    }
}
