package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ItemCart {
    WebDriver driver = null;


    @FindBy(xpath = "//button[@type='button'][contains(.,'Place Order')]")
    WebElement placeOrder_xpath;

    @FindBy(xpath = "//a[@class='nav-link'][contains(.,'Cart')]")
    WebElement cart_xpath;

    @FindBy(xpath = "//td[contains(.,'MacBook air')]")
    WebElement laptopDetails_xpath;


    public ItemCart(WebDriver driver) {
        this.driver = driver;
    }

    public ItemCart goToCart() {
        cart_xpath.click();
        return this;
    }

    public ItemCart validateCartItem() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(laptopDetails_xpath));
        Assert.assertEquals(laptopDetails_xpath.getText(), "MacBook air");
        return this;
    }

    public ItemCart placeOrder() {
        placeOrder_xpath.click();
        return this;
    }


}
