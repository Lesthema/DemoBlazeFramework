package Tests;

import Utils.BrowserSetup;
import Utils.TakeScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

@Test
public class ProductOrders extends BaseTests {

    public void HomePageValidation() throws InterruptedException {
        TakeScreenshot.takeSnapShot(driver, "Product Store ");
        homePage
                .PageVerify();

        Thread.sleep(3000);
    }

    public void selectProduct() throws InterruptedException {
        TakeScreenshot.takeSnapShot(driver, "Laptops");
        productsPage
                .devices()
                .selectDevice()
                .toCart()
                .verifyProductAdded();
        Thread.sleep(3000);

    }
    public void validateProductInCart() throws InterruptedException {
        TakeScreenshot.takeSnapShot(driver, "CartItems");
        itemCart
                .goToCart()
                .placeOrder()
                .validateCartItem();
        Thread.sleep(3000);
    }
    public void blankForm() throws InterruptedException {
        TakeScreenshot.takeSnapShot(driver, "Missing form details");
        orderForm
                .enterName(readTestData.name1)
                .enterCountry(readTestData.country1)
                .enterCity(readTestData.city1)
                .enterCreditCard(readTestData.creditCard1)
                .enterMonth(readTestData.month1)
                .enterYear(readTestData.year1)
                .submitOrder()
                .invalidPopUp();
        Thread.sleep(3000);

    }
    @Test(dependsOnMethods = "selectProduct")
    public void FilledForm() throws InterruptedException {
        TakeScreenshot.takeSnapShot(driver, "Confirm Purchase");
        orderForm
                .enterName(readTestData.name)
                .enterCountry(readTestData.country)
                .enterCity(readTestData.city)
                .enterCreditCard(readTestData.creditCard)
                .enterMonth(readTestData.month)
                .enterYear(readTestData.year)
                .submitOrder()
                .validatePurchase()
                .confirmPurchase();
        Thread.sleep(3000);
    }


    @AfterTest
    public void closeBrowser() {
        BrowserSetup.teardown();
    }
}
