package Tests;

import Utils.BrowserSetup;
import Utils.TakeScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

@Test
public class ProductOrders extends BaseTests {

    public void HomePageValidation() throws InterruptedException, IOException {
        //TakeScreenshot.takeSnapShot(driver, "Product Store ");
        homePage
                .PageVerify();
        TakeScreenshot.takeSnapShot(driver, System.currentTimeMillis()+ "_Product Store ");

    }

    @Test(dependsOnMethods = "HomePageValidation")
    public void selectProduct() throws InterruptedException, IOException {
        // TakeScreenshot.takeSnapShot(driver, "Laptops");
        productsPage
                .devices()
                .selectDevice()
                .addToCart();

        productsPage
                .verifyProduct();
        TakeScreenshot.takeSnapShot(driver,System.currentTimeMillis()+ "_Selected Laptop");
        productsPage
                .productAddedPopUp();
        Thread.sleep(3000);

    }

    @Test(dependsOnMethods = "selectProduct")
    public void validateProductInCart() throws InterruptedException, IOException {

        itemCart
                .goToCart()
                .validateCartItem();
        TakeScreenshot.takeSnapShot(driver,System.currentTimeMillis()+ "_CartItems");
        itemCart
                .placeOrder();
        Thread.sleep(5000);

    }

    @Test(dependsOnMethods = "validateProductInCart")
    public void blankForm() throws InterruptedException, IOException {
        TakeScreenshot.takeSnapShot(driver,System.currentTimeMillis()+ "_Missing details form");
        orderForm
                .submitOrder()
                .invalidPopUp();
        Thread.sleep(3000);

    }

    @Test(dependsOnMethods = "blankForm")
    public void FilledForm() throws InterruptedException, IOException {
        //TakeScreenshot.takeSnapShot(driver, "Confirm Purchase");
        orderForm
                .enterName(readTestData.name)
                .enterCountry(readTestData.country)
                .enterCity(readTestData.city)
                .enterCreditCard(readTestData.creditCard.toString())
                .enterMonth(readTestData.month.toString())
                .enterYear(readTestData.year.toString())
                .submitOrder()
                .validatePurchase();
        TakeScreenshot.takeSnapShot(driver,System.currentTimeMillis()+ "_Confirm Purchase");
        orderForm.
                confirmPurchase();

        Thread.sleep(3000);
        //TakeScreenshot.takeSnapShot(driver, "Confirm Purchase");
    }


    @AfterTest
    public void closeBrowser() {
        BrowserSetup.teardown();
    }
}
