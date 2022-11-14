package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductsPage {
    WebDriver driver = null;

    @FindBy(xpath = "//a[@href='#'][contains(.,'Laptops')]")
    WebElement laptopsMenu_xpath;

    @FindBy(xpath = "//a[contains(.,'2017 Dell 15.6 Inch')]")
    WebElement dellLaptop_xpath;

    @FindBy(xpath = "//a[contains(.,'Add to cart')]")
    WebElement addToCart_xpath;

    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }

    public ProductsPage devices(){
        laptopsMenu_xpath.click();
        return this;
    }
    public ProductsPage selectDevice(){
        dellLaptop_xpath.click();
        return this;

    }
    public ProductsPage toCart(){
        addToCart_xpath.click();
        return this;
    }
    public ProductsPage verifyProductAdded(){
        Alert alert= driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Product added");
        alert.accept();
        return this;
    }

}
