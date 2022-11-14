package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class OrderForm {
    WebDriver driver= null;

    @FindBy(xpath = "//input[@id='name']")
    WebElement name_xpath;

    @FindBy(xpath = "//input[contains(@id,'country')]")
    WebElement country_xpath;

    @FindBy(xpath = "//input[contains(@id,'city')]")
    WebElement city_xpath;

    @FindBy(xpath = "//input[contains(@id,'card')]")
    WebElement creditCard_xpath;

    @FindBy(xpath = "//input[contains(@id,'month')]")
    WebElement month_xpath;

    @FindBy(xpath = "//input[contains(@id,'year')]")
    WebElement year_xpath;

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
        name_xpath.sendKeys(name);
        return this;
    }
    public OrderForm enterCountry(String country){
        country_xpath.sendKeys(country);
        return this;
    }
    public OrderForm enterCity(String city){
        city_xpath.sendKeys(city);
        return this;
    }
    public OrderForm enterCreditCard(String creditCard){
        creditCard_xpath.sendKeys(creditCard);
        return this;
    }
    public OrderForm enterMonth(String month){
        month_xpath.sendKeys(month);
        return this;
    }
    public OrderForm enterYear(String year){
        year_xpath.sendKeys(year);
        return this;
    }
    public OrderForm submitOrder(){
        purchase_xpath.click();
        return this;
    }
    public void invalidPopUp() {
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Please fill out Name and Creditcard.");
        alert.accept();

    }
    public OrderForm validatePurchase(){
        Assert.assertEquals(thankYou_xpath.getText(),"Thank you for your purchase!");
        return this;
    }
    public OrderForm confirmPurchase(){
        okButton_xpath.click();
        return this;
    }

}
