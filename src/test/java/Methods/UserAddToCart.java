package Methods;

import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserAddToCart {
    private WebDriver driver;

    @FindBy(xpath = "//img[@alt='PrestaShop']")
    private WebElement backToMainPage;

    @FindBy(xpath = "//img[@alt='Hummingbird printed t-shirt']")
    private WebElement chooseItem;

    @FindBy(xpath = "//span[@class='discount discount-percentage']")
    private WebElement discount;

    @FindBy(xpath = "//select[@id='group_1']")
    private WebElement selectSize;

    @FindBy(name = "qty")
    private WebElement qty;

    @FindBy(xpath = "//button[@class='btn btn-primary add-to-cart']")
    private WebElement addToCart;

    @FindBy(xpath = "//*[contains(text(), 'Proceed to checkout')]")
    private WebElement firstCheckout;

    @FindBy(xpath = "//*[contains(text(), 'Proceed to checkout')]")
    private WebElement secondCheckout;

    public UserAddToCart(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCart(String size, String number){
        backToMainPage.click();
        chooseItem.click();
        Assert.assertEquals("SAVE 20%", discount.getText());
        Select dropdown = new Select(selectSize);
        dropdown.selectByVisibleText(size);
        qty.click();
        qty.clear();
        qty.sendKeys(number);
        qty.sendKeys(Keys.ENTER);
        firstCheckout.click();
        secondCheckout.click();
    }

}
