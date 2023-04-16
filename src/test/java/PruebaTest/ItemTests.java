package PruebaTest;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.ItemDetailPage;
import pageObjects.ShopPage;
import pageObjects.TopBarPage;

public class ItemTests extends BaseTest {
    private TopBarPage topBarPage;
    private ShopPage shopPage;
    private ItemDetailPage itemDetailPage;

    @BeforeMethod
    public void setUp() {
        commonFlows.loginValidUser();
    }


    @Test(groups = {smoke})
    public void buyItems() {
        topBarPage.clickOnSearch();
        shopPage.waitPageToLoad();
        shopPage.clickOnItems("Palm Treo Pro");

        itemDetailPage.waitPageToLoad();
        itemDetailPage.clickOnMoreQuantity(3);
        itemDetailPage.clickOnAddToCart();
        itemDetailPage.verifyCartNumber(4);
    }

    @Override
    protected void initPages(WebDriver driver) {
        topBarPage = new TopBarPage(driver);
        shopPage = new ShopPage(driver);
        itemDetailPage = new ItemDetailPage(driver);
    }
}
