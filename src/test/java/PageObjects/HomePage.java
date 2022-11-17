package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class HomePage {

    WebDriver driver = null;

    @FindBy(xpath = "//a[@class='navbar-brand'][contains(.,'PRODUCT STORE')]")
    WebElement ProductStore_xpath;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public void PageVerify(){
        Assert.assertEquals(ProductStore_xpath.getText(),"PRODUCT STORE");

    }
}
