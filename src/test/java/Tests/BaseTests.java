package Tests;

import PageObjects.*;
import Utils.BrowserSetup;
import Utils.ReadTestData;
import Utils.TakeScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class BaseTests {
    BrowserSetup StartBrowser = new BrowserSetup();
    final WebDriver driver = StartBrowser.startBrowser("chrome","https://www.demoblaze.com/index.html");
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    ItemCart itemCart = PageFactory.initElements(driver,ItemCart.class);
    OrderForm orderForm = PageFactory.initElements(driver, OrderForm.class);
    ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage.class);
    TakeScreenshot takeSnapshot = new TakeScreenshot();

    ReadTestData readTestData;
    {
        try {
            readTestData = new ReadTestData();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
