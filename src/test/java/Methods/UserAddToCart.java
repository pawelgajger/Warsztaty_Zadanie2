package Methods;

import org.junit.Assert;
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

    @FindBy(id = "quantity_wanted")
    private WebElement qty;

    @FindBy(id = "//i[@class='material-icons touchspin-up']")
    private WebElement qty2;

    @FindBy(xpath = "//button[@class='btn btn-primary add-to-cart']")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement checkout;

    public UserAddToCart(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void addToCart(String size, int number){
        backToMainPage.click();
        chooseItem.click();
        Assert.assertEquals("SAVE 20%", discount.getText());
        Select dropdown = new Select(selectSize);
        dropdown.selectByVisibleText(size);
//        qty.clear();
//        qty.sendKeys(number);     //to nie działa

        int i = 1;
        while (i <= number){
            qty2.click();
            i++;                    //to też nie 
        }
        addToCart.click();
        checkout.click();

    }

}
