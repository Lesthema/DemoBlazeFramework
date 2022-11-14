package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ItemCart {
    WebDriver driver = null;


    @FindBy(xpath = "//button[@type='button'][contains(.,'Place Order')]")
    WebElement placeOrder_xpath;

    @FindBy(xpath = "//a[@class='nav-link'][contains(.,'Cart')]")
    WebElement cart_xpath;

    @FindBy(xpath = "//td[contains(.,'2017 Dell 15.6 Inch')]")
    WebElement laptopDetails_xpath;



    public ItemCart(WebDriver driver) {
        this.driver = driver;
    }

    public ItemCart goToCart() {
        cart_xpath.click();
        return this;
    }

    public ItemCart validateCartItem() {
        Assert.assertEquals(laptopDetails_xpath.getText(), "2017 Dell 15.6 Inch");
        return this;
    }

    public ItemCart placeOrder() {
        placeOrder_xpath.click();
        return this;
    }



}
