package PageObjects;

import Utils.TakeScreenshot;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

public class ProductsPage {
    WebDriver driver = null;

    @FindBy(xpath = "//a[@href='#'][contains(.,'Laptops')]")
    WebElement laptopsMenu_xpath;

    @FindBy(xpath = "//a[contains(.,'MacBook air')]")
    WebElement device_xpath;

    @FindBy(xpath = "//a[contains(.,'Add to cart')]")
    WebElement addToCart_xpath;

    @FindBy(xpath = "//h2[contains(.,'MacBook air')]")
    WebElement laptopDetails_xpath;

    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }

    public ProductsPage devices(){
        laptopsMenu_xpath.click();
        return this;
    }
    public ProductsPage selectDevice(){
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(device_xpath));
        device_xpath.click();
        return this;

    }
    public ProductsPage addToCart(){
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(addToCart_xpath));
        addToCart_xpath.click();
        return this;
    }
    public ProductsPage verifyProduct() {
        Assert.assertEquals(laptopDetails_xpath.getText(), "MacBook air");
        return this;
    }
    public void productAddedPopUp() throws InterruptedException, IOException {
        Thread.sleep(3000);
        Alert alert= driver.switchTo().alert();
        Thread.sleep(3000);
        Assert.assertEquals(alert.getText(),"Product added");
        //TakeScreenshot.takeSnapShot(driver, "Laptops1");
        alert.accept();
    }


    }

