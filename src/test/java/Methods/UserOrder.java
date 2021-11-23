package Methods;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class UserOrder {
    private WebDriver driver;

    @FindBy(name = "confirm-addresses")
    private WebElement confirmAddress;

    @FindBy(id = "delivery_option_2")
    private WebElement chooseDelivery;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement confirmDelivery;

    @FindBy(id = "payment-option-1")
    private WebElement choosePaymentOption;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement approveToConditions;

    @FindBy(css = "button[class='btn btn-primary center-block']")
    private WebElement orderButton;

    @FindBy(className = "account")
    private WebElement account;

    @FindBy(css = "a[id='history-link'] i[class='material-icons']")
    private WebElement orders;

    public UserOrder(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void proceedOrder(){
    confirmAddress.click();
    chooseDelivery.click();
    confirmDelivery.click();
    choosePaymentOption.click();
    approveToConditions.click();
    orderButton.click();
//    account.click();
//    orders.click();
    }
}
