package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrderForm {
    WebDriver driver= null;

    @FindBy(xpath = "//input[@id='name']")
    WebElement Name_xpath;

    @FindBy(xpath = "//input[contains(@id,'country')]")
    WebElement Country_xpath;

    @FindBy(xpath = "//input[contains(@id,'city')]")
    WebElement City_xpath;

    @FindBy(xpath = "//input[contains(@id,'card')]")
    WebElement CreditCard_xpath;

    @FindBy(xpath = "//input[contains(@id,'month')]")
    WebElement Month_xpath;

    @FindBy(xpath = "//input[contains(@id,'year')]")
    WebElement Year_xpath;

    @FindBy(xpath = "//button[@type='button'][contains(.,'Purchase')]")
    WebElement purchase_xpath;

    @FindBy(xpath = "//h2[contains(.,'Thank you for your purchase!')]")
    WebElement thankYou_xpath;

    @FindBy(xpath = "//button[contains(.,'OK')]")
    WebElement okButton_xpath;

    public OrderForm(WebDriver driver){
        this.driver= driver;

    }
    public OrderForm enterName(String name){
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(Name_xpath));
        Name_xpath.sendKeys(name);
        return this;
    }
    public OrderForm enterCountry(String country){
        Country_xpath.sendKeys(country);
        return this;
    }
    public OrderForm enterCity(String city){
        City_xpath.sendKeys(city);
        return this;
    }
    public OrderForm enterCreditCard(String creditCard){
        CreditCard_xpath.sendKeys(creditCard);
        return this;
    }
    public OrderForm enterMonth(String month){
        Month_xpath.sendKeys(month);
        return this;
    }
    public OrderForm enterYear(String year){
        Year_xpath.sendKeys(year);
        return this;
    }
    public OrderForm submitOrder(){
        purchase_xpath.click();
        return this;
    }
    public void invalidPopUp() throws InterruptedException {
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        Assert.assertEquals(alert.getText(), "Please fill out Name and Creditcard.");
        alert.accept();

    }
    public OrderForm validatePurchase(){
        Assert.assertEquals(thankYou_xpath.getText(),"Thank you for your purchase!");
        return this;
    }
    public void confirmPurchase(){
        okButton_xpath.click();
    }

}
